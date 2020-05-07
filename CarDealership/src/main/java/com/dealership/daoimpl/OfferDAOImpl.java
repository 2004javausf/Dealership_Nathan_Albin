package com.dealership.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import com.dealership.beans.Car;
import com.dealership.beans.Offer;
import com.dealership.dao.OfferDAO;
import com.dealership.util.ConnFactory;

public class OfferDAOImpl implements OfferDAO {

	public static ConnFactory cf = ConnFactory.getFactoryInstance();
	
	@SuppressWarnings("resource")
	@Override
	public void createOffer(String username, int carId, double downPmt, int loanLength) throws SQLException {
		NumberFormat formatter = new DecimalFormat("#0.00");  
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE USERNAME = '" + username + "'");
		int creditScore = 0;
		double annImm = 0;
		double effNomRate = 0;
		double carCost = 0;
		double nomRate = 0;
		double annEffRate = 0;
		double realAnnEff = 0;
		double amountToFinance = 0;
		double mthlyPmt = 0;
		while(rs.next()) {
			creditScore = rs.getInt(5);
		}
		rs = stmt.executeQuery("SELECT * FROM CAR WHERE CAR_ID = " + carId);
		while(rs.next()) {
			carCost = rs.getDouble(6);
		}
		if(loanLength == 0) {
			Scanner s = new Scanner(System.in);
			System.out.println("Would you like to purchase vehicle? ('yes' to make offer and 'no' to cancel)");
			String tmp = s.nextLine();
			if(tmp.equals("yes")) {
				double tmp2 = Math.random() * 99999999;
				NumberFormat formatterr = new DecimalFormat("#0");
				tmp2 = Integer.parseInt(formatterr.format(tmp2));
				int offerId = (int) tmp2;
				downPmt = carCost;
				amountToFinance = 0;
				annEffRate = 0;
				mthlyPmt = 0;
				rs = stmt.executeQuery("SELECT * FROM OFFERS WHERE USERNAME = '" + username + "' AND CAR_ID = " + carId);
				if(rs.next() == true) {
					System.out.println("Already made offer on this car!");
					return;
				}
				rs = stmt.executeQuery("INSERT INTO OFFERS VALUES(" + offerId + ",'" + username + "'," + carId + "," + carCost + "," + downPmt + "," + loanLength + "," + amountToFinance + "," + annEffRate + "," + mthlyPmt + ", 'NotAccepted')");
				System.out.println("Thank you for your offer!");
				return;
			} else if(tmp.equals("no")) {
				System.out.println("Thank you, please visit again soon!");
				return;
			}
			System.out.println("Incorrect input");
			return;
		} else if (loanLength < 0) {
			System.out.println("Incorrect input");
			return;
		}
		
		
		amountToFinance = carCost - downPmt;
		annEffRate = 12 - (((double)creditScore / 900) * 10);
		realAnnEff = 1 + (annEffRate / 100);
		nomRate = (12) * ((Math.pow(realAnnEff, (double)1 / 12)) - 1);
		effNomRate = nomRate / 12;
		annImm = (1 - Math.pow(1 + effNomRate, (double)loanLength * -1)) / effNomRate;
		mthlyPmt = (amountToFinance) / (annImm);		
		
		annEffRate = Double.parseDouble(formatter.format(annEffRate));
		amountToFinance = Double.parseDouble(formatter.format(amountToFinance));
		mthlyPmt = Double.parseDouble(formatter.format(mthlyPmt));
		System.out.println("Car cost is: " + carCost);
		System.out.println("Down Payment is: " + downPmt);
		System.out.println("Amount to finance is: " + amountToFinance);
		System.out.println("Loan term is: " + loanLength + " months");
		System.out.println("Interest rate is: " + annEffRate + "%");
		System.out.println("Mothly payment is: " + mthlyPmt);
		System.out.println();
		System.out.println("Make offer? ('yes' to make offer and 'no' to cancel offer)");
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		if(tmp.equals("yes")) {
			double tmp2 = Math.random() * 99999999;
			NumberFormat formatterr = new DecimalFormat("#0");
			tmp2 = Integer.parseInt(formatterr.format(tmp2));
			int offerId = (int) tmp2;
			rs = stmt.executeQuery("SELECT * FROM OFFERS WHERE USERNAME = '" + username + "' AND CAR_ID = " + carId);
			if(rs.next() == true) {
				System.out.println("Already made offer on this car!");
				return;
			}
			rs = stmt.executeQuery("INSERT INTO OFFERS VALUES(" + offerId + ",'" + username + "'," + carId + "," + carCost + "," + downPmt + "," + loanLength + "," + amountToFinance + "," + annEffRate + "," + mthlyPmt + "," + loanLength + ", 'NotAccepted')");
			System.out.println("Successfully made offer, thanks!");
		} else {
			System.out.println("We look forward to helping you again soon!");
		}
	}

	@SuppressWarnings("resource")
	@Override
	public void acceptDenyOffer(String username, int carId) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFERS WHERE USERNAME = '" + username + "' AND CAR_ID = " + carId + "AND OFFER_STATUS = 'NotAccepted'");
		Scanner s = new Scanner(System.in);
		String tmp = "";
		if(rs.next() == false) {
			System.out.println("Offer not found..");
			return;
		}
		ResultSet rss = stmt.executeQuery("SELECT * FROM OFFERS WHERE USERNAME = '" + username + "' AND CAR_ID = " + carId);
		while(rss.next()) {
			Offer of = new Offer(rss.getInt(1), rss.getString(2), rss.getInt(3), rss.getDouble(4), rss.getDouble(5), rss.getInt(6), rss.getDouble(7), rss.getDouble(8), rss.getDouble(9), rss.getInt(10), rss.getString(11));
			tmp = of.toString();
			System.out.println(tmp);
		}
		System.out.println("Accept or deny offer? ('a' for accept and 'd' for deny)");
		String tmp2 = s.nextLine();
		if(tmp2.equals("a")) {
			rs = stmt.executeQuery("UPDATE CAR SET CAR_OWNER = '" + username + "' WHERE CAR_ID = " + carId);
			rs = stmt.executeQuery("UPDATE CAR SET PURCHASE_STATUS = 'Unavailable' WHERE CAR_ID = " + carId);
			rs = stmt.executeQuery("UPDATE OFFERS SET OFFER_STATUS = 'Accepted' WHERE USERNAME = '" + username + "' AND CAR_ID = " + carId);
			rs = stmt.executeQuery("DELETE FROM OFFERS WHERE CAR_ID = " + carId + "AND USERNAME != '" + username + "'");
			System.out.println("Purchase confirmed");
			return;
			
		} else if(tmp2.equals("d")) {
			rs = stmt.executeQuery("DELETE FROM OFFERS WHERE USERNAME = '" + username + "' AND CAR_ID = " + carId);
			System.out.println("Offer denied and removed");
		}
		
		
		
	}

	
	
	
	
	
}
