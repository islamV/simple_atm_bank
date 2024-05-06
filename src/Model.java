/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author islam
 */
import java.sql.*;


public class Model {

    protected static String table = null;
    protected static String[] columns = {};    
    protected  Object[] values;

    public final void create() {
        try {
            DBConnection conn = new DBConnection();
            int row = conn.insert(table, columns, values);
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

  
    public  void update(int id) {
        try {
            DBConnection conn = new DBConnection();
            int row = conn.update(table, columns, values , "id=" + id);
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
 

//    public final void getAll(String table) {
//        try {
//            DBConnection conn = new DBConnection();
//            ResultSet r = conn.query("select * from " + table);
//            while (r.next()) {
//                System.out.println(r.getInt(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getString(4));
//            }
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("SQL Exception: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//        }
//    }

public final User findUserData(String card_number) {
    String selectQuery = "SELECT * FROM " + table + " WHERE `card_number` = ?";
    ResultSet r = null; 
    DBConnection conn = null;
    User user = null;

    try {
        conn = new DBConnection();
        Connection connection = conn.getConnection();
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setString(1, card_number); // Set the card_number parameter
        r = statement.executeQuery();
        if (r.next()) {
            int id = r.getInt("id");
            String name = r.getString("name");                    
            String card = r.getString("card_number");
            String password = r.getString("password");
            user = new User(name, card, password);
            user.setId(id);
        }
    } catch (SQLException e) {
    System.out.println("SQL Query: " + selectQuery);
    } catch (ClassNotFoundException e) {
        System.out.println("Exception: " + e.getMessage());
        // Log or handle the exception appropriately
    } finally {
        try {
            if (r != null) {
                r.close();
            }
            // Closing the connection
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
            // Log or handle the exception appropriately
        }
    }
    return user;
}



}
