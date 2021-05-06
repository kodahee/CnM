package com.ed.cnm.location.seoul;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ed.cnm.location.LocationTheaterDTO;

@Repository
public class SeoulTheaterDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.ed.cnm.location.seoul.SeoulTheaterDAO.";
	
	
	public List<LocationTheaterDTO> getList(LocationTheaterDTO locationTheaterDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", locationTheaterDTO);
	}
}
