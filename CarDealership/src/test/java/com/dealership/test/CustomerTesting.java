package com.dealership.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.dealership.daoimpl.CarDAOImpl;
import com.dealership.daoimpl.CustomerDAOImpl;

class CustomerTesting {

	
	@Test
	void getCarsTest() {
		CarDAOImpl cadi = new CarDAOImpl();
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		try {
			String tmp = cadi.getCars();
			Assert.assertTrue(tmp != null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
