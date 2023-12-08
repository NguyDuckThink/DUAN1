/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import models.HoaDon;
import models.KichCo;
import models.MauSac;
import models.SanPham;

/**
 *
 * @author Admin
 */
public class HoaDonCHiTietViewModel {

     private int Soluong;
    private Double DonGia;
    private HoaDon haDon;
    private SanPham sanPham;
    private MauSac mauSac;
    private KichCo kichCo;

    public HoaDonCHiTietViewModel() {
    }

    public HoaDonCHiTietViewModel(int Soluong, Double DonGia, HoaDon haDon, SanPham sanPham, MauSac mauSac, KichCo kichCo) {
        this.Soluong = Soluong;
        this.DonGia = DonGia;
        this.haDon = haDon;
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

    public HoaDon getHaDon() {
        return haDon;
    }

    public void setHaDon(HoaDon haDon) {
        this.haDon = haDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double getThanhTien() {
        return DonGia * Soluong;
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
