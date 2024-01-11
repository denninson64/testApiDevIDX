package com.api.idx.sharedkernel.exception;

import java.util.List;

public class ResourceNotFoundRuntimeException extends AbstractCustomRuntimeException {

    public ResourceNotFoundRuntimeException(AppErrorType errorType) {
        super(errorType);
    }

    public ResourceNotFoundRuntimeException(AppError error) {
        super(error);
    }

    public ResourceNotFoundRuntimeException(AppErrorType errorType, Throwable cause) {
        super(errorType, cause);
    }

    public ResourceNotFoundRuntimeException(AppError error, Throwable cause) {
        super(error, cause);
    }

    public ResourceNotFoundRuntimeException(List<AppError> errors) {
        super(errors);
    }

    public ResourceNotFoundRuntimeException(List<AppError> errors, Throwable cause) {
        super(errors, cause);
    }
}
