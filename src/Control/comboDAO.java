/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.util.Date;
import Model.Combo;
import Model.Food;
import java.util.List;
import View.*;

/**
 *
 * @author admin
 */
public class comboDAO {
    private static ArrayList<Food> list;
  
    public static <T> ArrayList<Food> searchFood(String t){
        list = new ArrayList<>();
        SQLServerDataSource ds = data();
        try(Connection conn =ds.getConnection()) {
            Statement stmt =conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT *FROM Food where NameFood LIKE '"+t+"%'");
            
            
            while(rs.next()){
                Food f=new Food();
                f.setIDFood(rs.getInt(1));
                f.setNameFood(rs.getString(2));
                f.setTypeFood(rs.getString(3));
                f.setPriceFood(rs.getFloat(4));
                f.setDescription(rs.getString(5));
                list.add(f);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Bi loi roi");
        }
        return list;
    }
    public static SQLServerDataSource data(){
        var server ="LAPTOP-QEDQ6B4M\\SQLEXPRESS";
        var user="sa";
        var password="Sang3627829";
        var db="Restaurant";
        var port =1433;
        SQLServerDataSource ds= new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        return ds;
    }
    
    public static boolean AddCombo(Combo c){
        SQLServerDataSource ds = data();
        String sql = "INSERT INTO Combo(Price, description, NameCombo) "
                + "VALUES(?,?,?)";
        try(Connection conn =ds.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, c.getPriceCombo());
            ps.setString(2, c.getDescription());
            ps.setString(3, c.getNameCombo());   
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return false;
    }
    public static boolean AddFoodToCombo(Food f){
        
        SQLServerDataSource ds = data();
        int id=0;  
        try(Connection conn =ds.getConnection()) {
            Statement stmt =conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT *FROM Combo");
            
            while(rs.next()){
                id = rs.getInt(1);
            }
            
            String sql = "INSERT INTO ListFoodInCombo(Food, Combo) "
                + "VALUES(?,?)";
        
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, f.getIDFood());
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            System.out.println("Bi loi roi");
        }
        return false;
    }
}
