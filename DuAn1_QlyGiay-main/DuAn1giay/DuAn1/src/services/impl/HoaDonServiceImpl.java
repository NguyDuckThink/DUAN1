package services.impl;

import java.sql.ResultSet;
import java.util.List;
import models.HoaDon;
import repositories.HoaDonRepository;
import repositories.HoaDonRepository;
import services.HoaDonService;
import viewmodels.HoaDonView;

public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public List<HoaDonView> getList() {
        return hoaDonRepository.getList();
    }

    @Override
    public List<HoaDonView> getSearch(String ngayTao, String idHD) {
        return hoaDonRepository.getSearch(ngayTao, idHD);

    }


    @Override
    public String add(HoaDon hd) {
        if (hoaDonRepository.add(hd)) {
            return "Thanh toán thành công!";
        } else {
            return "Thanh toán thất bại!";
        }
    }

    @Override
    public ResultSet demidHD(String maHD) {
        return hoaDonRepository.demidHD(maHD);
    }

    @Override
    public ResultSet getByidHD(String maHD) {
        return hoaDonRepository.getByidHD(maHD);
    }

}
