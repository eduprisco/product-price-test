package com.inditex.test.controller;

import com.inditex.test.model.ErrorResponse;
import com.inditex.test.model.ProductPriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.time.LocalDateTime;

/**
 * Product price controller interface with operations for retrieving data.
 */
public interface ProductPriceController {
    /**
     * Asks the rate and price info given the brand and product identifiers and the applying date.
     *
     * @param applyingDateTime The applying date and time.
     * @param productId        The product identifier.
     * @param brandId          The brand identifier.
     * @return An object with the rate and price info.
     */
    @Operation(
            summary = "Asks the rate and price info given the brand and product identifiers and the applying date.",
            tags = "product-price",
            description = "Asks the rate and price info.",
            method = "GET",
            parameters = {
                    @Parameter(
                            name = "applyingDateTime",
                            description = "The applying date time.",
                            example = "2020-06-25 22:15"),
                    @Parameter(
                            name = "productId",
                            description = "The product identifier.",
                            example = "35455"),
                    @Parameter(name = "brandId",
                            description = "The brand identifier.",
                            example = "1")})
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(mediaType = "application/json",
                                               schema = @Schema(implementation = ProductPriceResponse.class,
                                                                description = "The product price asked."))),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Server error",
                            content = @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class)))})
    ProductPriceResponse retrieveProductPriceByParams(LocalDateTime applyingDateTime, Integer productId, Integer brandId);
}
