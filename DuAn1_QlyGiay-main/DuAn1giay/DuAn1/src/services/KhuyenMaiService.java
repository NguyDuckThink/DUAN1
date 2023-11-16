
package services;

import java.util.List;
import models.KhuyenMai;
import viewmodels.KhuyenMaiView;


public interface KhuyenMaiService {
     List<KhuyenMaiView> getList();

    String insert(KhuyenMai km);

    String update(String idKM, KhuyenMai km);

    String delete(String idKM);

    List<KhuyenMaiView> getSearch(String tenKM);
}
