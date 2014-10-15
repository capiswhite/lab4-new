package lab2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseconnect {
	
	private Connection con=null;
	private PreparedStatement ps = null; 
	private ResultSet rs = null;
	
	public static Connection getConnection(){
		String DBDRIVER="com.mysql.jdbc.Driver";
		String DBURL="jdbc:mysql://localhost:3306/test";
	    Connection con = null;
	    try{
	    	Class.forName(DBDRIVER);
	    	con = DriverManager.getConnection(DBURL,"root","pai314");	
	    }catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
			System.exit(1);
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return con;
	}
	
	public static void Close(Connection con,Statement stmt){
        if(stmt!=null){
        	try{
    			stmt.close();
    			}catch(SQLException e){}
    		}
    	if(con!=null){
    		try{
    			con.close();
    		    }catch(SQLException e){}
    		}
    	}  
}
