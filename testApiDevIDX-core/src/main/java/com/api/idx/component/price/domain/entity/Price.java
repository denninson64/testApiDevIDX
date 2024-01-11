package com.api.idx.component.price.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class Price {

    public static final String ENTITY_NAME = "Price";

    private Integer id;

    private Integer brandId;

    private Integer productId;

    private Instant startDate;

    private Instant endDate;

    private Integer priority;

    private Double price;

    private String currencyIsoCode;
}
