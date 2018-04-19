package dao;

import java.sql.* ;
import java.util.ArrayList;
import java.util.List;

import model.Frame;

import java.math.* ; 

public class CommonDAO {
	static String strConnection ="jdbc:sqlserver://localhost;databaseName=quan_ly_in_an;user=sa;password=wangzhan123";
	public static Connection getSQLConnection(){
		Connection conn =null;
	     try {
	    	    conn = DriverManager.getConnection(strConnection);
	    	    if (conn != null) {
	    	    	System.out.println("Connect database");
	    	    	return conn;
	    	    }
	    	    return conn;
	    	   }
	     catch (SQLException ex) {
	    	     System.err.println("Cannot connect database, " + ex);
	    	     return null;
	    	   }	
	    	  
	}
	
	public static ResultSet getData(String sql) {
		Connection con= null;
		Statement stm= null;
		ResultSet rs=null;
		try {			
			con= CommonDAO.getSQLConnection();
		    stm= con.createStatement();
		    rs=stm.executeQuery(sql);
		    return rs;		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
}
