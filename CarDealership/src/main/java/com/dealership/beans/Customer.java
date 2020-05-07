package com.dealership.beans;

public class Customer {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int creditScore;
	
	

	public Customer(String username, String password, String firstName, String lastName, int creditScore) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creditScore = creditScore;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", creditScore=" + creditScore + "]";
	}

	

}
