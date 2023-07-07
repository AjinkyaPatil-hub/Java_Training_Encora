package com.encora.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.product.model.ProductModel;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel	, Long>{

}
