package repositories;

import java.util.ArrayList;
import java.util.List;
import repositories.HoaDonRepository;
import viewmodels.HoaDonView;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.HoaDon;

import utilities.DBConnect;

public class HoaDonRepository  {

//    private final String select = "SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,KhachHang.DiaChi,KhachHang.SDT\n" +
//"            ,NgayTao,TongTien,HoaDon.TrangThai,GhiChu\n" +
//"			FROM  HoaDon JOIN NhanVien ON HoaDon.NhanVien_Id = NhanVien.Id JOIN KhachHang\n" +
//"            ON HoaDon.KhachHang_Id = KhachHang.Id";
    private final String Select ="SELECT HoaDon.id,NhanVien.Ten,KhachHang.Ten,KhachHang.DiaChi,KhachHang.SDT,NgayTao,TongTien,HoaDon.TrangThai,GhiChu \n" +
"FROM HoaDon JOIN NhanVien ON HoaDon.NhanVien_Id = NhanVien.Id JOIN KhachHang \n" +
"ON HoaDon.KhachHang_Id = KhachHang.Id";
    
//    private final String search = "SELECT MaHoaDon,NhanVien.TenNhanVien,KhachHang.TenKhachHang,NgayTao,HoaDon.TrangThai\n" +
//"            FROM  HoaDon JOIN NhanVien ON HoaDon.NhanVien_Id = NhanVien.Id JOIN KhachHang\n" +
//"            ON HoaDon.KhachHang_Id = KhachHang.Id WHERE NgayTao LIKE ? OR MaHoaDon LIKE ?";
    private final String search ="SELECT HoaDon.Id,NhanVien.Ten,KhachHang.Ten,NgayTao,HoaDon.TrangThai\n" +
"    FROM  HoaDon JOIN NhanVien ON HoaDon.NhanVien_Id = NhanVien.Id JOIN KhachHang\n" +
"       ON HoaDon.KhachHang_Id = KhachHang.Id WHERE NgayTao LIKE ? OR HoaDon.Id LIKE ?";
//    @Override
//    public boolean add(HoaDon hd) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

        public List<HoaDonView> getList() {
        List<HoaDonView> listHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(Select);
            while (rs.next()) {
                HoaDonView hd = new HoaDonView();
                hd.setIdhoadon(rs.getString(1));
                hd.setTenNhanVien(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setDiaChi(rs.getString(4));
                hd.setSoDienThoai(rs.getString(5));
                hd.setNgayTao(rs.getDate(6));
                hd.setTongTien(rs.getDouble(7));
                hd.setTinhTrang(rs.getString(8));
                hd.setGhiChu(rs.getString(9));
                listHDV.add(hd);
            }
            rs.getStatement().getConnection().close();
            return listHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public List<HoaDonView> getSearch(String ngayTao, String id) {
        List<HoaDonView> listHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(search, "%" + ngayTao + "%", "%" + id + "%");
            while (rs.next()) {
                HoaDonView hd = new HoaDonView();
                hd.setIdhoadon(rs.getString(1));
                hd.setTenNhanVien(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setNgayTao(rs.getDate(4));
                hd.setTinhTrang(rs.getString(5));
                listHDV.add(hd);
            }
            rs.getStatement().getConnection().close();
            return listHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    
    public boolean add(HoaDon hd) {
        int check = 0;
        String sql = "INSERT INTO HoaDon(NhanVien_id,KhachHang_Id,NgayTao,TrangThai,TongTien,GhiChu) VALUES(?,?,?,?,?,?)";
        try {
            check = DBConnect.Update(sql,hd.getIdNhanVien(), hd.getIdKhachHang(), hd.getNgayTao(), hd.getTinhTrang(), hd.getTongTien(), hd.getGhiChu());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

    
    public ResultSet demidHD(String idHD) {
        String sql = "SELECT COUNT(*) FROM HoaDon WHERE Mid LIKE ?";
        try {
            return DBConnect.Query(sql, "% " + idHD + "%");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
    public ResultSet getByidHD(String idHD) {
        String sql = "SELECT id,NhanVien_id,KhachHang_id,NgayTao,TongTien,TrangThai,GhiChu FROM HoaDon WHERE id =?";
        try {
            return DBConnect.Query(sql, idHD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
