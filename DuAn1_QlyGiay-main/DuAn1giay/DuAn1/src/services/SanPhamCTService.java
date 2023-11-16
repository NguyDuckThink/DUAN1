package services;

import java.util.List;
import models.SanPham;
import models.SanPhamCT;
import viewmodels.SanPhamCTViewModel;

public interface SanPhamCTService {

    List<SanPhamCTViewModel> getList(int TrangThai);

    String add(SanPhamCT spct);

    List<SanPhamCTViewModel> getSearch(String tenSP);

    String update(String maSP, SanPhamCT spct);

    List<SanPhamCTViewModel> getSanPhamByMaLSP(String tenLSP);

    String hide(int trangThai, String id);

    SanPhamCT getSanPhamByMa(Integer id);

    int updateSLSP(String id, int soLuong);

    int updateSLGH(String id, int soLuong);

}
