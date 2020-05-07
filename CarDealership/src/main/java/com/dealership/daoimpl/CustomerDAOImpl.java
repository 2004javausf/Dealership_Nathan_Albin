package com.dealership.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.dealership.beans.Customer;
import com.dealership.dao.CustomerDAO;
import com.dealership.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {

	public static ConnFactory cf = ConnFactory.getFactoryInstance();
	
	//adds new customer to database
	@Override
	public void insertCustomer(String username, String password, String firstName, String lastName, int creditScore)
			throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO CUSTOMER VALUES('" + username + "','" + password + "','" + firstName + "','" + lastName + "'," + creditScore + ")";
		stmt.executeUpdate(sql);
	}
	//returns list containing all customer info
	@Override
	public List<Customer> getCustomerList() throws SQLException {
		
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
		Customer s = null;
		while(rs.next()) {
			s = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			customerList.add(s);
		}
		
		return customerList;
		
	}

	//prints users account info
	@Override
	public void getAccount(String username) throws SQLException {
		List<Customer> accountList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Customer WHERE USERNAME ='" + username + "'");
		Customer s = null;
		while(rs.next()) {
			s = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			accountList.add(s);
		}
		System.out.println(accountList);
	}
	//adds new account to database
	@Override
	public void newAccount(String username, String password, String firstName, String lastName, int creditScore)
			throws SQLException {
		insertCustomer(username, password, firstName, lastName, creditScore);
		System.out.println("Account successfully created!");
		
	}
	//verifies login info for customer
	@Override
	public void customerLogin(String username, String password) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT USERNAME, PASSWORD FROM CUSTOMER WHERE USERNAME = '" + username + "' AND PASSWORD =  '" + password + "'");
		
		if(rs.next() == false) {
			System.out.println("Invalid login info..");
			
		} else {
			System.out.println("Login success!");	
		}
	}
	

	
	
}
