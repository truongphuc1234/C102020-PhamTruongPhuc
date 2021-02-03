package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Repository {
    String jdbcURL = "jdbc:mysql://localhost:3306/furama?useSSL=false";
    String jdbcUsername = "root";
    String jdbcPassword = "codegym";


    static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
    }
}
