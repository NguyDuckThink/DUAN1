/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {

    private int Soluong;
    private Double DonGia;
    private Double DonKhiGiam;
    private HoaDon hoaDon;
    private SanPham sanPham;
    private MauSac mauSac;
    private KichCo kichCo;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int Soluong, Double DonGia, Double DonKhiGiam, HoaDon hoaDon, SanPham sanPham, MauSac mauSac, KichCo kichCo) {
        this.Soluong = Soluong;
        this.DonGia = DonGia;
        this.DonKhiGiam = DonKhiGiam;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public Double getDonGia() {
        return DonGia;
    }

    public void setDonGia(Double DonGia) {
        this.DonGia = DonGia;
    }

    public Double getDonKhiGiam() {
        return DonKhiGiam;
    }

    public void setDonKhiGiam(Double DonKhiGiam) {
        this.DonKhiGiam = DonKhiGiam;
    }

    public HoaDon getHaoDon() {
        return hoaDon;
    }

    public void setHaoDon(HoaDon haoDon) {
        this.hoaDon = haoDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public KichCo getKichCo() {
        return kichCo;
    }

    public void setKichCo(KichCo kichCo) {
        this.kichCo = kichCo;
    }

}
