package services.impl;

import java.util.List;
import models.ChiTietHoaDon;
import repositories.ChiTietHoaDonRepository;
import repositories.ChiTietHoaDonRepository;
import services.ChiTietHoaDonService;
import viewmodels.ChiTietHoaDonView;

public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {

    private final ChiTietHoaDonRepository chiTietHoaDonRepository = new ChiTietHoaDonRepository();

    @Override
    public List<ChiTietHoaDonView> getList(String maHD) {
        return chiTietHoaDonRepository.getList(maHD);
    }

    @Override
    public List<ChiTietHoaDonView> getCTHoaDonByMaSP(String maSP) {
        return chiTietHoaDonRepository.getCTHoaDonByMaSP(maSP);

    }

    @Override
    public boolean add(ChiTietHoaDon cthd) {
          return chiTietHoaDonRepository.add(cthd);
    }
    

    
}
