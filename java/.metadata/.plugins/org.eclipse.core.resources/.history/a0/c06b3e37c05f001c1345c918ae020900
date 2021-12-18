package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kfc.ConnectionUtil;

import pojo.Orders;

public class OrdersDao {
	public Orders insertOrder() throws SQLException {
		String insertQuery="insert into order_kfc(qantity) values(?)";
		Orders order=null;
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		PreparedStatement pstmt=con.prepareStatement(insertQuery);
		
		
		
//		pstmt.setInt(1, OrdersDao.get);
		return order;
	}

}
