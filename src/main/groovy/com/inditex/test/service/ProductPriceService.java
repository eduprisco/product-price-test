package com.inditex.test.service;

import com.inditex.test.domain.entity.Price;
import com.inditex.test.domain.repository.PriceRepository;
import com.inditex.test.exception.AmbiguityException;
import com.inditex.test.exception.NotFoundException;
import com.inditex.test.model.ProductPriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductPriceService {

    @Autowired
    PriceRepository priceRepository;

    /**
     * Method that given the necessary data (date, product and brand), requests to the price repository the price list
     * for a product in a moment and if results are found, return the price with the higher priority.
     *
     * @param applyingDateTime The applying moment.
     * @param productId The product identifier.
     * @param brandId The brand identifier.
     * @return An object that represents the price with the higher priority
     */
    public ProductPriceResponse retrieveProductPriceByParams(
            LocalDateTime applyingDateTime, Integer productId, Integer brandId) {

        List<Price> priceList =
                priceRepository.findProductPricesByProductBrandAndDateTime(productId, brandId, applyingDateTime);

        if (!priceList.isEmpty()) {

            Price priorPrice = priceList
                                    .stream()
                                    .max(Comparator.comparing(Price::getPriority))
                                    .orElseThrow(() -> new AmbiguityException("To much prices with the same priority"));

            return new ProductPriceResponse(
                            priorPrice.getProductId(),
                            priorPrice.getBrandId(),
                            priorPrice.getPriceList(),
                            priorPrice.getStartDate(),
                            priorPrice.getEndDate(),
                            priorPrice.getPrice());

        } else {

            throw new NotFoundException("No prices found for the input parameters: " +
                    "ApplyingDateTime: " + applyingDateTime + " Product: " + productId + " Integer  " +  brandId);
        }



    }

}
