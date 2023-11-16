package repositories;

import repositories.TaiKhoanRepository;
import utilities.DBConnect;
import java.sql.*;
import models.NhanVien;

public class TaiKhoanRepository {

    public NhanVien login(String tenDangNhap, String matKhau) {

        String sql = "SELECT Ten,Email,MatKhau,VaiTro FROM NhanVien WHERE Email LIKE ? AND MatKhau LIKE ?";
        NhanVien nv = null;
        try {
            ResultSet rs = DBConnect.Query(sql, tenDangNhap, matKhau);
            if (rs.next()) {
                nv = new NhanVien();
                nv.setTenNhanVien(rs.getString(1));
                nv.setEmail(rs.getString(2));
                nv.setMatKhau(rs.getString(3));
                nv.setVaiTro(rs.getBoolean(4));
            }
            rs.getStatement().getConnection().close();
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateMK(String email, String mKM) {
        String sql = "UPDATE NhanVien SET MatKhau = ? WHERE Email LIKE ?";
        int check = 0;
        try {
            check = DBConnect.Update(sql, mKM, email);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }


}
