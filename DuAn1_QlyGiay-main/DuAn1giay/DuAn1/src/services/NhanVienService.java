package services;

import java.util.List;
import models.NhanVien;
import viewmodels.NhanVienViewModel;

public interface NhanVienService {

    List<NhanVienViewModel> getList(int trangThai);

    String add(NhanVien nv);

    String update(String maNv, NhanVien nv);

    String delete(String maNv);

    List<NhanVienViewModel> getSearch(String tenNV, String sdt,int trangThai);
}
