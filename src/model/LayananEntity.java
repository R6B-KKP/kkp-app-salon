
package model;

import java.sql.*;


public class LayananEntity {
    private int id;
    private String nama;
    private int price;
    private Blob gambar;


    public LayananEntity(int id, String nama, int price, Blob gambar) {
        this.id = id;
        this.nama = nama;
        this.price = price;
        this.gambar = gambar;
    }

    public LayananEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public Blob getGambar() {
        return gambar;
    }

    public void setGambar(Blob gambar) {
        this.gambar = gambar;
    } 
}
