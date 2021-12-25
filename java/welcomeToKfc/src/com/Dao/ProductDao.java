package com.Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kfc.ConnectionUtil;
import com.model.Orders;
import com.model.Products;

public class ProductDao {
	public List<Products> showProduct() {
		List<Products> listOfProducts = new ArrayList<Products>();
//		
		String query = "select * from products_kfc where product_status='Available'";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
//				product = new Products(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
//				listOfProducts.add(product);
				System.out.format("%-5s%-27s%-6s%-10s%-5s%-8s%-7s%-9s", "name=", rs.getString(2), "price=",
						rs.getDouble(4), "type-", rs.getString(5), "Status-", rs.getString(6));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfProducts;

	}

	public Products validateProduct(String selectProduct) {
		Products productValid = null;
		String validatePro = "select * from products_kfc where product_name=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(validatePro);
			pstmt.setString(1, selectProduct);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
//				System.out.println("Valid Product");

				productValid = new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6));
				return productValid;
			} else {
				System.out.println("invalid Products");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productValid;

	}

	public Products deleteProduct(Products products) {

		String delProd = "delete  from products_kfc where product_name=?";
//		System.out.println(products.getProductName() );
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pstmt;
		Products productDelete = null;
		try {
			pstmt = con.prepareStatement(delProd);
			pstmt.setString(1, products.getProductName());

			int i = pstmt.executeUpdate();
			System.out.println(i + "product  deleted Succesfully");

			return productDelete;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productDelete;

	}

	public Products updateProduct(Products products) {

		String updateProduct = "update products_kfc set product_status=? where product_name=? ";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		System.out.println(products.getProductName());
		System.out.println(products.getProductStatus());
		PreparedStatement pstmt;
		Products products1 = null;
		try {
			pstmt = con.prepareStatement(updateProduct);
			pstmt.setString(1, products.getProductStatus());
			pstmt.setString(2, products.getProductName());
			int i = pstmt.executeUpdate();
			System.out.println(i + "product Status Update Successfully");

			return products1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products1;
	}

	public Products insertProducts(Products productInsert) {

		System.out.println(productInsert.getProductName());
		System.out.println(productInsert.getDescription());
		System.out.println(productInsert.getPrice());
		System.out.println(productInsert.getProductType());
		System.out.println(productInsert.getProductStatus());
		String insert = "insert into products_kfc(product_name,description,product_price,product_type,product_status) values (?,?,?,?,?)";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pstmt;
		Products product = null;
		try {
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, productInsert.getProductName());
			pstmt.setString(2, productInsert.getDescription());
			pstmt.setDouble(3, productInsert.getPrice());
			pstmt.setString(4, productInsert.getProductType());
			pstmt.setString(5, productInsert.getProductStatus());
			int i = pstmt.executeUpdate();
			System.out.println(i + "product Update Successfully");
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}
	public Products validateProduct1(Products product) {
		Products productValid = null;
		String validatePro = "select * from products_kfc where product_id=?";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(validatePro);
			pstmt.setInt(1, product.getProductId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
//				System.out.println("Valid Product");

				productValid = new Products(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6));
				return productValid;
			} else {
				System.out.println("invalid Products");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productValid;

	}
	 
}

