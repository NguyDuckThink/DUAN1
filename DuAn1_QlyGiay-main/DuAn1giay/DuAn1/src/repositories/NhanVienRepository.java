
package repositories;

import java.util.ArrayList;
import java.util.List;
import repositories.NhanVienRepository;
import utilities.DBConnect;
import viewmodels.NhanVienViewModel;
import java.sql.*;
import models.NhanVien;


public class NhanVienRepository{
      
    public List<NhanVienViewModel> getList(int trangThai) {
        List<NhanVienViewModel> listNV = new ArrayList<>();
        String sql = "SELECT  MaNhanVien,TenNhanVien,GioiTinh ,NgaySinh,Sdt,Email,DiaChi,MatKhau,TrangThai FROM NhanVien WHERE TrangThai LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(sql, trangThai);
            while (rs.next()) {
                NhanVienViewModel nv = new NhanVienViewModel();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTenNhanVien(rs.getString(2));
                nv.setGioiTinh(rs.getInt(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setSoDienThoai(rs.getString(5));
                nv.setEmail(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setMatKhau(rs.getString(8));
                nv.setTrangThai(rs.getInt(9));
                listNV.add(nv);
            }
            rs.getStatement().getConnection().close();
            return listNV;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public boolean add(NhanVien nv) {
        String sql = "INSERT INTO NhanVien(TenNhanVien,GioiTinh,NgaySinh,Sdt,Email,DiaChi,TrangThai)VALUES (?,?,?,?,?,?,?)";
        int check = 0;
        try {
            check = DBConnect.Update(sql, nv.getTenNhanVien(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSdt(), nv.getEmail(), nv.getDiaChi(),nv.getTrangThai());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    
    public boolean update(String maNV, NhanVien nv) {
        String sql = "UPDATE NhanVien SET Ten = ?,GioiTinh = ?,NgaySinh = ?,SoDienThoai = ?,Email = ?,DiaChi = ?, TrangThai = ? WHERE MaNhanVien LIKE ?";
        int check = 0;
        try {
            check = DBConnect.Update(sql, nv.getTenNhanVien(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSdt(), nv.getEmail(), nv.getDiaChi(),nv.getTrangThai(), maNV);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    
    public boolean delete(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNhanVien LIKE ?";
        int check = 0;
        try {
            check = DBConnect.Update(sql, maNV);
        } catch (Exception e) {
        }
        return check > 0;
    }

    public List<NhanVienViewModel> getSearch(String tenNV, String sdt, int trangThai) {
        List<NhanVienViewModel> listNV = new ArrayList<>();
        String sql = "SELECT  MaNhanVien,TenNhanVien ,GioiTinh ,NgaySinh,SoDienThoai,Email,DiaChi,MatKhau,TrangThai FROM NhanVien WHERE (TenNhanVien LIKE ? OR SoDienThoai LIKE ?) AND TrangThai LIKE ?";
        try {
            ResultSet rs = DBConnect.Query(sql, "%" + tenNV + "%", "%" + sdt + "%",trangThai);
            while (rs.next()) {
                   NhanVienViewModel nv = new NhanVienViewModel();
                nv.setMaNhanVien(rs.getString(1));
                nv.setTenNhanVien(rs.getString(2));
                nv.setGioiTinh(rs.getInt(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setSoDienThoai(rs.getString(5));
                nv.setEmail(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setMatKhau(rs.getString(8));
                nv.setTrangThai(rs.getInt(9));
                listNV.add(nv);
            }
            rs.getStatement().getConnection().close();
            return listNV;
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }
    }
}
