/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
/**
 *
 * @author Farha
 */
public class Karyawan {
    public static final String TABLE_NAME = "karyawan";
    public static final String ID = "id";
    public static final String NAMA = "nama";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    ID+" INT NOT NULL AUTO_INCREMENT , "+NAMA+" VARCHAR(100) NOT NULL , "
                    +USERNAME+" VARCHAR(50) NOT NULL , "+PASSWORD+" VARCHAR(50) NOT NULL , "
                    + "PRIMARY KEY ("+ID+")) ENGINE = InnoDB";

            String dropQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;

            statement.executeUpdate(dropQuery);

            statement.executeUpdate(query);

            System.out.println("Tabel berhasil dibuat!");

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat membuat tabel!");
        } finally {
            // Menutup statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

            // Menutup koneksi
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public void createFakeData() throws InterruptedException{
        Connection connection = new Koneksi().connect();
        String[][] fakeData = {
            {"001", "fooFake1", "admin1", "admin1"},
            {"002", "fooFake2", "admin2", "admin2"},
            {"003", "fooFake3", "admin3", "admin3"},
            {"004", "fooFake4", "admin4", "admin4"},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+TABLE_NAME+" values(?,?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.setString(4, fakeData[i][3]);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Karyawan().createTable();
        new Karyawan().createFakeData();
    }
}
