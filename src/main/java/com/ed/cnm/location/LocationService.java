package com.ed.cnm.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LocationService {
	@Autowired
	private LocationDAO locationDAO;
	
	public LocationDTO getSelect(LocationDTO locationDTO)throws Exception{
		return locationDAO.getSelect(locationDTO);
	}
	
//	//==List==
//	public List<LocationTheaterDTO> getList() throws Exception; 
//	//==Select==
//	public LocationTheaterDTO getSelect(LocationTheaterDTO locationDTO)throws Exception;
//	//==Insert==
//	public int setInsert(LocationTheaterDTO locationDTO)throws Exception;
//	//==Delete== 
//	public int setDelete(LocationTheaterDTO locationDTO)throws Exception;
//	//==Update==
//	public int setUpdate(LocationTheaterDTO locationDTO)throws Exception;

}
