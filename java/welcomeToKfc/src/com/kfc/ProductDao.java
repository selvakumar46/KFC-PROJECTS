package com.kfc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	public List<Products> showProduct() throws SQLException {
		List<Products> listOfProducts = new ArrayList<Products>();
//		
		String query = "select * from products_kfc";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
//			product = new Products(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
//			listOfProducts.add(product);
			System.out.format("%-5s%-27s%-6s%-10s%-5s%-8s%-7s%-9s", "name=", rs.getString(2), "price=", rs.getDouble(4),
					"type-", rs.getString(5), "Status-", rs.getString(6));
			System.out.println();
		}

		return listOfProducts;

	}

	public Products validateProduct(Products product) throws SQLException {
		Products productValid = null;
		String validatePro = "select * from products_kfc where product_name=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pstmt = con.prepareStatement(validatePro);
		pstmt.setString(1, product.getProductName());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
//			System.out.println("Valid Product");

			productValid=new Products(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getString(6));
			return productValid;
		} else {
			System.out.println("invalid Products");
			return null;
		}
	}

}
