package com.encora.product.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.product.dao.ProductRepo;
import com.encora.product.dto.ProductDTO;
import com.encora.product.model.ProductModel;
import com.encora.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public ProductDTO getProductInfoById(Long productId) {
		Optional<ProductModel> findById = productRepo.findById(productId);
		if(findById.isPresent()) {
			ProductModel productModel = findById.get();
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(productModel, dto);
			return dto;
		}
		return null;
	}

}
