package servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import dao.AccountDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccountBeans;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//ログイン画面を表示するためのdoGetメソッド	
protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,IOException{
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(
			"WEB-INF/jsp/index.jsp");

	dispatcher.forward(request, response);
}
//ログインフォームから送信されたIDとPASSを取得するためのdoPostメソッド
protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException,IOException{
	
	String id = request.getParameter("id");//リクエストからパラメーターを取得
    String pass = request.getParameter("pass");
    
    
    
    
    // AccountDAOを使用してデータベースに接続し、ログインをチェックする
    AccountDao accountDAO = new AccountDao();
    AccountBeans account = accountDAO.findById(id,pass);

    if (account != null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "WEB-INF/jsp/secretariat.jsp");
        dispatcher.forward(request, response);
    } else {
    	 request.setAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
    	 dispatcher.forward(request, response);
    	}
    }
}

 

