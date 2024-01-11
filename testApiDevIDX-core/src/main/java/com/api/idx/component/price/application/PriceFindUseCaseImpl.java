package com.api.idx.component.price.application;

import com.api.idx.annotations.ApplicationService;
import com.api.idx.annotations.Inject;
import com.api.idx.component.price.domain.entity.Price;
import com.api.idx.component.price.port.PriceFindUseCase;
import com.api.idx.component.price.port.PriceRepository;
import com.api.idx.sharedkernel.validation.Assert;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Instant;

@ApplicationService(readOnly = true)
public class PriceFindUseCaseImpl implements PriceFindUseCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static final String BRAND_ID_PARAM = "brandId";

    public static final String PRODUCT_ID_PARAM = "productId";

    public static final String DATE_PARAM = "date";

    @Setter(onMethod_ = @Inject)
    private PriceRepository priceRepository;

    @Override
    public Price findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId, Instant date) {
        LOGGER.debug("Price query use case by brand, product and date. BrandId: {}, ProductId: {}, Date: {}", brandId, productId, date);
        this.checkParams(brandId, productId, date);
        return this.priceRepository.findByBrandIdAndProductIdAndDate(brandId, productId, date);
    }

    private void checkParams(Integer brandId, Integer productId, Instant date) {
        Assert.notNullParam(BRAND_ID_PARAM, brandId);
        Assert.notNullParam(PRODUCT_ID_PARAM, productId);
        Assert.notNullParam(DATE_PARAM, date);
    }
}
