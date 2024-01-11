package com.api.idx.persistence.price;

import com.api.idx.annotations.Inject;
import com.api.idx.component.price.domain.entity.Price;
import com.api.idx.component.price.port.PriceRepository;
import com.api.idx.sharedkernel.exception.AppError;
import com.api.idx.sharedkernel.exception.AppErrorType;
import com.api.idx.sharedkernel.exception.ResourceNotFoundRuntimeException;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.lang.invoke.MethodHandles;
import java.time.Instant;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Setter(onMethod_ = @Inject)
    private PriceDao priceDao;

    @Setter(onMethod_ = @Inject)
    private PriceEntityMapper priceEntityMapper;

    @Override
    public Price findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId, Instant date) {
        LOGGER.debug("A price selector will be launched by brand, product and date. BrandId: {}, ProductId: {}, Date: {}", brandId, productId, date);
        return this.priceDao.findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, date, date)
                .map(this.priceEntityMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundRuntimeException(AppErrorType.ENTITY_NOT_FOUND.createInstance()
                        .addMeta(AppError.MetaKeys.ENTITY_NAME, Price.ENTITY_NAME)
                        .addMultipleMeta(AppError.MetaKeys.FIELD_NAMES,
                                PriceEntity_.BRAND_ID, PriceEntity_.PRODUCT_ID, PriceEntity_.START_DATE, PriceEntity_.END_DATE)
                        .addMultipleMeta(AppError.MetaKeys.FIELD_VALUES,
                                brandId, productId, date, date)));
    }
}
