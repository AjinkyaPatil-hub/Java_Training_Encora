package com.encora.product.service;

import com.encora.product.dto.ProductDTO;

public interface ProductService {
	
	public ProductDTO getProductInfoById(Long productId);
}
