package com.dealership.dao;

import java.sql.SQLException;
import java.util.List;

import com.dealership.beans.Car;

public interface CarDAO {
	
	public void insertCar() throws SQLException;
	
	public String getCars() throws SQLException;
	
	public List<Car> getAllCars() throws SQLException;
	
	public void getMyCars(String username) throws SQLException;

	
	
}
