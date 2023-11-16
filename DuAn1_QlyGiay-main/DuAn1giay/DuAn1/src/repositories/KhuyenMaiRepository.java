package repositories;

import java.util.ArrayList;
import java.util.List;
import models.KhuyenMai;
import repositories.KhuyenMaiRepository;
import viewmodels.KhuyenMaiView;
import java.sql.*;
import utilities.DBConnect;

public class KhuyenMaiRepository {

//    private final String select_All = "SELECT KhuyenMai.id,KhuyenMai.Ten,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai,SanPham.Ten\n" +
//"FROM KhuyenMai JOIN SanPham ON KhuyenMai.id = SanPham.Id";
    private final String select_All ="SELECT id,KhuyenMai.Ten,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai from KhuyenMai";
    private final String insert = "INSERT INTO KhuyenMai(Ten,NgayBatDau,NgayKetThuc,GiamGia,TrangThai) \n" +
"VALUES(?,?,?,?,?)";
    private final String update = "UPDATE KhuyenMai SET Ten= ?,NgayBatDau =?,NgayKetThuc=?,GiamGia=?,TrangThai = ? WHERE id = ?";
    private final String delete = "DELETE FROM KhuyenMai WHERE id LIKE ?";
    private final String search = "SELECT id,KhuyenMai.Ten,NgayBatDau,NgayKetThuc,GiamGia,KhuyenMai.TrangThai FROM KhuyenMai WHERE KhuyenMai.Ten LIKE ?";
    
    public List<KhuyenMaiView> getList() {
        List<KhuyenMaiView> listKM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                KhuyenMaiView km = new KhuyenMaiView();
                km.setIdKhuyenMai(rs.getString(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setNgayBatDau(rs.getDate(3));
                km.setNgayKetThuc(rs.getDate(4));
                km.setGiamGia(rs.getInt(5));
                km.setTrangThai(rs.getInt(6));
                listKM.add(km);
            }
            rs.getStatement().getConnection().close();
            return listKM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public boolean insert(KhuyenMai km) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, km.getTenKhuyenMai(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getGiamGia(), km.getTrangThai());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return check > 0;
    }

    
    public boolean update(String idKM, KhuyenMai km) {
        int check = 0;
        try {
            check = DBConnect.Update(update, km.getTenKhuyenMai(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getGiamGia(), km.getTrangThai(),idKM);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

  
    public boolean delete(String idKM) {
         int check = 0;
        try {
            check = DBConnect.Update(delete,idKM);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return check > 0;
    }


    public List<KhuyenMaiView> getSearch(String tenKM) {
List<KhuyenMaiView> listKM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(search,"%"+tenKM+"%");
            while (rs.next()) {
                KhuyenMaiView km = new KhuyenMaiView();
                km.setIdKhuyenMai(rs.getString(1));
                km.setTenKhuyenMai(rs.getString(2));
                km.setNgayBatDau(rs.getDate(3));
                km.setNgayKetThuc(rs.getDate(4));
                km.setGiamGia(rs.getInt(5));
                km.setTrangThai(rs.getInt(6));
                listKM.add(km);
            }
            rs.getStatement().getConnection().close();
            return listKM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
