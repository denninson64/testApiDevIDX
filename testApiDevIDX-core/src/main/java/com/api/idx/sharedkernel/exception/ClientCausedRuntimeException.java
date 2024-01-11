package com.api.idx.sharedkernel.exception;

import java.util.List;

public class ClientCausedRuntimeException extends AbstractCustomRuntimeException {

    public ClientCausedRuntimeException(AppErrorType errorType) {
        super(errorType);
    }

    public ClientCausedRuntimeException(AppError error) {
        super(error);
    }

    public ClientCausedRuntimeException(AppErrorType errorType, Throwable cause) {
        super(errorType, cause);
    }

    public ClientCausedRuntimeException(AppError error, Throwable cause) {
        super(error, cause);
    }

    public ClientCausedRuntimeException(List<AppError> errors) {
        super(errors);
    }

    public ClientCausedRuntimeException(List<AppError> errors, Throwable cause) {
        super(errors, cause);
    }
}
