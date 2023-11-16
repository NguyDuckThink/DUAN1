package services;

import java.util.List;
import models.Size;
import models.ThuongHieu;

public interface SizeService {

    List<Size> getList();

    String add(Size kt);

    String update(String id, Size tenKT);
    
    String delete(String tenKT);
    
}
