package com.api.idx.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {

    private List<ErrorDto> errors;

    public ErrorResponseDto(ErrorDto errorDto) {
        this.errors = Collections.singletonList(errorDto);
    }
}
