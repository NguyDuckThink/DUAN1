package services;

import java.sql.ResultSet;
import java.util.List;
import models.HoaDon;
import viewmodels.HoaDonView;

public interface HoaDonService {

    List<HoaDonView> getList();

    List<HoaDonView> getSearch(String ngayTao, String idHD);
    
    String add(HoaDon hd);

    ResultSet demidHD(String idHD);

    ResultSet getByidHD(String idHD);
}
