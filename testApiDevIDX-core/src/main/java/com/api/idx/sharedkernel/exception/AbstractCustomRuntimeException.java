package com.api.idx.sharedkernel.exception;

import com.api.idx.sharedkernel.constant.Constants;

import java.util.Collections;
import java.util.List;

public abstract class AbstractCustomRuntimeException extends RuntimeException {

    private final List<AppError> errors;

    protected AbstractCustomRuntimeException(AppErrorType errorType) {
        this(errorType.createInstance());
    }

    protected AbstractCustomRuntimeException(AppError error) {
        super(error.getDetail());
        this.errors = Collections.singletonList(error);
    }

    protected AbstractCustomRuntimeException(AppErrorType errorType, Throwable cause) {
        this(errorType.createInstance(), cause);
    }

    protected AbstractCustomRuntimeException(AppError error, Throwable cause) {
        super(error.getDetail(), cause);
        this.errors = Collections.singletonList(error);
    }

    protected AbstractCustomRuntimeException(List<AppError> errors) {
        super(errors.get(Constants.FIRST_ELEMENT).getDetail());
        this.errors = errors;
    }

    protected AbstractCustomRuntimeException(List<AppError> errors, Throwable cause) {
        super(errors.get(Constants.FIRST_ELEMENT).getDetail(), cause);
        this.errors = errors;
    }

    public List<AppError> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
