package com.inditex.test.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Entity class for the prices table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PRICES")
public class Price {

    /**
     * The internal identifier.
     */
    @Id
    @Column(nullable = false, name = "INTERNAL_ID")
    private Integer internalId;
    /**
     * The brand identifier.
     */
    @Column(nullable = false, name = "BRAND_ID")
    private Integer brandId;
    /**
     * The starting range date for the applying rate price.
     */
    @Column(nullable = false, name = "START_DATE")
    private LocalDateTime startDate;
    /**
     * The ending range date for the applying rate price.
     */
    @Column(nullable = false, name = "END_DATE")
    private LocalDateTime endDate;
    /**
     * The rate identifier.
     */
    @Column(nullable = false, name = "PRICE_LIST")
    private Integer priceList;
    /**
     * The product identifier.
     */
    @Column(nullable = false, name = "PRODUCT_ID")
    private Integer productId;
    /**
     * The priority price value in case of coincidence.
     */
    @Column(nullable = false, name = "PRIORITY")
    private Integer priority;
    /**
     * The final price of the product.
     */
    @Column(nullable = false, name = "PRICE")
    private Float price;
    /**
     * The created at auditing field.
     */
    @Column(nullable = false, name = "CREATED_AT")
    private LocalDateTime createdAt;
    /**
     * The created by auditing field.
     */
    @Column(nullable = false, name = "CREATED_BY")
    private String createdBy;
    /**
     * The updated at auditing field.
     */
    @Column(nullable = false, name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    /**
     * The updated by auditing field.
     */
    @Column(nullable = false, name = "UPDATED_BY")
    private String updatedBy;

    /**
     * Function to be used as lambda in a comparator.
     *
     * @return The priority.
     */
    public Integer getPriority() {
        return this.priority;
    }
}
