package servlet;

import java.io.IOException;
import java.util.List;

import dao.UserDao;
//import dao.AccountDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccountBeans;

//import model.AccountBeans;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
		 // データベースからユーザー情報を取得
        UserDao userDao = new UserDao();
        List<AccountBeans> users = userDao.getAllUsers();
        
        // 取得したユーザー情報をリクエスト属性にセット
        request.setAttribute("users", users);
        
        // account.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/account.jsp");
        dispatcher.forward(request, response);
    }
}
