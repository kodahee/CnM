package com.ed.cnm.location;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.ed.cnm.location.LocationDAO.";
	
	public LocationDTO getSelect(LocationDTO locationDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getSelect", locationDTO);
	}
//	//==List==
//	public List<LocationTheaterDTO> getList()throws Exception;
//	//==Select==
//	public LocationTheaterDTO getSelect(LocationTheaterDTO locationDTO)throws Exception;
//	//==Insert==
//	public int setInsert(LocationTheaterDTO locationDTO)throws Exception;
//	//==Delete==
//	public int setDelete(LocationTheaterDTO locationDTO)throws Exception;
//	//==Update==
//	public int setUpdate(LocationTheaterDTO locationDTO)throws Exception;
//	//==insertFile
//	
}
