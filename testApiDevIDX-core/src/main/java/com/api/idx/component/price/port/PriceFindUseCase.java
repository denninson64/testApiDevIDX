package com.api.idx.component.price.port;

import com.api.idx.component.price.domain.entity.Price;

import java.time.Instant;

public interface PriceFindUseCase {

    Price findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId, Instant date);
}
