/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
/**
 *
 * @author Farhan
 */
public class Member {
    public static final String TABLE_NAME = "member";
    public static final String ID = "id";
    public static final String NAMA = "nama";
    public static final String ALAMAT = "alamat";
    public static final String TGL_LAHIR = "tgl_lahir";
    public static final String POINT = "point";
    public static final String NO_TELP = "notelp";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (\n" +
                    ID+" INT NOT NULL AUTO_INCREMENT,\n" +
                    NAMA+" VARCHAR(100) NOT NULL,\n" +
                    ALAMAT+" TEXT NOT NULL,\n" +
                    TGL_LAHIR+" DATE NOT NULL,\n" +
                    POINT+" INT,\n" +
                    NO_TELP+" VARCHAR(50),\n" +
                    
                    "    PRIMARY KEY ("+ID+")\n" +
                    ") ENGINE = InnoDB;";

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
            {"001", "fooFake1", "alamat1", "", "30","908"},
            {"002", "fooFake2", "alamat2", "", "50","980"},
            {"003", "fooFake3", "alamat3", "", "70","086"},
            {"004", "fooFake4", "alamat4", "", "100","089"},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+TABLE_NAME+" values(?,?,?,?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
                statement.setString(5, fakeData[i][4]);
                statement.setString(6, fakeData[i][5]);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Member().createTable();
        new Member().createFakeData();
    }
}
