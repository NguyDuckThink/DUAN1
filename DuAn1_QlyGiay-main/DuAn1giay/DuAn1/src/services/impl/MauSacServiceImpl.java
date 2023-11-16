package services.impl;

import java.util.List;
import models.MauSac;
import repositories.MauSacRepository;
import services.MauSacService;

public class MauSacServiceImpl implements MauSacService {

    MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getList() {
        return mauSacRepository.getList();
    }

    @Override
    public String add(MauSac ms) {
        MauSac NewMS = mauSacRepository.getMauSacByTen(ms.getTen());
        if (ms.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewMS != null) {
            return "Tên màu sắc đã tồn tại!";
        }
        if (mauSacRepository.add(ms)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String delete(String id) {
        if (mauSacRepository.delete(id)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(String id, MauSac ten) {
        MauSac NewMS = mauSacRepository.getMauSacByTen(ten.getTen());
        if (ten.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewMS != null) {
            return "Tên màu sắc đã tồn tại!";
        }
        if (mauSacRepository.update(id, ten)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }
    }
}
