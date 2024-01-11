package com.api.idx.sharedkernel.validation;

import com.api.idx.sharedkernel.exception.AppError;
import com.api.idx.sharedkernel.exception.AppErrorType;
import com.api.idx.sharedkernel.exception.ClientCausedRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public final class Assert {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Assert() {
        super();
    }

    public static void notNullParam(String paramName, Object paramValue) {
        if (paramValue == null) {
            LOGGER.info("Parámetro '{}' obligatorio no informado.", paramName);
            throw new ClientCausedRuntimeException(AppErrorType.NULL_PARAMETER.createInstance()
                    .addMeta(AppError.MetaKeys.PARAM_NAME, paramName));
        }
    }
}
