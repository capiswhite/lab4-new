package lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class bookinformation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "queryshow.jsp";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		@SuppressWarnings("rawtypes")
		List list=new ArrayList();
		author bookname = new author();
		String name = request.getParameter("name").trim();
		bookname=databaseuse.searchauthor(name);
		String authorid = bookname.getAuthorid();
		list = databaseuse.Bookslist(authorid);
		request.setAttribute("list", list);
		
	    RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}



}

