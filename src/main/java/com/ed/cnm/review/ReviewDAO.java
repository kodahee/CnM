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

	public List<ReviewDTO> getList(ReviewDTO reviewDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", reviewDTO);
	}
	
	public int setInsert(ReviewDTO reviewDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", reviewDTO);
	}
	
	public int setDelete(ReviewDTO reviewDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", reviewDTO);
	}

}