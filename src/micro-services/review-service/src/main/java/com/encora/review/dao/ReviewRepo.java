package com.encora.review.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.review.model.ReviewModel;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewModel, Long>{

	public List<ReviewModel> findByProductId(Long productId);
}
