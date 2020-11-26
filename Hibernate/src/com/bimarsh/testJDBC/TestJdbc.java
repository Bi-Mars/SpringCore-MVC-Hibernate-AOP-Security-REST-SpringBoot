package com.bimarsh.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimeZone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to Database " + jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection Established");
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
