package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kfc.ConnectionUtil;
import com.model.Invoice;

public class InvoiceDao {
	
	public Invoice insert(Invoice insert) {
		Invoice invoice=new Invoice();
		String insertQuery="insert into invoice_kfc(product_id,user_id,quantity,total_price,delivery_adress) values(?,?,?,?,?)";
		ConnectionUtil conect=new ConnectionUtil();
		Connection con=conect.getDBConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(insertQuery);
			pstmt.setInt(2, insert.getUserId());
			pstmt.setString(5, insert.getDeliveryAdress());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return invoice;
	}
}
