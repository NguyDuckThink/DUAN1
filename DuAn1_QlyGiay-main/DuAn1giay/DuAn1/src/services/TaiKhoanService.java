
package services;

import models.NhanVien;


public interface TaiKhoanService {
    NhanVien login(String tenDangNhap, String matKhau);
    
    boolean updateMK(String email, String mKM);
}
