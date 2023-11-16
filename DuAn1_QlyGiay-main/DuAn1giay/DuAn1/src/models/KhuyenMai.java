package models;

import java.util.Date;

public class KhuyenMai {

    private int id;
    private String tenKhuyenMai;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int giamGia;
    private int trangThai;
    private int idSanPhamCT;

    public KhuyenMai() {
    }

    public KhuyenMai(int id, String tenKhuyenMai, Date ngayBatDau, Date ngayKetThuc, int giamGia, int trangThai, int idSanPhamCT) {
        this.id = id;
        this.tenKhuyenMai = tenKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giamGia = giamGia;
        this.trangThai = trangThai;
        this.idSanPhamCT = idSanPhamCT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getIdSanPham() {
        return idSanPhamCT;
    }

    public void setIdSanPham(int idSanPhamCT) {
        this.idSanPhamCT = idSanPhamCT;
    }

    

    
    
}
