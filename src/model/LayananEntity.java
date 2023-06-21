
package model;

public class LayananEntity {
    private int id;
    private String nama;
    private int price;

    public LayananEntity(int id, String nama, int price) {
        this.id = id;
        this.nama = nama;
        this.price = price;
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
    
    
}
