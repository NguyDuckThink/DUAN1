package services;

import java.util.List;
import models.SanPham;
import models.Size;

public interface SanPhamService {

    List<SanPham> getList();

    String add(SanPham kt);

    String update(String id, SanPham tenSP);
    
    String delete(String id);
    
}
