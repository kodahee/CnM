package com.ed.cnm.ranking;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RankingDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ed.cnm.ranking.RankingDAO.";
	
	
	public int setInfo(RankingDTO rankingDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setInfo", rankingDTO);
	}
	
	public int setMovieCd(RankingDTO rankingDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setMovieCd", rankingDTO);
	}
	
	public RankingDTO getInfo(RankingDTO rankingDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getInfo", rankingDTO);
	}
	
	public long getCount(RankingDTO rankingDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCount", rankingDTO);
	}
}
