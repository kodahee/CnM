package com.ed.cnm.location;

import java.util.List;

public interface LocationService {
	//==List==
	public List<LocationDTO> getList() throws Exception; 
	//==Select==
	public LocationDTO getSelect(LocationDTO locationDTO)throws Exception;
	//==Insert==
	public int setInsert(LocationDTO locationDTO)throws Exception;
	//==Delete== 
	public int setDelete(LocationDTO locationDTO)throws Exception;
	//==Update==
	public int setUpdate(LocationDTO locationDTO)throws Exception;

}
