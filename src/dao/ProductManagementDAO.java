package dao;

import java.sql.*;
import java.util.*;
import dbutil.DBUtil;
import pojo.Product;

public class ProductManagementDAO {

	// This method returns us a list of all the products from the database
	public static List<Product> getAllProducts()
	{
		// First we created an array of product
		List<Product> productList = new ArrayList<Product>();
		try
		{
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM product");
			while(rs.next())
			{
				// We construct the Product object and populating it over the values from the DB
				Product product = new Product(rs.getString("prod_id"),rs.getString("prod_name"),rs.getString("prod_category"),rs.getInt("prod_price"));
				// We add that object to the product list
				productList.add(product);
			}
			// Then close the connection
			DBUtil.closeConnection(conn);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// Return the list
		return productList;
	}

	// Method to get the product
	public static Product getProductById(String productId)
	{
		Product product = null;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM product WHERE prod_id = ?");
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				product = new Product(rs.getString("prod_id"),rs.getString("prod_name"),rs.getString("prod_category"),rs.getInt("prod_price"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return product;
	}

	// This the method we are using to add a product
	public static int addProduct(Product product)
	{
		// We define a status variable and set the initial value to 0
		int status = 0;
		try
		{
			// We create a connection object
			Connection conn = DBUtil.getConnection();
			// Then we created a PreparedStatement object
			PreparedStatement ps= conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");

			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	// Method to update the product
	public static int updateProduct(Product product)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("UPDATE product SET prod_name=?, prod_category=?, prod_price=? WHERE prod_id=?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductId());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteProduct(String productId)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("DELETE FROM product where prod_id = ?");
			ps.setString(1, productId);
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}

