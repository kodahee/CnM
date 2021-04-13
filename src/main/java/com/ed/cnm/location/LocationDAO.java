package com.ed.cnm.location;

import java.util.List;



public interface LocationDAO {

	//==List==
	public List<LocationTheaterDTO> getList()throws Exception;
	//==Select==
	public LocationTheaterDTO getSelect(LocationTheaterDTO locationDTO)throws Exception;
	//==Insert==
	public int setInsert(LocationTheaterDTO locationDTO)throws Exception;
	//==Delete==
	public int setDelete(LocationTheaterDTO locationDTO)throws Exception;
	//==Update==
	public int setUpdate(LocationTheaterDTO locationDTO)throws Exception;
	//==insertFile
	
}
