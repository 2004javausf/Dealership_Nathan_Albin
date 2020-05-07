package com.dealership.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealership.beans.Customer;

public interface CustomerDAO {

/*
 * DAO DESIGN PATTERN
 * -Data Access Object
 * -Modularity and loose coupling
 * -beanDAO (interface) and beanDAOImpl (impl is implementation, concrete class)
 * -want to make sure that the only thing interacting with the db is DAOImpl
 * -DAO is an open interface w/ multiple implementations
 */

	//DAO methods usually deal with CRUD ops!
	
	//Create
	public void insertCustomer(String username, String password, String firstName, String lastName, int creditScore) throws SQLException;
	
	//Read all
	public List<Customer> getCustomerList() throws SQLException;
	
	public void getAccount(String username) throws SQLException;
	
	public void newAccount(String username, String password, String firstName, String lastName, int creditScore) throws SQLException;
	
	public void customerLogin(String username, String password) throws SQLException;
	
	

}
