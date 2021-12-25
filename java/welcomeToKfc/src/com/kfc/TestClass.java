package com.kfc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.InvoiceDao;
import com.Dao.OrdersDao;
import com.Dao.ProductDao;
import com.Dao.UserDao;
import com.Dao.cartItemDao;
import com.model.Admin;
import com.model.CartItem;
import com.model.Invoice;
import com.model.Orders;
import com.model.Products;
import com.model.User;

public class TestClass {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to KFC ");
		System.out.println(
				"\n1.Register \n2.Login \n3.Forget MailId or Phone Number \n4.Admin Login \nEnter your choice");
		int choice = Integer.parseInt(scan.nextLine());
		boolean flag = false;
		Long forgetMail = null;
		UserDao userDao = new UserDao();
		ProductDao productDao = new ProductDao();
		InvoiceDao invoicDao = new InvoiceDao();
		OrdersDao ordDao = new OrdersDao();
		cartItemDao cartDao = new cartItemDao();

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
			User user = new User(0, name, mobile, mail);
			userDao.insertUser(user);

		case 2:

			userDao = new UserDao();
			System.out.println("Login Page");
			while (flag) {
				System.out.println("Enter registered mailId");
				String logMail = scan.nextLine();
				System.out.println("Enter Registered mobile numer");
				Long logNumber = Long.parseLong(scan.nextLine());
				User currentUser = userDao.validateUser(logMail, logNumber);

//			userDao.validateUser(login);

				if (currentUser != null) {
//				System.out.println("Login Successfully");
					System.out.println("Welcome " + currentUser.getUserName() + "!!!");

					System.out.println("Do you want:\n1.show products \n2.show cart");
					int productChoice = Integer.parseInt(scan.nextLine());
					switch (productChoice) {
					case 1:

						productDao.showProduct();
//					List<Products> products= productDao.showProduct();
//					for(int i=0;i<products.size();i++)
//					{
//						
//						System.out.println(products.get(i));
////						i++;
//					}

						String selectProduct;
						String tempQuantity;
						int quantity;
						char moreChoice;
						do {
							do {
								System.out.println("Which is you want to buy");
								selectProduct = scan.nextLine();
								if (selectProduct.isEmpty()) {
									System.out.println("Please Enter meal you want to buy in Show lists");

								}
							} while (selectProduct.isEmpty());

							Products product = new Products(0, selectProduct, null, 0, null, null);
							Products crtProducts = productDao.validateProduct(selectProduct);

							if (crtProducts != null) {
								System.out.println(crtProducts + " is available");
							} else {

								System.out.println("Invalid Product");
							}
							do {
								System.out.println("How many quantity you want");
								tempQuantity = scan.nextLine();
								if (!tempQuantity.matches("[1-9]{1,}")) {
									System.out.println("Please enter Quantity in number");
								}
								if (tempQuantity.isEmpty()) {
									System.out.println("Please enter Quantity");
								}

							} while (!tempQuantity.matches("[0-9]{1,}"));
							quantity = Integer.parseInt(tempQuantity);
							int userIdNum = currentUser.getUserId();
//					System.out.println(userIdNum);

							int productId = crtProducts.getProductId();

							double totalPrice = quantity * crtProducts.getPrice();
//					System.out.println("Total Price:"+totalPrice);

//					System.out.println(productId);
							Orders order = new Orders(0, productId, userIdNum, quantity, totalPrice);
//					System.out.println(order.getTotalPrice());
							ordDao.insertOrder(order);
							System.out.println("Do you order more y/n");
							moreChoice = scan.nextLine().charAt(0);
						} while (moreChoice == 'y' || moreChoice == 'Y');
					case 2:
						OrdersDao orderDao = new OrdersDao();
						int orderChoice = 0;
						int userIdNum = currentUser.getUserId();
						Orders order = new Orders(0, 0, userIdNum, 0, null);
						System.out.println("your cart is ");
						List cart = orderDao.showOrders(order);
						System.out.println("1.Confirm order \n2.Cancel Order \n3.Update Order");
						orderChoice = Integer.parseInt(scan.nextLine());

						switch (orderChoice) {
						case 1:
							System.out.println("Enter your delivery address");
							String address = scan.nextLine();
							int userId = currentUser.getUserId();
							Orders order1 = new Orders(0, 0, userId, 0, null);
							List<Orders> allCart = ordDao.allCart(order1);

							for (int i = 0; i < allCart.size(); i++) {
								System.out.println(allCart.get(i));
								Orders gets = allCart.get(i);

								int productId = gets.getProductId();

								Products product = new Products(productId, null, null, 0, null, null);
								Products pro = productDao.validateProduct1(product);
								String productName = pro.getProductName();

								int cartQuantity = gets.getQuantity();

								double totalPrice = gets.getTotalPrice();

								int userId1 = gets.getUserId();

								CartItem carts = new CartItem(0, productId, userId1, productName, cartQuantity,
										totalPrice, null, null);
								cartDao.insertCart(carts);
								Orders deleteOrder = new Orders(0, productId, userId1, 0, null);
								ordDao.delOrderCart(deleteOrder);

							}
							System.out.println("Your Order will Placed Succesfully...");

							break;
						case 2:

							int delOrder = currentUser.getUserId();
							Orders deleteOrder = new Orders(0, 0, delOrder, 0, null);
							ordDao.delOrder(deleteOrder);

							break;
						case 3:
							System.out.println("Enter meal name you want to update");
							String update = scan.nextLine();
							Products valaidate = new Products(0, update, null, 0, null, null);
							Products updateProduct = productDao.validateProduct(update);
							int userId1 = currentUser.getUserId();
							int proId = updateProduct.getProductId();
							System.out.println("How many you want in " + updateProduct.getProductName());
							int newQuantity = Integer.parseInt(scan.nextLine());
							double newPrice = newQuantity * updateProduct.getPrice();
							Orders updateOrder = new Orders(0, proId, userId1, newQuantity, newPrice);
							orderDao.updateOrder(updateOrder);
							break;
						}

						break;

					}

				} else {
					System.out.println("invalid mailId or mobile number");
					flag = false;

				}
			}

			break;
		case 3:
			System.out.println("1.forget MailId \n2.forget Phone Number");
			int forgetChoice = Integer.parseInt(scan.nextLine());
			String forgetMail1;
			String newMail;
			switch (forgetChoice) {

			case 1:
				do {
					System.out.println("Enter your mobile number");
					forgetMail1 = scan.nextLine();
					if (!forgetMail1.matches("[6-9][0-9]{9}")) {
						System.out.println("invalid number");
					}
					if (forgetMail1.isEmpty()) {
						System.out.println("please enter your mobile number");
					}

				} while (!forgetMail1.matches("[6-9][0-9]{9}"));
				forgetMail = Long.parseLong(forgetMail1);
				do {
					System.out.println("Enter new mailID");
					newMail = scan.nextLine();
					if (!newMail.matches("[a-z0-9]+[@][a-z]+[.][a-z]{2,3}")) {
						System.out.println("please enter mail id in correct format");
					}
					if (newMail.isEmpty()) {
						System.out.println("please enter mail Id");
					}
				} while (!newMail.matches("[a-z0-9]+[@][a-z]+[.][a-z]{2,3}"));
				User user1 = new User(0, null, forgetMail, newMail);
				userDao.updateUser(user1);

				break;
			case 2:
				break;

			}
			break;
		case 4:

			AdminDao adminDao = new AdminDao();

			System.out.println("Enter your Mail Id");
			String adminMail = scan.nextLine();
			System.out.println("Enter your mobile number");
			long adminNumber = Long.parseLong(scan.nextLine());
			Admin adminLogin = new Admin(null, adminMail, adminNumber);
			Admin currentAdmin = adminDao.adminValidate(adminLogin);
			System.out.println("Welcome" + currentAdmin.getAdminName() + "!!!");
			System.out.println("1.update \n2.insert \n3.delete");
			int adminChoice = Integer.parseInt(scan.nextLine());

			switch (adminChoice) {
			case 1:
				System.out.println("you want to Update \n1.Products \n2.admin mobile number \3.order status ");
				int updateChoice = Integer.parseInt(scan.nextLine());
				switch (updateChoice) {
				case 1:
					System.out.println("Enter product Name");
					String productName = scan.nextLine();
					System.out.println("Enter Product Status");
					String productStatus = scan.nextLine();
					Products products = new Products(0, productName, null, 0, null, productStatus);
					productDao.updateProduct(products);
					break;
				case 2:
					System.out.println("Enter admin mailId");
					String adminMailId = scan.nextLine();
					System.out.println("Enter new mobile number");
					long adminNewNumber = Long.parseLong(scan.nextLine());
					Admin admin = new Admin(null, adminMailId, adminNewNumber);
					adminDao.updateAdmin(admin);
					break;
				case 3:
					List<CartItem> show = cartDao.showUsers();
					System.out.println(show);
					System.out.println();
					System.out.println(cartDao.showUsers());
					System.out.println("\n Enter user ID");
					int updateStatus = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Order status");
					String status = scan.nextLine();
					CartItem cart = new CartItem(0, 0, updateStatus, null, 0, 0, status, null);
					cartDao.updateStatus(cart);
					System.out.println("Status updated");
					break;
				}

			case 2:
				System.out.println("1.Product \n2.new admin");
				int insertChoice = Integer.parseInt(scan.nextLine());
				switch (insertChoice) {
				case 1:
					System.out.println("Enter meal Name");
					String mealName = scan.nextLine();
					System.out.println("Enter Description");
					String mealDescription = scan.nextLine();
					System.out.println("Price");
					double mealPrice = Double.parseDouble(scan.nextLine());
					System.out.println("Enter product type");
					String mealType = scan.nextLine();
					System.out.println("Enter product status");
					String mealStatus = scan.nextLine();
					Products productInsert = new Products(0, mealName, mealDescription, mealPrice, mealType,
							mealStatus);
					System.out.println(productInsert.getProductName());
					productDao.insertProducts(productInsert);
					break;
				case 2:
					System.out.println("Enter admin name");
					String newName = scan.nextLine();
					System.out.println("Enter admin mail id");
					String newMail1 = scan.nextLine();
					System.out.println("Enter admin mobile number");
					long newNumber = Long.parseLong(scan.nextLine());
					Admin insert = new Admin(newName, newMail1, newNumber);
					adminDao.insertAdmin(insert);

				}
				break;

			case 3:
				System.out.println("You want to delete \n1.delete User \2.delete Products \n3.delete admin ");
				int delChoice = Integer.parseInt(scan.nextLine());

				switch (delChoice) {
				case 1:
					System.out.println("Enter User id");
					int userId = Integer.parseInt(scan.nextLine());
					User deleteUser = new User(userId, null, 0, null);
					System.out.println(userId);
					userDao.delUser(deleteUser);
					break;
				case 2:
					System.out.println("Enter Meal Name");
					String delProduct = scan.nextLine();
					Products products = new Products(0, delProduct, null, 0, null, null);
					productDao.deleteProduct(products);
					break;
				case 3:
					System.out.println("Enter Admin mobile number");
					long delNumber = Long.parseLong(scan.nextLine());
					System.out.println("enter admin mailId");
					String delMail = scan.nextLine();
					Admin admin = new Admin(null, delMail, delNumber);
					adminDao.deleteAdmin(admin);

					break;

				}
				break;
			}

			break;
		}
	}

}
