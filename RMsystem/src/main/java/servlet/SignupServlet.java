package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.AccountDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccountBeans;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//protected void doGet(HttpServletRequest request,
			//HttpServletResponse response)
			//throws ServletException,IOException{
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher(
				//"WEB-INF/jsp/secretariat.jsp");
				//dispatcher.forward(request, response); 
	    //}
	
	//doPostで各種入力フォームからデータを取得
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response)
					throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
        
			
        //ageを取得
        int ageValue = 0; // デフォルト値を0に設定
        String ageStr = request.getParameter("age");
        if (ageStr != null && !ageStr.isEmpty()) {
            ageValue = Integer.parseInt(ageStr);
        }

        // absentDayを取得
        int absentDayValue = 0; // デフォルト値を0に設定
        String absentDayStr = request.getParameter("absent_day");
        if (absentDayStr != null && !absentDayStr.isEmpty()) {
            absentDayValue = Integer.parseInt(absentDayStr);
        }

        String id = request.getParameter("id");
        String pass = request.getParameter("password");
        String division = request.getParameter("division");
        String name = request.getParameter("name");
        String kana = request.getParameter("kana");
        String address = request.getParameter("address");
        int age = ageValue;
        String classId = request.getParameter("class_id");
        String admissionDateStr = request.getParameter("admission_date");
        String graduationDateStr = request.getParameter("graduation_date");
        int absentDay = absentDayValue;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date admissionDate = null;
        Date graduationDate = null;
        
        
       
        //入校日と退校日を文字列からデータ型に変更し出来ない場合は例外処理
 
        try {
            if (admissionDateStr != null && !admissionDateStr.isEmpty()) {
                long admissionDateMillis = sdf.parse(admissionDateStr).getTime();
                admissionDate = new java.sql.Date(admissionDateMillis);
            }
            if (graduationDateStr != null && !graduationDateStr.isEmpty()) {
                long graduationDateMillis = sdf.parse(graduationDateStr).getTime();
                graduationDate = new java.sql.Date(graduationDateMillis);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

       
        //取得した情報をAccountBeansに設定
        AccountBeans account = new AccountBeans();
        account.setId(id);
        account.setPass(pass);
        account.setDivision(division);
        account.setName(name);
        account.setKana(kana);
        account.setAddress(address);
        account.setAge(age);
        account.setClassId(classId);
        account.setAdmissionDate(admissionDate);
        account.setGraduationDate(graduationDate);
        account.setAbsentDay(absentDay);

        
        //新規ユーザーの情報を登録
        AccountDao dao = new AccountDao();
        dao.registerAccount(account);
        
        //boolean success = AccountDao.registerAccount(id, division, name, kana, pass, address, age, classId, admissionDate, graduationDate, absentDay);
        //System.out.println(success);
        
        //if(success) {
        	 RequestDispatcher dispatcher = request.getRequestDispatcher(
                     "userok.jsp");
             dispatcher.forward(request, response);
        	
        }
        
        
       
        
        
       
		}	
	
    

