package viewmodels;

import java.util.Date;

public class HoaDonView {

    private String idhoadon;
    private String tenNhanVien;
    private String tenKhachHang;
    private Date ngayTao;
    private String tinhTrang;
    private String soDienThoai;
    private String diaChi;
    private double tongTien;
    private String ghiChu;

    public HoaDonView() {
    }

    public HoaDonView(String idhoadon, String tenNhanVien, String tenKhachHang, Date ngayTao, String tinhTrang, String soDienThoai, String diaChi, double tongTien, String ghiChu) {
        this.idhoadon = idhoadon;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
    }

    public String getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(String idhoadon) {
        this.idhoadon = idhoadon;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    

}
