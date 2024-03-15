package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,IOException{
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(
			"WEB-INF/jsp/index.jsp");

	dispatcher.forward(request, response);
}

protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,IOException{
	
	//String userId = request.getParameter("name");
    //String password = request.getParameter("pass");
	
	 //if ("admin".equals(userId) && "password".equals(password)) {
         // 認証成功時の処理
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(
			"WEB-INF/jsp/secretariat.jsp");

	dispatcher.forward(request, response);
	
} // else {
    // 認証失敗時の処理
    //response.sendRedirect("index.jsp"); // ログインページにリダイレクト
//}
}

