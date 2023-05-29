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
public class Layanan {
    private static final String tableName = "layanan";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS "+tableName+" (\n" +
                    "    id INT NOT NULL AUTO_INCREMENT,\n" +
                    "    nama VARCHAR(100) NOT NULL,\n" +
                    "    harga INT NOT NULL,\n" +
                    "    point INT(4),\n" +
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
            {"001", "fooFake1", "200000", "100"},
            {"002", "fooFake2", "300000", "90"},
            {"003", "fooFake3", "250000", "80"},
            {"004", "fooFake4", "150000", "100"},
        };
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+tableName+" values(?,?,?,?)");
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
        new Layanan().createTable();
        new Layanan().createFakeData();
    }
}
