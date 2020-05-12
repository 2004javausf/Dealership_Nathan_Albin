package com.dealership.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dealership.beans.Car;
import com.dealership.dao.CarDAO;
import com.dealership.util.ConnFactory;
import com.dealership.util.LogMe;

public class CarDAOImpl implements CarDAO {

	public static ConnFactory cf = ConnFactory.getFactoryInstance();
	
	//adds car to database
	@Override
	public void insertCar() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Scanner scc = new Scanner(System.in);
		Scanner sccc = new Scanner(System.in);
		System.out.println("Enter make");
		String make = sc.nextLine();
		System.out.println("Enter model");
		String model = sc.nextLine();
		System.out.println("Enter color");
		String color = sc.nextLine();
		System.out.println("Enter year");
		int year = scc.nextInt();
		System.out.println("Enter price");
		double cost = sccc.nextDouble();
				
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO CAR VALUES(MYSEQ2.NEXTVAL" + ",'" + make + "','" + model + "','" + color + "'," + year + "," + cost + ", 'Available', NULL)";
		stmt.executeUpdate(sql);
		LogMe.logThis("info", "Car added to lot: Make = " + make + ", Model = " + model + ", Color = " + color + ", Year = " + year + ", Cost = " + cost);
	}
	//returns string of all available cars for customer
	@Override
	public String getCars() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CAR_ID, MAKE, CAR_MODEL, COLOR, CAR_YEAR, CAR_COST FROM CAR WHERE PURCHASE_STATUS = 'Available'");
		Car s = null;
		String tmp = "";
		while(rs.next()) {
			s = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
			tmp = s.toString2();
			System.out.println(tmp);
		}
		return tmp;
	}
	//returns list of all cars in database for employee
	@Override
	public List<Car> getAllCars() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR");
		Car s = null;
		while(rs.next()) {
			s = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getString(7), rs.getString(8));
			carList.add(s);
			String tmp = s.toString();
			System.out.println(tmp);
		}
		
		return carList;
	}
	//prints string of customers cars owned
	@Override
	public void getMyCars(String username) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT CAR_ID, MAKE, CAR_MODEL, COLOR, CAR_YEAR, CAR_COST FROM CAR WHERE CAR_OWNER ='" + username + "'");
		Car s = null;
		String tmp = "";
		while(rs.next()) {
			s = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
			tmp = s.toString2();
			System.out.println(tmp);
		}
	}
	
	

}
