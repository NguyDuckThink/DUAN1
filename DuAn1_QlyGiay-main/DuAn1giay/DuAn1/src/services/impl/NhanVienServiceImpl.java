package services.impl;

import java.util.List;
import models.NhanVien;
import repositories.NhanVienRepository;
import services.NhanVienService;
import viewmodels.NhanVienViewModel;

public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVienViewModel> getList(int trangThai) {
        return nhanVienRepository.getList(trangThai);
    }

    @Override
    public String add(NhanVien nv) {
//        if (nv.getMaNhanVien().isEmpty()) {
//            return "Mã Nhân Viên không được để trống!";
//        }
//        if (nv.getTenNhanVien().isEmpty()) {
//            return "Tên Nhân Viên không được để trống!";
//        }
//        if (nv.getNgaySinh().isEmpty()) {
//            return "Ngày Sinh không được để trống!";
//        }
//        if (nv.getSoDienThoai().isEmpty()) {
//            return "Số Điện Thoại không được để trống!";
//        }
//        if (nv.getDiaChi().isEmpty()) {
//            return "Địa Chỉ không được để trống!";
//        }
//        if (nv.getEmail().isEmpty()) {
//            return "Email không được để trống!";
//        }
//        if (nv.getMatKhau().isEmpty()) {
//            return "Mật Khẩu  không được để trống!";
//        }
        if (nhanVienRepository.add(nv)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(String maNV, NhanVien nv) {
        if (nhanVienRepository.update(maNV, nv)) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String maNV) {
        if (nhanVienRepository.delete(maNV)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public List<NhanVienViewModel> getSearch(String tenNV, String sdt,int trangThai) {
        return nhanVienRepository.getSearch(tenNV, sdt,trangThai);
    }

}
