
package database;

import java.sql.*;
import java.util.Calendar;

public class Promo {
    public static final String TABLE_NAME = "promo";
    public static final String KODE_PROMO = "kode_promo";
    public static final String NAMA = "nama";
    public static final String DISKON = "diskon";
    public static final String MAX_DISKON = "max_diskon";
    public static final String TGL_MULAI = "tgl_mulai";
    public static final String TGL_AKHIR = "tgl_akhir";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (\n" +
                    KODE_PROMO+" VARCHAR(50) NOT NULL,\n" +
                    NAMA+" VARCHAR(100) NOT NULL,\n" +
                    DISKON+" INT ,\n" +
                    MAX_DISKON+" INT ,\n" +
                    TGL_MULAI+" DATE,\n" +
                    TGL_AKHIR+" DATE,\n" +
                    "    PRIMARY KEY ("+KODE_PROMO+")\n" +
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
            {"pF001", "promoFake1", "10", "10000", "", ""},
            {"pF002", "promoFake2", "5", "20000", "", ""},
            {"pF003", "promoFake3", "15", "15000", "", ""},
            {"pF004", "promoFake4", "12", "8000", "", ""},
        };
        Calendar calendar = Calendar.getInstance();
        java.util.Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        java.util.Date futureDate = calendar.getTime();

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO "+TABLE_NAME+" values(?,?,?,?,?,?)");
            for (int i = 0; i < fakeData.length; i++) {
                Thread.sleep((i+2)*100);
                statement.setString(1, fakeData[i][0]);
                statement.setString(2, fakeData[i][1]);
                statement.setString(3, fakeData[i][2]);
                statement.setString(4, fakeData[i][3]);
                statement.setDate(5, new java.sql.Date(today.getTime()));
                statement.setDate(6, new java.sql.Date(futureDate.getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) throws InterruptedException {
        new Promo().createTable();
        new Promo().createFakeData();
    }
}
