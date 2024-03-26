
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountDao {
    private static final String URL = "jdbc:mysql://localhost:3306/rmsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "adminadmin";

   //データベースから検索するfindByIdメソッド
    public AccountBeans findById(String id, String password) {
        AccountBeans account = null;
        String sql = "SELECT * FROM account WHERE id = ? AND password = ?";
        
        //MySQLに接続するDriverManager.getConnectionメソッド
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            
            //データベースから取得した結果をAccountBeans()にマッピング
            try (ResultSet rs = pstmt.executeQuery()) {
            	
                if (rs.next()) {
                    account = new AccountBeans();
                    account.setId(rs.getString("id"));
                    account.setDivision(rs.getString("division"));
                    account.setName(rs.getString("name"));
                    account.setKana(rs.getString("kana"));
                    account.setPass(rs.getString("password"));
                    account.setAddress(rs.getString("address"));
                    account.setAge(rs.getInt("age"));
                    account.setClassId(rs.getString("class_id"));
                    account.setAdmissionDate(rs.getDate("admission_date"));
                    account.setGraduationDate(rs.getDate("graduation_date"));
                    account.setAbsentDay(rs.getInt("absent_day"));
                    account.setLastUpdated(rs.getTimestamp("last_updated"));
                }
            }
        } catch (SQLException e) {//例外処理
            e.printStackTrace();
        }
        return account;
    }
    
    
    //新規登録SQＬ文（ＩＮＳＥＲＴ）
    public void registerAccount(AccountBeans account) {
        String sql = "INSERT INTO account (id, division, name, kana, password, address, age, class_id, admission_date, graduation_date, absent_day) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, account.getId());
            pstmt.setString(2, account.getDivision());
            pstmt.setString(3, account.getName());
            pstmt.setString(4, account.getKana());
            pstmt.setString(5, account.getPass());
            pstmt.setString(6, account.getAddress());
            pstmt.setInt(7, account.getAge());
            pstmt.setString(8, account.getClassId());
            pstmt.setDate(9, new java.sql.Date(account.getAdmissionDate().getTime()));
            pstmt.setDate(10, new java.sql.Date(account.getGraduationDate().getTime()));
            pstmt.setInt(11, account.getAbsentDay());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
