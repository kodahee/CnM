package com.ed.cnm.booked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ed.cnm.movie.MovieDTO;

@Service
public class BookedService {
	@Autowired
	private BookedDAO bookedDAO;
	
	public MovieDTO getSelect(BookedDTO bookedDTO)throws Exception{
		return bookedDAO.getSelect(bookedDTO);
	}
	
}
