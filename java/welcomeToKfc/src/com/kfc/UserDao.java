package com.kfc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public void insertUser(User user) {
		String insertQuery = "insert into user_kfc(user_name,mobile_number,mail_id)values(?,?,?)";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(insertQuery);
			System.out.println(user.getUserName());
			pst.setString(1, user.getUserName());
			pst.setLong(2, user.getMobileNumber());
			pst.setString(3, user.getMailId());
			pst.executeUpdate();
			System.out.println(" Registered successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Value not added");
			System.out.println();
		}
	}

	public User validateUser(String logMail, Long logNumber) throws SQLException {
		// TODO Auto-generated method stub
		// String validateQuery="select * from user_kfc where mail_id=
		// "+login.getMailId()+"' and mobile_number="+login.getMobileNumber();
		Connection con = null;
		User user;
		PreparedStatement pstmt = null;
		con = ConnectionUtil.getDBConnection();
		String query = "select * from user_kfc where mail_id= ? and mobile_number=?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, logMail);
		pstmt.setLong(2, logNumber);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
//			System.out.println(rs.getString(2)+","+rs.getLong(3)+","+rs.getString(4));
			user = new User(rs.getInt(1), rs.getString(2), logNumber, logMail);
			return user;
		} else {
			return null;
		}

	}

	public void updateUser(User user1) throws SQLException {
		
		String updateQuery = "update user_kfc set mail_id=? where mobile_number=?  ";
		System.out.println(user1.getMailId());
		System.out.println(user1.getMobileNumber());
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setString(1, user1.getMailId());
		pstmt.setLong(2, user1.getMobileNumber());
		int i = pstmt.executeUpdate();
		System.out.println(i + " Row updated");
		

//		return user;

	}
	public User delUser(User deleteUser) throws SQLException {
		String delQuery=" delete  from user_kfc where user_id=?";
		User user = new User();
		ConnectionUtil conect= new ConnectionUtil();
		Connection con=conect.getDBConnection();
		PreparedStatement pstmt=con.prepareStatement(delQuery);
		pstmt.setInt(1, deleteUser.getUserId());
		int i=pstmt.executeUpdate();
		System.out.println(i+"user delete Successfully");
		
		
		return user;
	}

}
