package com.api.idx.sharedkernel.exception;

import lombok.Getter;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AppError {

    @Getter
    private final Integer id;

    @Getter
    private final String code;

    @Getter
    private final String detail;

    @Getter
    private final Instant date = Instant.now();

    private final Map<String, Object> meta = new HashMap<>();

    public AppError(AppErrorType errorType) {
        this.id = errorType.getId();
        this.code = errorType.getCode();
        this.detail = errorType.getDetail();
    }

    public static AppError of(AppErrorType errorType) {
        return new AppError(errorType);
    }

    public Map<String, Object> getMeta() {
        return Collections.unmodifiableMap(this.meta);
    }

    public AppError addMeta(String key, Object value) {
        meta.put(key, value);
        return this;
    }

    public AppError addMultipleMeta(String key, Object... values) {
        meta.put(key, values);
        return this;
    }

    public static final class MetaKeys {

        public static final String PARAM_NAME = "parameterName";

        public static final String ENTITY_NAME = "entityName";

        public static final String FIELD_NAMES = "fieldNames";

        public static final String FIELD_VALUES = "fieldValues";

        private MetaKeys() {
            super();
        }
    }
}
