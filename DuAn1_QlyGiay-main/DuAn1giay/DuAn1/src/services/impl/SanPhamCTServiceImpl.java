package services.impl;

import java.util.List;
import models.SanPham;
import models.SanPhamCT;
import repositories.SanPhamCTRepository;
import repositories.SanPhamRepository;
import services.SanPhamCTService;
import services.SanPhamService;
import viewmodels.SanPhamCTViewModel;

public class SanPhamCTServiceImpl implements SanPhamCTService {

    private final SanPhamCTRepository sanPhamCTRepository = new SanPhamCTRepository();

    @Override
    public List<SanPhamCTViewModel> getList(int TrangThai) {
        return sanPhamCTRepository.getList(TrangThai);
    }

    @Override
    public String add(SanPhamCT spct) {
        if (sanPhamCTRepository.add(spct)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public List<SanPhamCTViewModel> getSearch(String tenSP) {
        return sanPhamCTRepository.getSearch(tenSP);
    }

    @Override
    public String update(String id, SanPhamCT spct) {
        if (sanPhamCTRepository.update(id, spct)) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

//    @Override
//    public SanPham getSanPhamByMa(String maSP) {
//        return sanPhamRepository.getSanPhamByMa(maSP);
//    }
    @Override
    public String hide(int trangThai, String id) {
        if (sanPhamCTRepository.hide(trangThai, id)) {
            return "Ẩn thành công!";
        } else {
            return "Ẩn thất bại!";
        }
    }

    @Override
    public List<SanPhamCTViewModel> getSanPhamByMaLSP(String tenLSP) {
        return sanPhamCTRepository.getSanPhamByMaLSP(tenLSP);
    }

    @Override
    public SanPhamCT getSanPhamByMa(Integer id) {
        return sanPhamCTRepository.getSanPhamByMa(id);
    }

    @Override
    public int updateSLSP(String id, int soLuong) {
        return sanPhamCTRepository.updateSLSP(id, soLuong);
    }

    @Override
    public int updateSLGH(String id, int soLuong) {
        return sanPhamCTRepository.updateSLGH(id, soLuong);
    }

}
