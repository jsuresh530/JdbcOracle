package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {

	 @SuppressWarnings("unused")
	public static void main(String []args) {
		 DdProperties instance = DdProperties.getInstance();
		 //<-- root root >
	        System.out.println("-------- Oracle JDBC Connection Testing ------");

	        try {

	            Class.forName(instance.getValue("driverclass"));

	        } catch (ClassNotFoundException e) {

	            System.out.println("Where is your Oracle JDBC Driver?");
	            e.printStackTrace();
	            return;

	        }

	        System.out.println("Oracle JDBC Driver Registered!");

	        Connection connection = null;

	        try {
	        	
	            connection = DriverManager.getConnection(
	                    instance.getValue("url"), instance.getValue("user"), instance.getValue("password"));
	            PreparedStatement stmt=connection.prepareStatement("select * from emp");  
	            ResultSet rs=stmt.executeQuery();  
	            while(rs.next())  
	            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  

	        } catch (SQLException e) {

	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	            return;

	        }

	        if (connection != null) {
	            System.out.println("You made it, take control your database now!");
	        } else {
	            System.out.println("Failed to make connection!");
	        }
	    }

}
