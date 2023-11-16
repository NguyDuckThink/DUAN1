package services.impl;

import java.util.List;
import models.KhuyenMai;
import repositories.KhuyenMaiRepository;
import services.KhuyenMaiService;
import viewmodels.KhuyenMaiView;

public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    
    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();
    
    @Override
    public List<KhuyenMaiView> getList() {
        return khuyenMaiRepository.getList();
    }
    
    @Override
    public String insert(KhuyenMai km) {
        if (khuyenMaiRepository.insert(km)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }
    
    @Override
    public String update(String idKM, KhuyenMai km) {
        if (khuyenMaiRepository.update(idKM, km)) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }
    
    @Override
    public String delete(String idKM) {
        if (khuyenMaiRepository.delete(idKM)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại!";
        }
    }
    
    @Override
    public List<KhuyenMaiView> getSearch(String tenKM) {
        return khuyenMaiRepository.getSearch(tenKM);
        
    }
    
}
