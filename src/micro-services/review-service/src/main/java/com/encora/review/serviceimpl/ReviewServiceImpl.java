package com.encora.review.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.review.dao.ReviewRepo;
import com.encora.review.dto.ReviewDTO;
import com.encora.review.dto.ReviewWrapperDTO;
import com.encora.review.model.ReviewModel;
import com.encora.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;

	@Override
	public ReviewWrapperDTO fetchReviews(Long productId) {
		ReviewWrapperDTO reviewWrapperDTO = new ReviewWrapperDTO();
		List<ReviewModel> listOfReviewModel = reviewRepo.findByProductId(productId);
		List<ReviewDTO> reviewDTOList = new ArrayList<>(listOfReviewModel.size());

		for (ReviewModel review : listOfReviewModel) {
			ReviewDTO dto = new ReviewDTO();
			BeanUtils.copyProperties(review, dto);
			reviewDTOList.add(dto);
		}
		reviewWrapperDTO.setReviewList(reviewDTOList);
		return reviewWrapperDTO;
	}

}
