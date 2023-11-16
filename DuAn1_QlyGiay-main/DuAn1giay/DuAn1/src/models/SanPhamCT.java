
package models;


public class SanPhamCT {
    private int id;
    private int idSanPham;
    private int idMauSac;
    private int idThuongHieu;
    private int idSize;
    private int idLoaiSP;
    private int idChatLieu;
    private int soLuong;
    private double giaBan;
    private double giaNhap;
    private String moTa;

    public SanPhamCT() {
    }

    public SanPhamCT(int id, int idSanPham, int idMauSac, int idThuongHieu, int idSize, int idLoaiSP, int idChatLieu, int soLuong, double giaBan, double giaNhap, String moTa) {
        this.id = id;
        this.idSanPham = idSanPham;
        this.idMauSac = idMauSac;
        this.idThuongHieu = idThuongHieu;
        this.idSize = idSize;
        this.idLoaiSP = idLoaiSP;
        this.idChatLieu = idChatLieu;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.moTa = moTa;
    }

    public SanPhamCT(int idSanPham, int idMauSac, int idThuongHieu, int idSize, int idLoaiSP, int idChatLieu, int soLuong, double giaBan) {
        this.idSanPham = idSanPham;
        this.idMauSac = idMauSac;
        this.idThuongHieu = idThuongHieu;
        this.idSize = idSize;
        this.idLoaiSP = idLoaiSP;
        this.idChatLieu = idChatLieu;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(int idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
    

    
    
    
    
   
}
