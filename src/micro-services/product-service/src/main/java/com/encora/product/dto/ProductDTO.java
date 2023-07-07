package com.encora.product.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;
	private String productName;
	private String productDescription;
	private Double unitPrice;
	private List<ReviewDTO> reviewList;
	
}
