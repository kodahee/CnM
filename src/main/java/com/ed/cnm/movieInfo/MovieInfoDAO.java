package com.ed.cnm.movieInfo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieInfoDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ed.cnm.movieInfo.movieInfoDAO.";
	
	public MovieInfoDTO getInfo(MovieInfoDTO movieInfoDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getInfo", movieInfoDTO);
	}
	
	public MovieInfoDTO getCd(MovieInfoDTO movieInfoDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCd", movieInfoDTO);
	}
}
