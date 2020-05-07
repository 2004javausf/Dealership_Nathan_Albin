package com.dealership.beans;

public class Car {
	
	private int carId;
	private String make;
	private String model;
	private String color;
	private int year;
	private double cost;
	private String purchaseStatus;
	private String owner;
	
	public Car(int carId, String make, String model, String color, int year, double cost, String purchaseStatus,
			String owner) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.cost = cost;
		this.purchaseStatus = purchaseStatus;
		this.owner = owner;
	}

	public Car(int carId, String make, String model, String color, int year, double cost, String purchaseStatus) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.cost = cost;
		this.purchaseStatus = purchaseStatus;
	}
	
	public Car(int carId, String make, String model, String color, int year, double cost) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.cost = cost;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", make=" + make + ", model=" + model + ", color=" + color + ", year=" + year
				+ ", cost=" + cost + ", purchaseStatus=" + purchaseStatus + ", owner=" + owner + "]";
	}

	public String toString2() {
		return "Car [carId=" + carId + ", make=" + make + ", model=" + model + ", color=" + color + ", year=" + year
				+ ", cost=" + cost + "]    ";
	}
	
	
	

}