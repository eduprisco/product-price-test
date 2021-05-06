package com.inditex.test.domain.repository;

import com.inditex.test.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    @Query("SELECT p FROM PRICES p WHERE p.productId = :product AND p.brandId = :brand AND :applyingDateTime >= p.startDate AND :applyingDateTime <= p.endDate")
    List<Price> findProductPricesByProductBrandAndDateTime(
            @Param("product") Integer productId,
            @Param("brand") Integer brandId,
            @Param("applyingDateTime") LocalDateTime applyingDateTime
    );
}
