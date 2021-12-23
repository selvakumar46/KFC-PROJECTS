package com.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kfc.ConnectionUtil;
import com.model.Admin;
import com.model.User;

public class AdminDao {
	public Admin adminValidate(Admin adminLogin) throws SQLException {
		Admin login=null;
		String loginQuery="select * from admin_kfc where mail_id= ? and mobile_number=?";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		PreparedStatement pstmt=con.prepareStatement(loginQuery);
		pstmt.setString(1,adminLogin.getMailId());
		pstmt.setLong(2, adminLogin.getMobileNumber());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {

			login = new Admin(rs.getString(1), rs.getString(2),rs.getLong(3));
			return login;
		} else {
			return null;
		}
		
		
	}
	public Admin insertAdmin(Admin insert) throws SQLException {
		String insertAdm="insert into admin_kfc values(?,?,?)";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		PreparedStatement pstmt=con.prepareStatement(insertAdm);
		pstmt.setString(1, insert.getAdminName());
		pstmt.setString(2, insert.getMailId());
		pstmt.setLong(3, insert.getMobileNumber());
		int i=pstmt.executeUpdate();
		System.out.println(i+" new admin Inserted");
//		psttm
		return null;
	}
	public boolean updateAdmin(Admin admin) {
		Admin adminUpdate=null;
		String updateAdmin="update admin_kfc set mobile_number=? where mail_id=?";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(updateAdmin);
			pstmt.setLong(1, admin.getMobileNumber());
			pstmt.setString(2, admin.getMailId());
			int i=pstmt.executeUpdate();
			System.out.println(i+"updated successfully...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean deleteAdmin(Admin admin) {
		String delete=" delete from admin_kfc where mail_id=? and mobile_number=?";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(delete);
			pstmt.setString(1, admin.getMailId());
			pstmt.setLong(2, admin.getMobileNumber());
			int i = pstmt.executeUpdate();
			System.out.println(i+"admin deleted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return false;
	}
}
