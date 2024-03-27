package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EquipmentBeans;

public class EquipmentDao {
    private static final String URL = "jdbc:mysql://localhost:3306/rmsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "adminadmin";
    
    
    
    public List<EquipmentBeans> getAllEquipment() {
        List<EquipmentBeans> equipmentList = new ArrayList<>();
        String sql = "SELECT * FROM equipment";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EquipmentBeans equipment = new EquipmentBeans();
                
                equipment.setId(rs.getLong("id"));
                equipment.setItemName(rs.getString("item_name"));
                equipment.setQuantity(rs.getInt("quantity"));
                equipment.setLocation(rs.getString("location"));
                equipment.setUpdaterId(rs.getString("updater_id"));
                equipment.setLastUpdated(rs.getTimestamp("last_updated"));
                equipmentList.add(equipment);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipmentList;
    }
}