package lab2;

import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class databaseuse {
	private static Connection con; 
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	public static ArrayList<book> showAllInfo(String authorid){
		
		ArrayList<book> bookinfo = new ArrayList<book>();
		try{
			con=databaseconnect.getConnection();
			stmt=con.prepareStatement("select * from book where authorid= '"+authorid+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				book book = new book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthorid(rs.getString("authorid"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPrice(rs.getString("price"));
				book.setPublisher(rs.getString("publisher"));
				bookinfo.add(book);
			}
		}catch(SQLException e){
			bookinfo=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}catch(SQLException e){}
		}
		databaseconnect.Close(con, stmt);
		return bookinfo;
	}
	
	public static book bookinformation(String title){
		book book = new book();
	    ResultSet rs=null;
	    try{
			con=databaseconnect.getConnection();
			stmt=con.prepareStatement("select * from book where title= '"+title+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthorid(rs.getString("authorid"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPrice(rs.getString("price"));
				book.setPublisher(rs.getString("publisher"));
			}
		}catch(SQLException e){
			book=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}catch(SQLException e){}
		}
		databaseconnect.Close(con, stmt);
		return book;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List Bookslist(String authorid){
		List list=new ArrayList();
	    ResultSet rs=null;
	    try{
			con=databaseconnect.getConnection();
			stmt=con.prepareStatement("select * from book where authorid= '"+authorid+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				book book = new book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthorid(rs.getString("authorid"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPrice(rs.getString("price"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
		}catch(SQLException e){
			list=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}catch(SQLException e){}
		}
		databaseconnect.Close(con, stmt);
		return list;
	}
		
	public static author searchauthor(String name){
		author bookname = new author();
	    ResultSet rs=null;
	    try{
			con=databaseconnect.getConnection();
			stmt=con.prepareStatement("select * from author where name= '"+name+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				bookname.setAuthorid(rs.getString("authorid"));
				bookname.setName(rs.getString("name"));
				bookname.setAge(rs.getString("age"));
				bookname.setCountry(rs.getString("country"));
			}
		}catch(SQLException e){
			bookname=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}catch(SQLException e){}
		}
		databaseconnect.Close(con, stmt);
		return bookname;
	}
	
	public static boolean deletebook(String title){
		boolean flag=false;
		try{
	    	con=databaseconnect.getConnection();
			stmt=con.prepareStatement("delete from book where title ='"+title+"'");
            if(stmt.executeUpdate()==1)flag=true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		databaseconnect.Close(con, stmt);
		return flag;
	}
}