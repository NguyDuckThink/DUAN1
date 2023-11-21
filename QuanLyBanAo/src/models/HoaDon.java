package models;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author PC
 */
public class HoaDon {

    private User user;
    private Integer id;
    private KhachHang khachHang;
    private String Ma;
    private String Ghichu;
    private Timestamp NgayTao;
    private Date NgayThanhToan;
    private int TinhTrang;
    private Double tongTien;

    public HoaDon() {
    }

    public HoaDon(User user, Integer id, KhachHang khachHang, String Ma, String Ghichu, Timestamp NgayTao, Date NgayThanhToan, int TinhTrang, Double tongTien) {
        this.user = user;
        this.id = id;
        this.khachHang = khachHang;
        this.Ma = Ma;
        this.Ghichu = Ghichu;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.TinhTrang = TinhTrang;
        this.tongTien = tongTien;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getId() {
        return id;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String Ghichu) {
        this.Ghichu = Ghichu;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public Timestamp getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Timestamp NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

}
