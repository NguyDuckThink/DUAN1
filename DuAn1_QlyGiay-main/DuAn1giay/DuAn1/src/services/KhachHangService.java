package services;

import java.util.List;
import models.KhachHang;
import viewmodels.KhachHangView;

public interface KhachHangService {

    List<KhachHangView> getList();

    String add(KhachHang kh);

    String update(String idKH, KhachHang kh);

    String delete(String idKH);

    List<KhachHangView> getSearch(String sdt, String tenKH);
}
