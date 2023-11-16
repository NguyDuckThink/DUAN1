package repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.KhachHang;
import repositories.KhachHangRepository;
import utilities.DBConnect;
import viewmodels.KhachHangView;

public class KhachHangRepository {

   
    public List<KhachHangView> getList() {
        List<KhachHangView> listKH = new ArrayList<>();
        String sql = "SELECT Id,Ten,sdt,DiaChi FROM KhachHang";

        try {
            ResultSet rs = DBConnect.Query(sql);
            while (rs.next()) {
                KhachHangView kh = new KhachHangView();
                kh.setIdKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                listKH.add(kh);
            }
            rs.getStatement().getConnection().close();
            return listKH;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

   
    public boolean update(String idKH, KhachHang kh) {
        String sql = "update KhachHang set Ten= ?,SoDienThoai=?,DiaChi=? where id =?";

        int row = 0;
        try {
            row = DBConnect.Update(sql, kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getDiaChi(), idKH);
        } catch (Exception e) {
        }
        return row > 0;
    }

  
    public boolean delete(String idKH) {
        String sql = "delete from KhachHang where id =?";
        int row = 0;
        try {
            row = DBConnect.Update(sql, idKH);
        } catch (Exception e) {
        }
        return row > 0;
    }

  
    public List<KhachHangView> getSearch(String sdt, String tenKH) {
        List<KhachHangView> listKH = new ArrayList<>();
        String sql = "SELECT Id,Ten,Sdt,DiaChi FROM KhachHang WHERE  Sdt LIKE ? OR  Ten LIKE ?";

        try {
            ResultSet rs = DBConnect.Query(sql, "%" + sdt + "%", "%" + tenKH + "%");
            while (rs.next()) {
               KhachHangView kh = new KhachHangView();
                kh.setIdKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                listKH.add(kh);
            }
            rs.getStatement().getConnection().close();
            return listKH;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

  
    public boolean add(KhachHang kh) {
        String sql = "insert into KhachHang(Ten,SoDienThoai,DiaChi) values (?,?,?)";
        int row = 0;
        try {
            row = DBConnect.Update(sql, kh.getTenKhachHang(), kh.getSoDienThoai(), kh.getDiaChi());
        } catch (Exception e) {
        }

        return row > 0;
    }
}
