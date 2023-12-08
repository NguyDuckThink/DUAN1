/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

import viewmodels.KhachHangViewMD;

import viewmodels.KhachHang02ViewMD;

import java.util.List;
import models.KhachHang;

/**
 *
 * @author Admin
 */
public interface IKhachHangService {

    List<KhachHangViewMD> getall();

    List<KhachHang02ViewMD> getall01();

    String add(KhachHang khachHang);

    String update(int id, KhachHang khachHang);

    String delete(int id);

    public List<KhachHangViewMD> GetTK(String SDT);

    public List<KhachHang02ViewMD> GetTKTheoIDKH(int ID);

    List<KhachHang> TenDiemKhachHang(String SDT);

    Integer updateDiemKhachHang(String SDT, int diem);

    String kiemtra(String mail);

    String kiemtrasdt(String sdt);
}
