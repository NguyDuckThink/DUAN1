
package models;

public class MauSac {
    private int Id;
    private String ten;

    public MauSac() {
    }

    public MauSac(int Id, String ten) {
        this.Id = Id;
        this.ten = ten;
    }
   
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    
}
