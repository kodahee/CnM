package com.ed.cnm;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionTest extends MyAbstractTest {

	@Autowired
	private DataSource dataSource;

	// Main Branch Test

	// Member Test

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(sqlSession);			// true
//		assertNotNull(dataSource.getConnection());		// true
	}

}
