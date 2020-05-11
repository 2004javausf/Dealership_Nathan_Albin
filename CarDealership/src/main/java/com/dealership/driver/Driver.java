package com.dealership.driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.dealership.daoimpl.CarDAOImpl;
import com.dealership.daoimpl.CustomerDAOImpl;
import com.dealership.daoimpl.OfferDAOImpl;
import com.dealership.util.LogMe;

public class Driver {
	

	public static void main(String[] args) {
		LogMe.logThis("error", "Error in code");
		String username = null;
		boolean quit = false;
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		CarDAOImpl cadi = new CarDAOImpl();
		OfferDAOImpl odi = new OfferDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("W E L C O M E");
		System.out.println("Select user type('1' for customer and '2' for employee)");
		int tmp = sc.nextInt();
		switch(tmp) {
		case 1:
			System.out.println("New customer?('1' for yes and '2' for no");
			tmp = sc.nextInt();
			switch(tmp) {
			case 1:
				try {
					cdi.newAccount();
				} catch (SQLException e) {
					System.out.println("Account already exists.");
					System.exit(0);
				}
			case 2:
				while(username == null) {
					try {
						username = cdi.customerLogin();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
				do {
					
					System.out.println("Please select an option:");
					System.out.println("1: Show my account info");
					System.out.println("2: Make offer on car");
					System.out.println("3: View cars on lot");
					System.out.println("4: View my cars");
					System.out.println("5: View my offers and car payment info");
					System.out.println("6: Make car payment");
					System.out.println("0: Exit");
					tmp = sc.nextInt();
					switch(tmp) {
					case 1:
						try {
							cdi.getAccount(username);
							break;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							System.out.println("Error entering username");
							break;
						}
					case 2:
						Scanner scc = new Scanner(System.in);
						System.out.println("Car id?");
						int carId = scc.nextInt();
						System.out.println("Down payment on car?");
						double downPmt = scc.nextDouble();
						System.out.println("Length of loan?(We currently offer 24, 60 , and 72 month loans. Enter '0' if purchasing car in full)");
						int loanLength = scc.nextInt();
						try {
							odi.createOffer(username, carId, downPmt, loanLength);
							break;
						} catch (SQLException e) {
							System.out.println("Invalid input.");
							break;
						}
					case 3:
						try {
							cadi.getCars();
							break;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							break;
						}
					case 4:
						try {
							cadi.getMyCars(username);
							break;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							break;
						}
					case 5:
						try {
							odi.viewOffers(username);
							break;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							break;
						}
					case 6:
						Scanner scann = new Scanner (System.in);
						System.out.println("Enter car id");
						carId = scann.nextInt();
						try {
							odi.makePayment(username, carId);
							break;
						} catch (SQLException e) {
							System.out.println("Invalid input");
							break;
						}
					case 0:
						quit = true;
						break;
					default:
						System.out.println("Invalid input");
						break;
					}
				} while(!quit);
				System.out.println("Thank you");
				System.exit(0);
			}
		case 2:
			try {
				cdi.employeeLogin();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			do {
				
				System.out.println("Please enter an option:");
				System.out.println("1: Show all cars");
				System.out.println("2: Add new car");
				System.out.println("3: Get all customer info");
				System.out.println("4: View all offers");
				System.out.println("5: Accept/Deny offer");
				System.out.println("0: Exit");
				tmp = sc.nextInt();
				switch(tmp) {
				
				case 1:
					try {
						cadi.getAllCars();
						break;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				case 2:
					try {
						cadi.insertCar();
						break;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				case 3:
					try {
						cdi.getCustomerList();
						break;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				case 4:
					try {
						odi.viewAllOffers();
						break;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				case 5:
					Scanner scanny = new Scanner(System.in);
					System.out.println("Enter username");
					username = scanny.nextLine();
					System.out.println("Enter car id");
					int carId = scanny.nextInt();
					
					try {
						odi.acceptDenyOffer(username, carId);
						break;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
					
				case 0:
					quit = true;
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			} while (!quit);
			System.out.println("Have a nice day");
			System.exit(0);
		}

	}

	
}