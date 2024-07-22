package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "example";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Tabloyu oluştur
            PreparedStatement createTable = con.prepareStatement("CREATE TABLE IF NOT EXISTS personel (ad VARCHAR(50), soyad (String(50))");
            createTable.executeUpdate();

            // Verileri ekle
            PreparedStatement insertData = con.prepareStatement("INSERT INTO personel (ad, soyad) VALUES (?, ?)");
            insertData.setString(1, "Ahmet");
            insertData.setString(2, "Yılmaz");
            insertData.executeUpdate();

            insertData.setString(1, "Ayşe");
            insertData.setString(2, "Can");
            insertData.executeUpdate();

            insertData.setString(1, "Mehmet");
            insertData.setString(2, "Aksoy");
            insertData.executeUpdate();

            // Veri sil
            PreparedStatement deleteData = con.prepareStatement("DELETE FROM personel WHERE ad = ?");
            deleteData.setString(1, "Ahmet");
            deleteData.executeUpdate();

            // Tüm verileri listele
            PreparedStatement selectData = con.prepareStatement("SELECT * FROM personel");
            ResultSet rs = selectData.executeQuery();
            while (rs.next()) {
                System.out.println("Ad: " + rs.getString("ad") + ", Soyad: " + rs.getString("soyad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}