package com.api.idx.persistence.price;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @Column(name = "PRICE_LIST", nullable = false)
    private Integer id;

    @Column(name = "BRAND_ID", nullable = false)
    private Integer brandId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "START_DATE", nullable = false)
    private Instant startDate;

    @Column(name = "END_DATE", nullable = false)
    private Instant endDate;

    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "CURR", nullable = false)
    private String currencyIsoCode;
}
