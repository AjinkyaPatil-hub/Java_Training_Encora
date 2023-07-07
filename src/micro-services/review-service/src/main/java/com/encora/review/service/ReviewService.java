package com.encora.review.service;

import java.util.List;

import com.encora.review.dto.ReviewDTO;
import com.encora.review.dto.ReviewWrapperDTO;

public interface ReviewService {

	public ReviewWrapperDTO fetchReviews(Long productId);
}
