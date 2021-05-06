package com.ed.cnm.location.seoul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ed.cnm.location.LocationTheaterDTO;

@Service
public class SeoulTheaterService {

	@Autowired
	private SeoulTheaterDAO seoulTheaterDAO;
	
	public List<LocationTheaterDTO> getList(LocationTheaterDTO locationTheaterDTO)throws Exception{
		return seoulTheaterDAO.getList(locationTheaterDTO);
	}
}
