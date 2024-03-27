package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;

public class UserDao {
    private static final String URL = "jdbc:mysql://localhost:3306/rmsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "adminadmin";

    public List<AccountBeans> getAllUsers() {
        List<AccountBeans> users = new ArrayList<>();
        String sql = "SELECT * FROM account";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                AccountBeans user = new AccountBeans();
                user.setId(rs.getString("id"));
                user.setDivision(rs.getString("division"));
                user.setName(rs.getString("name"));
                user.setKana(rs.getString("kana"));
                user.setPass(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setAge(rs.getInt("age"));
                user.setClassId(rs.getString("class_id"));
                user.setAdmissionDate(rs.getDate("admission_date"));
                user.setGraduationDate(rs.getDate("graduation_date"));
                user.setAbsentDay(rs.getInt("absent_days"));
                user.setLastUpdated(rs.getTimestamp("last_updated"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
}
