package com.ed.cnm.review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.ed.cnm.review.ReviewDAO.";

	public int setInsert(ReviewDTO reviewDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", reviewDTO);
	}

	public List<ReviewDTO> getList(ReviewDTO reviewDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", reviewDTO);
	}

}