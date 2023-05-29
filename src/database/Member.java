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
    private static final String tableName = "member";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS "+tableName+" (\n" +
                    "    id INT NOT NULL AUTO_INCREMENT,\n" +
                    "    nama VARCHAR(100) NOT NULL,\n" +
                    "    alamat TEXT NOT NULL,\n" +
                    "    tgl_lahir DATE NOT NULL,\n" +
                    "    point INT,\n" +
                    "    PRIMARY KEY (id)\n" +
                    ") ENGINE = InnoDB;";

            String dropQuery = "DROP TABLE IF EXISTS " + tableName;

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
            {"001", "fooFake1", "alamat1", "", "30"},
            {"002", "fooFake2", "alamat2", "", "50"},
            {"003", "fooFake3", "alamat3", "", "70"},
            {"004", "fooFake4", "alamat4", "", "100"},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+tableName+" values(?,?,?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
                statement.setString(5, fakeData[i][4]);
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
