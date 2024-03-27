package servlet;

import java.io.IOException;
import java.util.List;

import dao.EquipmentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EquipmentBeans;

@WebServlet("/EquipmentServlet")
public class EquipmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	
		 // データベースから備品情報を取得
       EquipmentDao equipmentDao = new EquipmentDao();
       List<EquipmentBeans> equipments = equipmentDao.getAllEquipment();
       
       // 取得した備品情報をリクエスト属性にセット
       request.setAttribute("equipments", equipments);
       
        
        // equipment.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/equipment.jsp");
        dispatcher.forward(request, response);
    }
}
