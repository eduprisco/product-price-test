package com.inditex.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Class that represents the response data object for a product price in a applying date asked.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "product_price")
public class ProductPriceResponse {

    /**
     * The product identifier.
     */
    @JsonProperty(value = "product_id")
    @Schema(description = "The product identifier.", example = "35455")
    private Integer productId;
    /**
     * The brand identifier.
     */
    @JsonProperty(value = "brand_id")
    @Schema(description = "The brand identifier.", example = "1")
    private Integer brandId;
    /**
     * The rate.
     */
    @JsonProperty(value = "price_list")
    @Schema(description = "The rate identifier.", example = "3")
    private Integer priceList;
    /**
     * The starting range date for the applying rate price.
     */
    @JsonProperty(value = "start_date")
    @Schema(description = "The starting range date time for the applying rate price.", example = "2020-06-15-16.00.00")
    private LocalDateTime startDate;
    /**
     * The ending range date for the applying rate price.
     */
    @JsonProperty(value = "end_date")
    @Schema(description = "The ending range date time for the applying rate price.", example = "2020-12-31-23.59.59")
    private LocalDateTime endDate;
    /**
     * The applying rate price.
     */
    @JsonProperty(value = "price")
    @Schema(description = "The applying rate price for the product.", example = "38.95")
    private Float price;
}
