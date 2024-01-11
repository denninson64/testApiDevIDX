package com.api.idx.rest.error;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
public class ErrorDto {

    private Integer id;

    private String code;

    private String detail;

    private Instant date;

    private Map<String, Object> meta;
}
