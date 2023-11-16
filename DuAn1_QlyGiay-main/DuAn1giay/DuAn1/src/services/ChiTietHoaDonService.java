
package services;

import java.util.List;
import models.ChiTietHoaDon;
import viewmodels.ChiTietHoaDonView;


public interface ChiTietHoaDonService {
    List<ChiTietHoaDonView> getList(String maHD);
    
    List<ChiTietHoaDonView> getCTHoaDonByMaSP(String maSP);
    
    boolean add(ChiTietHoaDon cthd);
}
