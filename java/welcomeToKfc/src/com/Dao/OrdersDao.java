package com.Dao;

import java.sql.CallableStatement;
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

		String query = "select pr.product_name,ord.quantity,ord.total_price from products_kfc pr inner join order_kfc ord on ord.product_id=pr.product_id where user_id=?";
//		String query = "select * from order_kfc where user_id=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
//		PreparedStatement stmt = con.prepareStatement(query);
		CallableStatement cstmt = con.prepareCall(query);
		cstmt.setInt(1, order.getUserId());

		ResultSet rs = cstmt.executeQuery();
		while (rs.next()) {
			System.out.format("%-16s%-30s%-12s%-25s%-8s%-16s","product name=",rs.getString(1), "Quantity=", rs.getInt(2),"Price=" , rs.getDouble(3));
			System.out.println();
		}

		return null;
	}

	public Orders delOrder(Orders deleteOrders) {
		Orders orders = new Orders();
		String delQuery = "delete  from order_kfc where user_id=? ";
		ConnectionUtil conect = null;

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

	public Orders updateOrder(Orders updateOrders) {
		String update = "update order_kfc set quantity=?, total_price=?  where user_id=? and product_id=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
			pstmt.setInt(1, updateOrders.getQuantity());
			pstmt.setDouble(2, updateOrders.getTotalPrice());
			pstmt.setInt(3, updateOrders.getUserId());
			pstmt.setInt(4, updateOrders.getProductId());
			int i=pstmt.executeUpdate();
			System.out.println(i+"updated successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
