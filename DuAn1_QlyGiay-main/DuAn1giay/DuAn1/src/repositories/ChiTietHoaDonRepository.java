package repositories;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import models.ChiTietHoaDon;
import utilities.DBConnect;
import viewmodels.ChiTietHoaDonView;

public class ChiTietHoaDonRepository {

//    private final String select = "SELECT SanPhamCT.SanPham_id,SanPham.Ten,HoaDonCT.Gia,HoaDonCT.SoLuong,KhuyenMai.GiamGia,HoaDonCT.ThanhTien FROM HoaDonCT JOIN SanPhamCT \n" +
//"	ON HoaDonCT.SanPhamCT_Id = SanPhamCT.id join SanPham\n" +
//"	On SanPhamCT.SanPham_id = SanPham.id join KhuyenMai\n" +
//"	On SanPham.id = KhuyenMai.SanPham_id join HoaDon\n" +
//"	On HoaDonCT.HoaDon_id = HoaDon.id\n" +
//"	WHERE HoaDon.id LIKE ?";
    
    private final String select ="SELECT SanPhamCT.SanPham_id,SanPham.Ten,HoaDonCT.Gia,HoaDonCT.SoLuong,HoaDonCT.KhuyenMai_id,HoaDonCT.ThanhTien FROM HoaDonCT JOIN SanPhamCT\n" +
"	ON HoaDonCT.SanPhamCT_Id = SanPhamCT.id join SanPham\n" +
"On SanPhamCT.SanPham_id = SanPham.id 	 join HoaDon On HoaDonCT.HoaDon_id = HoaDon.id\n" +
"	WHERE hoadon.id LIKE ?";
    private final String selectGH = "SELECT SanPhamCT.SanPham_id,SanPham.Ten,HoaDonCT.Gia,HoaDonCT.SoLuong,HoaDonCT.KhuyenMai_id,HoaDonCT.ThanhTien FROM HoaDonCT JOIN SanPhamCT\n" +
"	ON HoaDonCT.SanPhamCT_Id = SanPhamCT.id join SanPham\n" +
"On SanPhamCT.SanPham_id = SanPham.id 	 join HoaDon On HoaDonCT.HoaDon_id = HoaDon.id\n" +
"	WHERE SanPhamCT.id LIKE ?'";
    public List<ChiTietHoaDonView> getList(String idHD) {
        List<ChiTietHoaDonView> listCTHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select, idHD);
            while (rs.next()) {
                ChiTietHoaDonView cthdv = new ChiTietHoaDonView();
                cthdv.setIdSanPham(rs.getString(1));
                cthdv.setTenSanPham(rs.getString(2));
                cthdv.setSoLuong(rs.getInt(3));
                cthdv.setDonGia(rs.getDouble(4));
                cthdv.setGiamGia(rs.getInt(5));
                cthdv.setThanhTien(rs.getDouble(6));
                listCTHDV.add(cthdv);
            }
            rs.getStatement().getConnection().close();
            return listCTHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public List<ChiTietHoaDonView> getCTHoaDonByMaSP(String idSPCT) {
        List<ChiTietHoaDonView> listCTHDV = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(selectGH, idSPCT);
            while (rs.next()) {
                ChiTietHoaDonView cthdv = new ChiTietHoaDonView();
                cthdv.setIdSanPham(rs.getString(1));
                cthdv.setTenSanPham(rs.getString(2));
                cthdv.setSoLuong(rs.getInt(3));
                cthdv.setDonGia(rs.getDouble(4));
                cthdv.setGiamGia(rs.getInt(5));
                cthdv.setThanhTien(rs.getDouble(6));
                listCTHDV.add(cthdv);
            }
            rs.getStatement().getConnection().close();
            return listCTHDV;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

 
    public boolean add(ChiTietHoaDon cthd) {
        int check = 0;
        String sql = "INSERT INTO ChiTietHoaDon(MaHoaDon,MaSanPham,SoLuong,DonGia,ThanhTien) VALUES(?,?,?,?,?)";
        try {
            check = DBConnect.Update(sql,cthd.getMaHoaDon(),cthd.getMaSanPham(),cthd.getSoLuong(),cthd.getDonGia(),cthd.getThanhTien());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check > 0;
    }

}
