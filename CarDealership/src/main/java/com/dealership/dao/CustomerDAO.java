package com.dealership.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealership.beans.Customer;

public interface CustomerDAO {

	public void insertCustomer(String username, String password, String firstName, String lastName, int creditScore) throws SQLException;
	
	public List<Customer> getCustomerList() throws SQLException;
	
	public void getAccount(String username) throws SQLException;
	
	public void newAccount() throws SQLException;
	
	public void customerLogin() throws SQLException;
	
	public void employeeLogin() throws SQLException;
	
	

}
