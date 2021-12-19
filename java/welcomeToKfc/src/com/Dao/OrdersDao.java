package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kfc.ConnectionUtil;
import com.kfc.Products;

import pojo.Orders;

public class OrdersDao {

	public void   insertOrder(Orders order) throws SQLException {
		
		Orders insert=null;
		String insertOrder="insert into order_kfc (product_id,user_id,quantity,total_price) values (?,?,?,?)";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		PreparedStatement pstmt=con.prepareStatement(insertOrder);
		pstmt.setInt(1, order.getProductId());
		pstmt.setInt(2, order.getUserId());
		pstmt.setInt(3, order.getQuantity());
		pstmt.setDouble(4, order.getTotalPrice());
		int i= pstmt.executeUpdate();
		System.out.println(i+" Product added to your cart");
		
		
		
//		return true;
	}
	public List<Orders> showOrders(Orders order) throws SQLException {
		List<Orders> listOfOrders = new ArrayList<Orders>();
//		
//		String query = "select pr.product_name,ord.quantity,ord.total_price from products_kfc pr inner join order_kfc ord on ord.product_id=pr.product_id where user_id=?";
		String query = "select * from orders_kfc where user_id=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, order.getUserId());
		
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {

			System.out.printf("%-10s%-32s%-10s%-14s%-7s%-15s","foodName=",rs.getString(1), "Quantity=",rs.getInt(2),"price=",rs.getDouble(3));
			System.out.println();
			
		}

		return null;
		}

}
