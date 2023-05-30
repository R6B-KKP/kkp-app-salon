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
public class TransaksiDetail {
    public static final String TABLE_NAME = "transaksi_detail";
    public static final String ID = "id";
    public static final String ID_LAYANAN = "id_layanan";
    public static final String ID_TRANSAKSI = "id_transaksi";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (\n" +
                    ID+" INT NOT NULL AUTO_INCREMENT,\n" +
                    ID_LAYANAN+" INT,\n" +
                    ID_TRANSAKSI+" INT,\n" +
                    " PRIMARY KEY ("+ID+"),\n" +
                    " FOREIGN KEY ("+ID_LAYANAN+") REFERENCES "+Layanan.TABLE_NAME+"("+Layanan.ID+") ON DELETE CASCADE,\n" +
                    " FOREIGN KEY ("+ID_TRANSAKSI+") REFERENCES "+Transaksi.TABLE_NAME+"("+Transaksi.ID+") ON DELETE CASCADE\n" +
                    ") ENGINE = InnoDB;";

            String dropQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;

            statement.executeUpdate(dropQuery);

            statement.executeUpdate(query);

            System.out.println("Tabel berhasil dibuat!");

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat membuat tabel! :"+e.getMessage());
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
            {"001", "1", "1"},
            {"002", "2", "2"},
            {"003", "3", "3"},
            {"004", "4", "4"},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+TABLE_NAME+" values(?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new TransaksiDetail().createTable();
        new TransaksiDetail().createFakeData();
    }
}
