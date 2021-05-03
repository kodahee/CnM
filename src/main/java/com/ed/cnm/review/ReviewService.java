package com.ed.cnm.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;

	public int setInsert(ReviewDTO reviewDTO) throws Exception {
		return reviewDAO.setInsert(reviewDTO);
	}

	public List<ReviewDTO> getList(ReviewDTO reviewDTO) throws Exception {
		return reviewDAO.getList(reviewDTO);
	}
}