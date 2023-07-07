package com.encora.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.encora.product.dto.ProductDTO;
import com.encora.product.dto.ReviewWrapperDTO;
import com.encora.product.service.ProductService;

@RestController
@RequestMapping("/api/v1")
@RefreshScope
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${app.product.discount}")
	private Integer discount;

	@GetMapping("/product/{productId}/{reviewFlag}")
	public ProductDTO getProductInfo(@PathVariable("productId") Long productId,
			@PathVariable("reviewFlag") Boolean reviewFlag) {
		if (reviewFlag) {
			// calling product inforamtion
			ProductDTO productDTO = productService.getProductInfoById(productId);
			// calling review information for that productID
			Double price = productDTO.getUnitPrice();
			price = (price * discount) / 100;
			productDTO.setUnitPrice(productDTO.getUnitPrice() - price);

			ReviewWrapperDTO reviewDTO = restTemplate.getForObject("http://REVIEW-SERVICE/api/v1/review/" + productId,
					ReviewWrapperDTO.class);
			productDTO.setReviewList(reviewDTO.getReviewList());
			return productDTO;
		} else {
			ProductDTO productDTO = productService.getProductInfoById(productId);
			// calling review information for that productID
			Double price = productDTO.getUnitPrice();
			price = (price * discount) / 100;
			productDTO.setUnitPrice(productDTO.getUnitPrice() - price);
			return productDTO;
		}
	}
}
