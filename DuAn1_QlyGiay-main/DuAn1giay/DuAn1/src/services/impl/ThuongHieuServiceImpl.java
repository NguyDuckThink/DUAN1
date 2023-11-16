package services.impl;

import java.util.List;
import models.Size;
import models.ThuongHieu;
import repositories.ChatLieuRepository;
import repositories.SizeRepository;
import repositories.ThuongHieuRepository;

import services.SizeService;
import services.ThuongHieuService;

public class ThuongHieuServiceImpl implements ThuongHieuService {
    ThuongHieuRepository thuonghieuRepository = new ThuongHieuRepository();
    @Override
    public List<ThuongHieu> getList() {
        return thuonghieuRepository.getList();
        }

    @Override
    public String add(ThuongHieu kt) {
         ThuongHieu NewTH = thuonghieuRepository.getThuongHieuByTen(kt.getTen());
        if (kt.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewTH != null) {
            return "Tên Thuong hieu đã tồn tại!";
        }
        if (thuonghieuRepository.add(kt)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại";
        }
      }

    @Override
    public String update(String id, ThuongHieu tenTh) {
     ThuongHieu NewTH = thuonghieuRepository.getThuongHieuByTen(tenTh.getTen());
        if (tenTh.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewTH != null) {
            return "Tên thuong hieu đã tồn tại!";
        }
        if (thuonghieuRepository.update(id, tenTh)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }     
    }

    @Override
    public String delete(String id) {
         if (thuonghieuRepository.delete(id)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
        }



}
