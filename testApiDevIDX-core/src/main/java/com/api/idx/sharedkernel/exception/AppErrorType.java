package com.api.idx.sharedkernel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppErrorType {

    UNEXPECTED_ERROR(1, "error.unexpected", "An unexpected error has occurred"),
    WRONG_TYPE(2, "error.wrong_type", "Wrong parameter type"),
    NULL_PARAMETER(3, "error.nll.parameter", "Parameter cannot be null"),
    ENTITY_NOT_FOUND(4, "error.entity.not_found", "The resource cannot be found");

    private final Integer id;

    private final String code;

    private final String detail;

    public AppError createInstance() {
        return AppError.of(this);
    }
}
