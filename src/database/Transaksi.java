/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Farhan
 */
public class Transaksi {
    private static final String tableName = "transaksi";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (\n" +
                    " id INT NOT NULL AUTO_INCREMENT,\n" +
                    " id_member INT,\n" +
                    " id_karyawan INT,\n" +
                    " total_harga INT,\n" +
                    " tanggal DATE,\n" +
                    " PRIMARY KEY (id),\n" +
                    " FOREIGN KEY (id_member) REFERENCES member(id),\n" +
                    " FOREIGN KEY (id_karyawan) REFERENCES karyawan(id)\n" +
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
            {"001", "1", "1", "200000", ""},
            {"002", "2", "2", "300000", ""},
            {"003", "3", "3", "250000", ""},
            {"004", "4", "4", "150000", ""},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+tableName+" values(?,?,?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.setString(4, fakeData[i][3]);
                statement.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Transaksi().createTable();
        new Transaksi().createFakeData();
    }
}
