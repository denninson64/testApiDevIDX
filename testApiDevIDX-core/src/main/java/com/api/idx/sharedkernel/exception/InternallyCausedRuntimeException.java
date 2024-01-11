package com.api.idx.sharedkernel.exception;

import java.util.List;

public class InternallyCausedRuntimeException extends AbstractCustomRuntimeException {

    public InternallyCausedRuntimeException(AppErrorType errorType) {
        super(errorType);
    }

    public InternallyCausedRuntimeException(AppError error) {
        super(error);
    }

    public InternallyCausedRuntimeException(AppErrorType errorType, Throwable cause) {
        super(errorType, cause);
    }

    public InternallyCausedRuntimeException(AppError error, Throwable cause) {
        super(error, cause);
    }

    public InternallyCausedRuntimeException(List<AppError> errors) {
        super(errors);
    }

    public InternallyCausedRuntimeException(List<AppError> errors, Throwable cause) {
        super(errors, cause);
    }
}
