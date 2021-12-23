package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kfc.ConnectionUtil;

public class cartItemDao {
	
	public boolean insertCart(){
		String insert="insert into cart_item (product_id,user_id,product_name,quantity,total_price)values (?,?,?,?,?)";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete() {
		String delete="delete from cart_item where user_id=?";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(delete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
