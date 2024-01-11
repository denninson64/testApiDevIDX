package com.api.idx.rest.error;

import com.api.idx.sharedkernel.exception.AbstractCustomRuntimeException;
import com.api.idx.sharedkernel.exception.AppError;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ErrorDtoMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "errors", target = "errors")
    ErrorResponseDto toDto(AbstractCustomRuntimeException e);

    ErrorDto toDto(AppError error);
}
