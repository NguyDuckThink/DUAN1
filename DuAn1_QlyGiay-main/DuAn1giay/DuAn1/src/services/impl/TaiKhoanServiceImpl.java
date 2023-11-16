package services.impl;

import models.NhanVien;
import repositories.TaiKhoanRepository;
import repositories.TaiKhoanRepository;
import services.TaiKhoanService;

public class TaiKhoanServiceImpl implements TaiKhoanService {

    private TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

    @Override
    public NhanVien login(String tenDangNhap, String matKhau) {
        return taiKhoanRepository.login(tenDangNhap, matKhau);
    }

    @Override
    public boolean updateMK(String email, String mKM) {
        return taiKhoanRepository.updateMK(email, mKM);
    }

}
