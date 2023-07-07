package com.encora.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encora.review.dto.ReviewDTO;
import com.encora.review.dto.ReviewWrapperDTO;
import com.encora.review.service.ReviewService;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/review/{productId}")
	public ReviewWrapperDTO fetchReview(@PathVariable ("productId") Long productId) {
	
		return reviewService.fetchReviews(productId);
		
	}
}
