package com.inditex.test.controller;

import com.inditex.test.exception.ValidationException;
import com.inditex.test.model.ProductPriceResponse;
import com.inditex.test.service.ProductPriceService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/product-price")
public class ProductPriceControllerImpl implements ProductPriceController {

    @Autowired
    private ProductPriceService productPriceService;

    @Override
    @GetMapping("/retrieveProductPrice")
    public ProductPriceResponse retrieveProductPriceByParams(
            @RequestParam(name = "applyingDateTime")
            @Schema(name = "applyingDateTime",
                    description = "The applying date time.",
                    example = "2020-06-25 22:15")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime applyingDateTime,
            @RequestParam(name = "productId")
            @Schema(name = "productId",
                    description = "The product identifier.",
                    example = "35455") Integer productId,
            @RequestParam(name = "brandId")
            @Schema(name = "brandId",
                    description = "The brand identifier.",
                    example = "1") Integer brandId) {


        if (applyingDateTime != null && productId != null && brandId != null) {

            return productPriceService.retrieveProductPriceByParams(applyingDateTime, productId, brandId);

        } else {

            throw new ValidationException("The input parameters are malformed");
        }


    }


}
