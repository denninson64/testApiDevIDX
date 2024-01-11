package com.api.idx.rest.price;

import com.api.idx.component.price.domain.entity.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {

    PriceDto toDto(Price price);
}
