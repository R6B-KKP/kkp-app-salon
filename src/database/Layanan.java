/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farhan
 */
public class Layanan {
    public static final String TABLE_NAME = "layanan";
    public static final String ID = "id";
    public static final String NAMA = "nama";
    public static final String HARGA = "harga";
    public static final String POINT_PRICE = "point_price";
    public static final String ID_KATEGORI = "id_kategori";   
    public static final String GAMBAR = "gambar";
    public static final String DELETED = "deleted";


    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (\n " +
                    ID+" INT NOT NULL AUTO_INCREMENT,\n" +
                    NAMA+" VARCHAR(100) NOT NULL,\n" +
                    HARGA+" INT NOT NULL,\n" +
                    POINT_PRICE+" INT(4),\n" +
                    ID_KATEGORI+" INT,\n" +
                    GAMBAR+" BLOB,\n"+
                    DELETED+" INT DEFAULT 0 NOT NULL,\n"+
                    " FOREIGN KEY ("+ID_KATEGORI+") REFERENCES "+Kategori.TABLE_NAME+"("+Kategori.ID+") ON DELETE CASCADE,\n" +
                    "PRIMARY KEY ("+ID+")\n" +
                    ") ENGINE = InnoDB;";

            String dropQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;

            statement.executeUpdate(dropQuery);

            statement.executeUpdate(query);

            System.out.println("Tabel berhasil dibuat!");

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat membuat tabel! "+e.getMessage());
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
            {"001", "fooFake1", "200000", "100", null, null},
            {"002", "fooFake2", "300000", "90", null, null},
            {"003", "fooFake3", "250000", "80", null, null},
            {"004", "fooFake4", "150000", "100", null, null},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+TABLE_NAME+" values(?,?,?,?,?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
                InputStream file = new FileInputStream(new File("src/asset/produk.png"));
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.setString(4, fakeData[i][3]);
                statement.setInt(5, 1);
                statement.setBlob(6,file);
                statement.setInt(7, 0);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Layanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Layanan().createTable();
        new Layanan().createFakeData();
        System.out.println(Layanan.TABLE_NAME);
    }
}
