package services.impl;

import java.util.List;
import models.SanPham;
import models.Size;
import models.ThuongHieu;
import repositories.SanPhamRepository;
import repositories.SizeRepository;
import services.SanPhamService;

import services.SizeService;

public class SanPhamServiceImpl implements SanPhamService {

    SanPhamRepository sanphamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getList() {
        return sanphamRepository.getList();
    }

    @Override
    public String add(SanPham sp) {
        SanPham NewSP = sanphamRepository.getSanPhamByTen(sp.getTen());
        if (sp.getTen().isEmpty()) {
            return "Tên San Pham không được để trống!";
        }
        if (NewSP != null) {
            return "Tên San Pham đã tồn tại!";
        }
        if (sanphamRepository.add(sp)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String id) {
        if (sanphamRepository.delete(id)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(String id, SanPham tenSP) {
        SanPham NewSP = sanphamRepository.getSanPhamByTen(tenSP.getTen());
        if (tenSP.getTen().isEmpty()) {
            return "Tên San Pham không được để trống!";
        }
        if (NewSP != null) {
            return "Tên San Pham đã tồn tại!";
        }
        if (sanphamRepository.update(id, tenSP)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }
    }



}
