package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kfc.ConnectionUtil;
import com.model.CartItem;

public class cartItemDao {

	public CartItem insertCart(CartItem carts) {
		String insert = "insert into cart_items (product_id,user_id,product_name,quantity,total_price)values (?,?,?,?,?)";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, carts.getProductId());
			pstmt.setInt(2, carts.getUserId());
			pstmt.setString(3, carts.getProductName());
			pstmt.setInt(4, carts.getQuantity());
			pstmt.setDouble(5, carts.getTotalPrice());
			int i = pstmt.executeUpdate();
			System.out.println(i + "inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<CartItem> showUsers() {
		List<CartItem> cartItem = new ArrayList<CartItem>();
		String show = "select * from cart_items where status='Ordered'";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(show);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CartItem cartItems = new CartItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getDate(8));
				cartItem.add(cartItems);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartItem;

	}

	public boolean delete() {
		String delete = "delete from cart_items where user_id=?";
		
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(delete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public CartItem updateStatus(CartItem cart) {
		CartItem carts = null;
		String update = "update  cart_items  set status=? where user_id=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
			pstmt.setString(1, cart.getStatus());
			pstmt.setInt(2, cart.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carts;
	}
}
