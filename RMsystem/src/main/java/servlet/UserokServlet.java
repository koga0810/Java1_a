package servlet;

import java.io.IOException;

import dao.AccountDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccountBeans;

@WebServlet("/UserokServlet")
public class UserokServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String id = request.getParameter("username");
        String password = request.getParameter("password");
         
         // ユーザー情報をAccountBeansオブジェクトにセット
         AccountBeans account = new AccountBeans();
         account.setId(id);
         account.setPass(password);
         
         // AccountDaoクラスのregisterAccountメソッドを呼び出してユーザー情報を登録
         AccountDao dao = new AccountDao();
         dao.registerAccount(account);
         
       
        
        // userok.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userok.jsp");
        dispatcher.forward(request, response);
    }
}
