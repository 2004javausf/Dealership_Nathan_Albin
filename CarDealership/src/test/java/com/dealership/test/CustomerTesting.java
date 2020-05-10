package com.dealership.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.dealership.daoimpl.CustomerDAOImpl;

class CustomerTesting {

	
	@Test
	void customerLoginTest() {
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		try {
			cdi.customerLogin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
