
package database;

import java.sql.*;
import java.util.Calendar;

public class Voucher {
    public static final String TABLE_NAME = "voucher";
    public static final String KODE_VOUCHER = "kode_voucher";
    public static final String DELETED = "deleted";
    public static final String KODE_PROMO = "kode_promo";
    
    public void createTable(){
        Connection connection = new Koneksi().connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("
                    + KODE_VOUCHER+" VARCHAR(50) NOT NULL, "
                    + DELETED+" INT NOT NULL, "
                    + KODE_PROMO+" VARCHAR(50) NOT NULL, "
                    + "PRIMARY KEY ("+KODE_VOUCHER+"), "
                    + "FOREIGN KEY ("+KODE_PROMO+") REFERENCES "+Promo.TABLE_NAME+"("+KODE_PROMO+") ON DELETE CASCADE) ENGINE = InnoDB;";

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
            {"vc001", "0", "pF001"},
            {"vc002", "0", "pF002"},
            {"vc003", "0", "pF003"},
            {"vc004", "0", "pF004"},
        };
        Calendar calendar = Calendar.getInstance();
        java.util.Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        java.util.Date futureDate = calendar.getTime();

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
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) throws InterruptedException {
        new Voucher().createTable();
        new Voucher().createFakeData();
    }
}
