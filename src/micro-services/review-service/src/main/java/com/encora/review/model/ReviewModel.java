package com.encora.review.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_review")
@Data
public class ReviewModel {

	@Id
	private Long id;
	private Long productId;
	private Long userId;
	private String review;
}
