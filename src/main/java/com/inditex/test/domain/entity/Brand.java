package com.inditex.test.domain.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Entity class for brands table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BRANDS")
public class Brand {

    /**
     * The brand identifier.
     */
    @Id
    @Column(nullable = false, name = "BRAND_ID")
    private Integer brandId;
    /**
     * The brand description.
     */
    @Column(nullable = false, name = "BRAND_DESC")
    private String brandDesc;
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
}
