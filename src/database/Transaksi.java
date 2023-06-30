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
    public static final String TABLE_NAME = "transaksi";
    public static final String ID = "id";
    public static final String ID_MEMBER = "id_member";
    public static final String ID_KARYAWAN = "id_karyawan";
    public static final String TOTAL_HARGA = "total_harga";
    public static final String TANGGAL = "tanggal";
    public static final String ID_VOUCHER = "id_voucher";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (\n" +
                    ID+" INT NOT NULL AUTO_INCREMENT,\n" +
                    ID_MEMBER+" INT,\n" +
                    ID_KARYAWAN+" INT,\n" +
                    TOTAL_HARGA+" INT,\n" +
                    TANGGAL+" DATE,\n" +
                    ID_VOUCHER+" VARCHAR(20),\n" +
                    " PRIMARY KEY ("+ID+"),\n" +
                    " FOREIGN KEY ("+ID_MEMBER+") REFERENCES "+Member.TABLE_NAME+"("+Member.ID+") ON DELETE CASCADE,\n" +
                    " FOREIGN KEY ("+ID_KARYAWAN+") REFERENCES "+Karyawan.TABLE_NAME+"("+Karyawan.ID+") ON DELETE CASCADE,\n" +
                    " FOREIGN KEY ("+ID_VOUCHER+") REFERENCES "+Voucher.TABLE_NAME+"("+Voucher.KODE_VOUCHER+") ON DELETE CASCADE\n" +
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
            {"001", "1", "1", "200000", "", ""},
            {"002", "2", "2", "300000", "", ""},
            {"003", "3", "3", "250000", "", ""},
            {"004", "4", "4", "150000", "", ""},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+TABLE_NAME+" values(?,?,?,?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
<<<<<<< HEAD
                
=======
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.setString(4, fakeData[i][3]);
                statement.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
                statement.setString(6, null);


>>>>>>> b32fa774737095d902eca5c57faec5388b4365bc
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
