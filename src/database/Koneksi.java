/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Farha
 */
public class Koneksi {
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal Koneksi"+ ex);
        }
        try {
            String url = "jdbc:mysql://localhost:3306/salon";
            String user = "root";
            String password = "123";

            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Database connected!");
            return conn;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
