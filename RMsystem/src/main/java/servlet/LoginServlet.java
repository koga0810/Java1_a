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
	
	// データベース接続用のDaoクラスのインスタンス
	private AccountDao accountDAO; 
	
	
	 @Override
	    public void init() throws ServletException {
	        super.init();
	        accountDAO = new AccountDao(); // 初期化時にDaoクラスのインスタンスを作成
	    }

	
	//ログイン画面を表示するためのdoGetメソッド	
	 protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
	dispatcher.forward(request, response);
	
	
}
	 //ログインフォームから送信されたIDとPASSを取得するためのdoPostメソッド
	 protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
	
	
		 //リクエストからパラメーターを取得
		 String id = request.getParameter("id");
		 String pass = request.getParameter("pass");
    
		 // データベースに接続し、ログインをチェックする
		 AccountBeans account = accountDAO.findById(id, pass); 
   
		 
	// ログインに成功した場合	 
    if (account != null) {
    	
    // リクエストスコープにログイン情報をセットする
        request.setAttribute("loggedInAccount", account);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/secretariat.jsp");
        dispatcher.forward(request, response);
        
    } else {
    	 request.setAttribute("errorMessage", "ユーザーIDまたはパスワードが間違っています。");
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
    	 dispatcher.forward(request, response);
    	}
    }


@Override
	public void destroy() {
		super.destroy();
		
    // アプリケーション終了時にデータベース接続をクローズする
    if (accountDAO != null) {
        accountDAO.closeConnection();
        accountDAO = null; // accountDAO を null に設定してデータベース接続を解除
        
        System.out.println("接続終わり");
    }
}
}





 

