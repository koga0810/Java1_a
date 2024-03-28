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

@WebServlet("/AddEquipmentServlet")
public class AddEquipmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private Object quantityParam;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 新しい備品情報を取得
        String itemName = request.getParameter("itemName");
        //int quantity = Integer.parseInt(request.getParameter("quantity"));
        int quantity = 0; // デフォルト値を設定
		if (quantityParam != null && !((String) quantityParam).isEmpty()) {
            quantity = Integer.parseInt((String) quantityParam);
        }
        String location = request.getParameter("location");
        String updaterId = request.getParameter("updaterId");

        // 新規登録する備品情報を設定
        EquipmentBeans newEquipment = new EquipmentBeans();
        newEquipment.setItemName(itemName);
        newEquipment.setQuantity(quantity);
        newEquipment.setLocation(location);
        newEquipment.setUpdaterId(updaterId);

        // 備品情報を新規登録
        EquipmentDao equipmentDao = new EquipmentDao();
        equipmentDao.addEquipment(newEquipment);

        // 新規登録後の備品情報を取得
        List<EquipmentBeans> updatedEquipments = equipmentDao.getAllEquipment();

        // 取得した備品情報をリクエスト属性にセット
        request.setAttribute("equipments", updatedEquipments);

        // equipment.jspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/equipment.jsp");
        dispatcher.forward(request, response);
    }
}
