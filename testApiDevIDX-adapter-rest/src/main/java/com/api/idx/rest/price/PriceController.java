package com.api.idx.rest.price;

import com.api.idx.annotations.Inject;
import com.api.idx.rest.constant.ApiParams;
import com.api.idx.rest.constant.ApiPaths;
import com.api.idx.component.price.domain.entity.Price;
import com.api.idx.component.price.port.PriceFindUseCase;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.time.Instant;

@RestController
@RequestMapping(ApiPaths.Price.BASE)
public class PriceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Setter(onMethod_ = @Inject)
    private PriceFindUseCase priceFindUseCase;

    @Setter(onMethod_ = @Inject)
    private PriceDtoMapper priceDtoMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDto> findByBrandIdAndProductIdAndDate(
            @RequestParam(name = ApiParams.Price.BRAND_ID) Integer brandId,
            @RequestParam(name = ApiParams.Price.PRODUCT_ID) Integer productId,
                @RequestParam(name = ApiParams.Price.DATE) Instant date) {
        LOGGER.debug("Se recibe petición de consulta de precio por marca, producto y fecha. BrandId: {}, ProductId: {}, Date: {}",
                brandId, productId, date);
        Price price = this.priceFindUseCase.findByBrandIdAndProductIdAndDate(brandId, productId, date);
        return ResponseEntity.ok(this.priceDtoMapper.toDto(price));
    }
}
