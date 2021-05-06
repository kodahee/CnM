package com.ed.cnm.booked;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ed.cnm.movie.MovieDTO;

@Repository
public class BookedDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ed.cnm.booked.BookedDAO.";
	
	public MovieDTO getSelect(BookedDTO bookedDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", bookedDTO);
	}
}
