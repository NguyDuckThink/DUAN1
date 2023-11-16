package services.impl;

import java.util.List;
import models.LoaiSP;
import repositories.LoaiSPRepository;
import services.LoaiSPService;

public class LoaiSPServiceImpl implements LoaiSPService {

    LoaiSPRepository loaiSPRepository = new LoaiSPRepository();

    @Override
    public List<LoaiSP> getList() {
        return loaiSPRepository.getList();
    }

    @Override
    public String add(LoaiSP lsp) {
        LoaiSP NewLSP = loaiSPRepository.getLoaiSPByTen(lsp.getTen());
        if (lsp.getTen().isEmpty()) {
            return "Tên thược tính không được để trống!";
        }
        if (NewLSP != null) {
            return "Tên loại sản phẩm đã tồn tại!";
        }
        if (loaiSPRepository.add(lsp)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String delete(String tenLSP) {
        if (loaiSPRepository.delete(tenLSP)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public String update(String maLSP, LoaiSP tenLSP) {
        LoaiSP NewLSP = loaiSPRepository.getLoaiSPByTen(tenLSP.getTen());
        if (tenLSP.getTen().isEmpty()) {
            return "Tên thược tính không được để trống!";
        }
        if (NewLSP != null) {
            return "Tên loại sản phẩm đã tồn tại!";
        }
        if (loaiSPRepository.update(maLSP, tenLSP)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại";
        }
    }

}
