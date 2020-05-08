package com.dealership.dao;

import java.sql.SQLException;

public interface OfferDAO {

	
	public void createOffer(String username, int carId, double downPmt, int LoanLength) throws SQLException;
	
	public void acceptDenyOffer(String username, int carId) throws SQLException;
	
	public void viewOffers(String username) throws SQLException;
	
	public void makePayment(String username, int carId) throws SQLException;
	
	public void viewAllOffers() throws SQLException;
}
