package services;

import java.util.List;
import models.ThuongHieu;

public interface ThuongHieuService {

    List<ThuongHieu> getList();

    String add(ThuongHieu kt);

    String update(String id, ThuongHieu tenTh);
    
    String delete(String id);
    
}
