package com.api.idx.persistence.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.Instant;
import java.util.Optional;

public interface PriceDao extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {

    Optional<PriceEntity> findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Integer brandId, Integer productId, Instant startDate, Instant endDate);
}
