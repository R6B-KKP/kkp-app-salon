package model;

public class TransaksiEntity {
    private int id;
    private String namaLayanan;
    private int price;
    private int qty;

    public TransaksiEntity(int id, String namaLayanan, int price, int qty) {
        this.id = id;
        this.namaLayanan = namaLayanan;
        this.price = price;
        this.qty = qty;
    }

    public TransaksiEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Nama Layanan : "+this.namaLayanan+"\n"
              +"Qty          : "+this.qty;
    }
    
    
}
