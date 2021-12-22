package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kfc.ConnectionUtil;
import com.model.Orders;
import com.model.Products;

public class OrdersDao {

	public Orders insertOrder(Orders order) {

		Orders insert = null;
		String insertOrder = "insert into order_kfc (product_id,user_id,quantity,total_price) values (?,?,?,?)";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(insertOrder);
			pstmt.setInt(1, order.getProductId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setInt(3, order.getQuantity());
			pstmt.setDouble(4, order.getTotalPrice());
			int i = pstmt.executeUpdate();
			System.out.println(i + " Product added to your cart");

			return insert;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;

	}

	public List<Orders> showOrders(Orders order) throws SQLException {
		List<Orders> listOfOrders = new ArrayList<Orders>();

//		String query = "select pr.product_name,ord.quantity,ord.total_price from products_kfc pr inner join order_kfc ord on ord.product_id=pr.product_id where user_id=?";
		String query = "select * from order_kfc where user_id=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, order.getUserId());

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {

			System.out.println(rs.getInt(1));

		}

		return null;
	}

	public Orders delOrder(Orders deleteOrders) {
		Orders orders = new Orders();
		String delQuery = "delete  from order_kfc where user_id=? ";
		ConnectionUtil conect =null;

		Connection con = conect.getDBConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(delQuery);
			pstmt.setInt(1, deleteOrders.getUserId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "delete succesfully");

			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
		
	}

	public Orders updateOrder(){
		String update = "update order_kfc set Quantity=? where user_id=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
