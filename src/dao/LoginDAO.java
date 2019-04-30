package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbutil.DBUtil;
import pojo.LoginInfo;

public class LoginDAO {

	// Method to check if the user is valid
	public static boolean isUserValid(LoginInfo userDetails)
	{
		// We create a variable validStatus with The initial value set to false
		boolean validStatus = false;
		try
		{
			Connection conn = DBUtil.getConnection();
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM login_info WHERE user_name = '"+userDetails.getUserName()+"' AND password = '"+userDetails.getPassword()+"'");

			while(rs.next())
			{
				// In case the and password is valid the variable will be turned into true
				validStatus = true;
			}

			// Close the connection afterwards
			DBUtil.closeConnection(conn);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return validStatus;
	}
}
