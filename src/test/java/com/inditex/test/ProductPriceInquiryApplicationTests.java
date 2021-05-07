package com.inditex.test;

import com.inditex.test.model.ProductPriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductPriceInquiryApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();


	@Test
	public void test_1_request_at_10_00_of_the_14th_day_for_product_35455_and_brand_1() {


		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( createURLWithPort("/product-price-inquiry/v1/product-price/retrieveProductPrice"))
				.queryParam("applyingDateTime", "2020-06-14 10:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1");

		ResponseEntity<ProductPriceResponse> result = restTemplate.getForEntity(builder.build().encode().toUri(), ProductPriceResponse.class);

		assert result.getStatusCode() == HttpStatus.OK;

		ProductPriceResponse productPriceResponse = Objects.requireNonNull(result.getBody());

		assert productPriceResponse.getBrandId() == 1;
		assert productPriceResponse.getProductId() == 35455;
		assert productPriceResponse.getPriceList() == 1;
		assert productPriceResponse.getPrice().equals(35.5f);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTimeExpected = "2020-06-14 00:00:00";

		assert productPriceResponse.getStartDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));

		dateTimeExpected = "2020-12-31 23:59:59";
		assert productPriceResponse.getEndDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));


	}

	@Test
	public void test_2_request_at_16_00_of_the_14th_day_for_product_35455_and_brand_1() {


		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( createURLWithPort("/product-price-inquiry/v1/product-price/retrieveProductPrice"))
				.queryParam("applyingDateTime", "2020-06-14 16:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1");

		ResponseEntity<ProductPriceResponse> result = restTemplate.getForEntity(builder.build().encode().toUri(), ProductPriceResponse.class);

		assert result.getStatusCode() == HttpStatus.OK;

		ProductPriceResponse productPriceResponse = Objects.requireNonNull(result.getBody());

		assert productPriceResponse.getBrandId() == 1;
		assert productPriceResponse.getProductId() == 35455;
		assert productPriceResponse.getPriceList() == 1;
		assert productPriceResponse.getPrice().equals(25.45f);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTimeExpected = "2020-06-14 15:00:00";

		assert productPriceResponse.getStartDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));

		dateTimeExpected = "2020-06-14 18:30:00";
		assert productPriceResponse.getEndDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));


	}

	@Test
	public void test_3_request_at_21_00_of_the_14th_day_for_product_35455_and_brand_1() {


		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( createURLWithPort("/product-price-inquiry/v1/product-price/retrieveProductPrice"))
				.queryParam("applyingDateTime", "2020-06-14 21:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1");

		ResponseEntity<ProductPriceResponse> result = restTemplate.getForEntity(builder.build().encode().toUri(), ProductPriceResponse.class);

		assert result.getStatusCode() == HttpStatus.OK;

		ProductPriceResponse productPriceResponse = Objects.requireNonNull(result.getBody());

		assert productPriceResponse.getBrandId() == 1;
		assert productPriceResponse.getProductId() == 35455;
		assert productPriceResponse.getPriceList() == 1;
		assert productPriceResponse.getPrice().equals(35.5f);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTimeExpected = "2020-06-14 00:00:00";

		assert productPriceResponse.getStartDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));

		dateTimeExpected = "2020-12-31 23:59:59";
		assert productPriceResponse.getEndDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));


	}

	@Test
	public void test_4_request_at_10_00_of_the_15th_day_for_product_35455_and_brand_1() {


		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( createURLWithPort("/product-price-inquiry/v1/product-price/retrieveProductPrice"))
				.queryParam("applyingDateTime", "2020-06-15 10:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1");

		ResponseEntity<ProductPriceResponse> result = restTemplate.getForEntity(builder.build().encode().toUri(), ProductPriceResponse.class);

		assert result.getStatusCode() == HttpStatus.OK;

		ProductPriceResponse productPriceResponse = Objects.requireNonNull(result.getBody());

		assert productPriceResponse.getBrandId() == 1;
		assert productPriceResponse.getProductId() == 35455;
		assert productPriceResponse.getPriceList() == 1;
		assert productPriceResponse.getPrice().equals(30.5f);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTimeExpected = "2020-06-15 00:00:00";

		assert productPriceResponse.getStartDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));

		dateTimeExpected = "2020-06-15 11:00:00";
		assert productPriceResponse.getEndDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));


	}

	@Test
	public void test_5_request_at_21_00_of_the_16th_day_for_product_35455_and_brand_1() {


		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( createURLWithPort("/product-price-inquiry/v1/product-price/retrieveProductPrice"))
				.queryParam("applyingDateTime", "2020-06-16 10:00")
				.queryParam("productId", "35455")
				.queryParam("brandId", "1");

		ResponseEntity<ProductPriceResponse> result = restTemplate.getForEntity(builder.build().encode().toUri(), ProductPriceResponse.class);

		assert result.getStatusCode() == HttpStatus.OK;

		ProductPriceResponse productPriceResponse = Objects.requireNonNull(result.getBody());

		assert productPriceResponse.getBrandId() == 1;
		assert productPriceResponse.getProductId() == 35455;
		assert productPriceResponse.getPriceList() == 1;
		assert productPriceResponse.getPrice().equals(38.95f);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTimeExpected = "2020-06-15 16:00:00";

		assert productPriceResponse.getStartDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));

		dateTimeExpected = "2020-12-31 23:59:59";
		assert productPriceResponse.getEndDate().equals(LocalDateTime.parse(dateTimeExpected, formatter));


	}


	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
