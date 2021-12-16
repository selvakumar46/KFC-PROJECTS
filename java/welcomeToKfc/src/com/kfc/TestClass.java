package com.kfc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to KFC ");
		System.out.println("\n1.Register \n2.Login\n3.Admin Login \nEnter your choice");
		int choice = Integer.parseInt(scan.nextLine());
		UserDao userDao = null;
		switch (choice) {
		case 1:
			String name;
			long mobile;
			String mail;
			String tempNum;

			userDao = new UserDao();
			do {
				System.out.println("Enter user name:");
				name = scan.nextLine();
				if (!name.matches("[A-Za-z]{3,}")) {
					System.out.println("Name must be more than 3 characters");
				}
				if (name.isEmpty()) {
					System.out.println("Please Enter  your Name");
				}
			} while (!name.matches("[A-Za-z]{3,}"));
			do {
				System.out.println("Enter mobile number");
				tempNum = scan.nextLine();

				if (!tempNum.matches("[6-9][0-9]{9}")) {
					System.out.println("Mobile number must be 10 digits and enter correctly");
				}
				if (tempNum.isEmpty()) {
					System.out.println("please enter your mobile number");
				}

			} while (!tempNum.matches("[6-9][0-9]{9}"));
			mobile = Long.parseLong(tempNum);

			do {
				System.out.println("Enter MailId");
				mail = scan.nextLine();
				if (!mail.matches("[a-z0-9]+[@][a-z]+[.][a-z]{2,3}")) {
					System.out.println("Please enter your correct mail Id");

				}
				if (mail.isEmpty()) {
					System.out.println("Enter mailId");
				}
			} while (!mail.matches("[a-z0-9]+[@][a-z]+[.][a-z]{2,3}"));
			User user = new User(name, mobile, mail);
			userDao.insertUser(user);

		case 2:
			userDao = new UserDao();
			System.out.println("Login Page");
			System.out.println("Enter registered mailId");
			String logMail = scan.nextLine();
			System.out.println("Enter Registered mobile numer");
			Long logNumber = Long.parseLong(scan.nextLine());
			User currentUser=userDao.validateUser(logMail, logNumber);
			
//			userDao.validateUser(login);

			if(currentUser!=null) {
//				System.out.println("Login Successfully");
				System.out.println("Welcome" +currentUser.getUserName()+"!!!");
				System.out.println("Do you want:\n1.show products \n2.show orders \n3.update order \n4.Cancel order");
				int productChoice=Integer.parseInt(scan.nextLine());
				switch(productChoice) {
				case 1:
					ProductDao productDao=new ProductDao();
					List<Products> products=productDao.showProduct();
					for(int i=0;i<products.size();i++)
					{
						
						System.out.println(products.get(i));
						
					}
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				}
				
				
//				System.out.println("Welcom"+);
			}
			else {
				System.out.println("invalid mailId or mobile number");
				
			}

			break;
		case 3:
			break;
		}
	}

}
