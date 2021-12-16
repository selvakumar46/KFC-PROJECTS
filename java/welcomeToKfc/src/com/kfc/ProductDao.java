package com.kfc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	public List<Products> showProduct() throws SQLException {
		List<Products> productList = new ArrayList<Products>();
		Products product;
		String query = "select * from products_kfc";
		ConnectionUtil conect = new ConnectionUtil();
		Connection con = conect.getDBConnection();
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			product = new Products(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
			productList.add(product);
		}

		return productList;

	}

}
