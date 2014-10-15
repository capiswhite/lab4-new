package lab2;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bookshow extends HttpServlet {

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
		book book = new book();
		String title = request.getParameter("title");
		if(title!=null){
			book=databaseuse.bookinformation(title);
			if(book.getTitle()!=null){
				url="showbook.jsp";
				request.setAttribute("isbn", book.getIsbn());
				request.setAttribute("title", book.getTitle());
				request.setAttribute("authorid", book.getAuthorid());
				request.setAttribute("publisher", book.getPublisher());
				request.setAttribute("publishdate", book.getPublishdate());
				request.setAttribute("price", book.getPrice());
			}
			else{
			    request.setAttribute("message", "��ѯ����������ȷ����ţ�");
			}
		}
		
	    RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}


}
