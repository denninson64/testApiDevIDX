package com.api.idx.rest.price;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class PriceDto {

    private Integer id;

    private Integer brandId;

    private Integer productId;

    private Instant startDate;

    private Instant endDate;

    private Double price;

    private String currencyIsoCode;
}
