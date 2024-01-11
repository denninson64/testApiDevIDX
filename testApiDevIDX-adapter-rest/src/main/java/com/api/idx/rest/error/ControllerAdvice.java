package com.api.idx.rest.error;

import com.api.idx.annotations.Inject;
import com.api.idx.sharedkernel.exception.*;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.lang.invoke.MethodHandles;

@RestControllerAdvice
public class ControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Setter(onMethod_ = @Inject)
    private ErrorDtoMapper errorDtoMapper;

    @ExceptionHandler(ClientCausedRuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleClientCausedRuntimeException(ClientCausedRuntimeException e) {
        LOGGER.warn("The customer has made an incorrect request.", e);
        ErrorResponseDto errorResponse = this.errorDtoMapper.toDto(e);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(InternallyCausedRuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleInternallyCausedRuntimeException(InternallyCausedRuntimeException e) {
        LOGGER.error("A controlled error has occurred.", e);
        ErrorResponseDto errorResponse = this.errorDtoMapper.toDto(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundRuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundRuntimeException(ResourceNotFoundRuntimeException e) {
        LOGGER.warn("The requested resource has not been found.", e);
        ErrorResponseDto errorResponse = this.errorDtoMapper.toDto(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler({BindException.class, MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponseDto> handleBindingExceptions(Exception e) {
        LOGGER.info("Customer has made an incorrect request and spring has given error.", e);
        AppError error = AppErrorType.WRONG_TYPE.createInstance()
                .addMeta("message", e.getMessage());
        return ResponseEntity.badRequest().body(new ErrorResponseDto(this.errorDtoMapper.toDto(error)));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleRuntimeException(RuntimeException e) {
        LOGGER.error("An unexpected error has occurred.", e);
        AppError error = AppErrorType.UNEXPECTED_ERROR.createInstance()
                .addMeta("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponseDto(this.errorDtoMapper.toDto(error)));
    }
}
