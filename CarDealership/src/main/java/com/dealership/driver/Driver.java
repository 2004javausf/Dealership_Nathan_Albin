package com.dealership.driver;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.dealership.daoimpl.CarDAOImpl;
import com.dealership.daoimpl.CustomerDAOImpl;
import com.dealership.daoimpl.OfferDAOImpl;

public class Driver {
	

	public static void main(String[] args) {
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		CarDAOImpl cadi = new CarDAOImpl();
		OfferDAOImpl odi = new OfferDAOImpl();

//		try {
//			cadi.insertCar(125, "Tesla", "Model S", "Black", 2019, 75000, "Available");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			cdi.newAccount("samsora", "1234", "Chris", "Kennedy", 845);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			odi.createOffer("depther", 125, 45000, 24);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		try {
			odi.acceptDenyOffer("samsora", 125);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
