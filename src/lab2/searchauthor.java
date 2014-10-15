package lab2;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class searchauthor extends HttpServlet {


	private static final long serialVersionUID = 1L;
	public void destroy() {
		super.destroy();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "error.jsp";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		author bookname = new author();
		String name = request.getParameter("name").trim();
		if(name!=null){
			bookname=databaseuse.searchauthor(name);
			
			if(bookname.getAuthorid()!=null){
				url="author.jsp";
				request.setAttribute("authorid", bookname.getAuthorid());
			}
			else{
			    request.setAttribute("message", "查无此人");
			}
		}
		
	    RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}
}
