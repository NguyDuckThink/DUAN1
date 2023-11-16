package services.impl;

import java.util.List;
import models.Size;
import models.ThuongHieu;
import repositories.SizeRepository;

import services.SizeService;

public class SizeServiceImpl implements SizeService {

    SizeRepository sizeRepository = new SizeRepository();

    @Override
    public List<Size> getList() {
        return sizeRepository.getList();
    }

    @Override
    public String add(Size kt) {
        Size NewKT = sizeRepository.getSizeByTen(kt.getTen());
        if (kt.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewKT != null) {
            return "Tên kích thước đã tồn tại!";
        }
        if (sizeRepository.add(kt)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String delete(String tenKT) {
        if (sizeRepository.delete(tenKT)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(String id, Size tenKT) {
        Size NewKT = sizeRepository.getSizeByTen(tenKT.getTen());
        if (tenKT.getTen().isEmpty()) {
            return "Tên thuộc tính không được để trống!";
        }
        if (NewKT != null) {
            return "Tên kích thước đã tồn tại!";
        }
        if (sizeRepository.update(id, tenKT)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }
    }

}
