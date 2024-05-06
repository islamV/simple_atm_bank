

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author islam
 */
public class DBConnection {

    private Connection connection;
    private Statement statement;

    // Constructor to establish the connection
    public DBConnection() throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3390/atm";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public Connection getConnection() {
        return connection;
    }
    // Getter method for the statement object
    private Statement getStatement() {
        return statement;
    }

    public ResultSet query(String statment) {
        ResultSet r = null;
        try {
            r = getStatement().executeQuery(statment);
        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }



public int insert(String table, Object[] columns, Object[] values) {
    if (columns.length != values.length) {
        System.out.println("Number of columns and values do not match");
        return 0;
    }

    StringBuilder insertQuery = new StringBuilder("INSERT INTO ");
    insertQuery.append(table).append(" (");
    for (int i = 0; i < columns.length; i++) {
        insertQuery.append(columns[i]);
        if (i < columns.length - 1) {
            insertQuery.append(", ");
        }
    }
    insertQuery.append(") VALUES (");
    for (int i = 0; i < values.length; i++) {
        if (values[i] instanceof String || values[i] instanceof Character) {
            insertQuery.append("'").append(values[i]).append("'");
        } else {
            insertQuery.append(values[i]);
        }
        if (i < values.length - 1) {
            insertQuery.append(", ");
        }
    }
    insertQuery.append(")");

    int rowsAffected = 0;
    try {
        rowsAffected = statement.executeUpdate(insertQuery.toString());
    } catch (SQLException e) {
        System.out.println("Error executing insert: " + e.getMessage());
    }
    return rowsAffected;
}


public int update(String table, Object[] columns, Object[] values, String condition) {
    if (columns.length != values.length) {
        System.out.println("Number of columns and values do not match");
        return 0;
    }

    StringBuilder updateQuery = new StringBuilder("UPDATE ");
    updateQuery.append(table).append(" SET ");
    for (int i = 0; i < columns.length; i++) {
        updateQuery.append(columns[i]).append(" = ");
        if (values[i] instanceof String || values[i] instanceof Character) {
            updateQuery.append("'").append(values[i]).append("'");
        } else {
            updateQuery.append(values[i]);
        }
        if (i < columns.length - 1) {
            updateQuery.append(", ");
        }
    }
    updateQuery.append(" WHERE ").append(condition);

    int rowsAffected = 0;
    try {
        rowsAffected = statement.executeUpdate(updateQuery.toString());
    } catch (SQLException e) {
        System.out.println("Error executing update: " + e.getMessage());
    }
    return rowsAffected;
}


    // Method to close the resources
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
