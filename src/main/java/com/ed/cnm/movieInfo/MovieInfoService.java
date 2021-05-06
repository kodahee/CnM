package com.ed.cnm.movieInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoService {
	@Autowired
	private MovieInfoDAO movieInfoDAO;
	
	public MovieInfoDTO getInfo(MovieInfoDTO movieInfoDTO)throws Exception{
		return movieInfoDAO.getInfo(movieInfoDTO);
	}
	
	public MovieInfoDTO getCd(MovieInfoDTO movieInfoDTO)throws Exception{
		return movieInfoDAO.getCd(movieInfoDTO);
	}
}
