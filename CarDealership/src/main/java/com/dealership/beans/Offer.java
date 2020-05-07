package com.dealership.beans;

public class Offer {
	
	private int offerId;
	private String username;
	private int carId;
	private double carCost;
	private double downPmt;
	private int loanLength;
	private double loanBal;
	private double annEffRate;
	private double mthlyPmt;
	private int pmtLeft;
	private String offerStatus;
	
	
	
	public Offer(int offerId, String username, int carId, double carCost, double downPmt, int loanLength,
			double loanBal, double annEffRate, double mthlyPmt, int pmtLeft, String offerStatus) {
		super();
		this.offerId = offerId;
		this.username = username;
		this.carId = carId;
		this.carCost = carCost;
		this.downPmt = downPmt;
		this.loanLength = loanLength;
		this.loanBal = loanBal;
		this.annEffRate = annEffRate;
		this.mthlyPmt = mthlyPmt;
		this.pmtLeft = pmtLeft;
		this.offerStatus = offerStatus;
	}

	public Offer(int offerId, String username, int carId, double carCost, double downPmt, int loanLength,
			double loanBal, double annEffRate, double mthlyPmt) {
		super();
		this.offerId = offerId;
		this.username = username;
		this.carId = carId;
		this.carCost = carCost;
		this.downPmt = downPmt;
		this.loanLength = loanLength;
		this.loanBal = loanBal;
		this.annEffRate = annEffRate;
		this.mthlyPmt = mthlyPmt;
	}

	public Offer(int offerId, int carId, double carCost, double downPmt, int loanLength, double loanBal,
			double annEffRate, double mthlyPmt) {
		super();
		this.offerId = offerId;
		this.carId = carId;
		this.carCost = carCost;
		this.downPmt = downPmt;
		this.loanLength = loanLength;
		this.loanBal = loanBal;
		this.annEffRate = annEffRate;
		this.mthlyPmt = mthlyPmt;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public double getCarCost() {
		return carCost;
	}

	public void setCarCost(double carCost) {
		this.carCost = carCost;
	}

	public double getDownPmt() {
		return downPmt;
	}

	public void setDownPmt(double downPmt) {
		this.downPmt = downPmt;
	}

	public int getLoanLength() {
		return loanLength;
	}

	public void setLoanLength(int loanLength) {
		this.loanLength = loanLength;
	}

	public double getLoanBal() {
		return loanBal;
	}

	public void setLoanBal(double loanBal) {
		this.loanBal = loanBal;
	}

	public double getAnnEffRate() {
		return annEffRate;
	}

	public void setAnnEffRate(double annEffRate) {
		this.annEffRate = annEffRate;
	}

	public double getMthlyPmt() {
		return mthlyPmt;
	}

	public void setMthlyPmt(double mthlyPmt) {
		this.mthlyPmt = mthlyPmt;
	}

	public int getPmtLeft() {
		return pmtLeft;
	}

	public void setPmtLeft(int pmtLeft) {
		this.pmtLeft = pmtLeft;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", username=" + username + ", carId=" + carId + ", carCost=" + carCost
				+ ", downPmt=" + downPmt + ", loanLength=" + loanLength + ", loanBal=" + loanBal + ", annEffRate="
				+ annEffRate + ", mthlyPmt=" + mthlyPmt + ", pmtLeft=" + pmtLeft + ", offerStatus=" + offerStatus + "]";
	}

	
	
	

}
