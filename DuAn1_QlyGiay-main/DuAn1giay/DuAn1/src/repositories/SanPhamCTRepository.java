
package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.SanPham;
import models.SanPhamCT;
import utilities.DBConnect;
import viewmodels.SanPhamCTViewModel;

public class SanPhamCTRepository {
     
//    private final String select_All = "SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong \n"
//            + "FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham \n"
//            + "JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac \n"
//            + "JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu \n"
//            + "JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc Where TrangThai LIKE ?";
    private final String select_All="SELECT SanPhamCT.Id,SanPham.Ten,LoaiSp.Ten, MauSac.Ten,Size.Ten,ChatLieu.Ten,ThuongHieu.Ten,GiaBan,SoLuong \n"
            +"FROM SanPhamCT JOIN LoaiSP ON SanPhamCT.LoaiSP_id = LoaiSP.id\n"
            +"JOIN SanPham ON SanPhamCT.SanPham_id=SanPham.id \n"
            +"JOIN MauSac ON SanPhamCT.MauSac_id = MauSac.id\n"
            +"JOIN ChatLieu ON SanPhamCT.ChatLieu_id = ChatLieu.id\n"
            +"JOIN ThuongHieu ON SanPhamCT.ThuongHieu_id=ThuongHieu.id \n"
            +"JOIN Size ON SanPhamCT.Size_id = Size.id Where SanPhamCT.TrangThai LIKE ?";
//    private final String insert = "INSERT INTO SanPham(TenSanPham,MaLoaiSanPham,MaMauSac,MaKichThuoc,MaChatLieu,GiaBan,SoLuong)VALUES (?,?,?,?,?,?,?);";
    private final String insert ="INSERT INTO SanPhamCT(SanPham_id,MauSac_Id,Size_Id,ThuongHieu_Id,ChatLieu_Id,LoaiSP_Id,GiaBan,SoLuong)VALUES(?,?,?,?,?,?,?,?)";
//    private final String search = "SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong \n"
//            + "FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham \n"
//            + "JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac \n"
//            + "JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu \n"
//            + "JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc WHERE TenSanPham LIKE ?";
    private final String search ="SELECT SanPhamCT.Id,SanPham.Ten,LoaiSp.Ten, MauSac.Ten,Size.Ten,ChatLieu.Ten,GiaBan,SoLuong \n"
             +"FROM SanPhamCT Join SanPham on SanPhamCT.SanPham_Id = SanPham.Id\n" 
             +"JOIN LoaiSP ON SanPhamCT.LoaiSP_id = LoaiSP.id\n" 
             +"JOIN MauSac ON SanPhamCT.MauSac_id = MauSac.id\n"
             +"JOIN ChatLieu ON SanPhamCT.ChatLieu_id = ChatLieu.id\n" 
             +"JOIN Size ON SanPhamCT.Size_id = Size.id Where SanPham.Ten like ?";
    
    private final String update = "UPDATE SanPhamCT SET SanPham_Id=?,MauSac_Id =?,Size_Id=?,ThuongHieu_Id=?,ChatLieu_Id=?,LoaiSP_Id=?,GiaBan=?,SoLuong=? WHERE id = ?";
    private final String hide = "UPDATE SanPhamCT SET TrangThai=? WHERE id = ?";
//    private final String select_By_Id = "SELECT SanPham.MaSanPham,TenSanPham,GiaBan,SoLuong FROM SanPham WHERE MaSanPham LIKE ?";
//    private final String select_By_Id = "SELECT SanPhamCT.Id,SanPham.Ten,GiaBan,SoLuong FROM SanPhamCT join SanPham on SanPhamCT.SanPham_Id = SanPham.Id  WHERE SanPhamCT.Id = ?";
//    private final String select_By_MaLSP = "SELECT MaSanPham,TenSanPham,LoaiSanPham.TenLoaiSanPham, MauSac.TenMauSac,KichThuoc.TenKichThuoc,ChatLieu.TenChatLieu,GiaBan,SoLuong \n"
//            + "            FROM SanPham JOIN LoaiSanPham ON SanPham.MaLoaiSanPham = LoaiSanPham.MaLoaiSanPham \n"
//            + "            JOIN MauSac ON SanPham.MaMauSac = MauSac.MaMauSac \n"
//            + "            JOIN ChatLieu ON SanPham.MaChatLieu = ChatLieu.MaChatLieu \n"
//            + "           JOIN KichThuoc ON SanPham.MaKichThuoc = KichThuoc.MaKichThuoc WHERE LoaiSanPham.TenLoaiSanPham LIKE ?";
    private final String select_By_Id="SELECT id,SanPham_Id,GiaBan,SoLuong FROM SanPhamCT where id like ?";
    private final String select_By_MaLSP="SELECT SanPhamCT.Id,SanPham.Ten,LoaiSp.Ten, MauSac.Ten,Size.Ten,ChatLieu.Ten,GiaBan,SoLuong \n"
             +"FROM SanPhamCT Join SanPham on SanPhamCT.SanPham_Id = SanPham.Id\n" 
             +"JOIN LoaiSP ON SanPhamCT.LoaiSP_id = LoaiSP.id\n" 
             +"JOIN MauSac ON SanPhamCT.MauSac_id = MauSac.id\n"
             +"JOIN ChatLieu ON SanPhamCT.ChatLieu_id = ChatLieu.id\n" 
             +"JOIN Size ON SanPhamCT.Size_id = Size.id Where LoaiSP.Ten like ?";
   

    public List<SanPhamCTViewModel> getList(int TrangThai) {
        List<SanPhamCTViewModel> listSPCTVM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All, TrangThai);
            while (rs.next()) {
                SanPhamCTViewModel sp = new SanPhamCTViewModel();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenLoaiSP(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenKichThuoc(rs.getString(5));
                sp.setTenChatLieu(rs.getString(6));
                sp.setTenThuongHieu(rs.getString(7));
                sp.setGiaBan(rs.getDouble(8));
                sp.setSoLuong(rs.getInt(9));
                listSPCTVM.add(sp);
            }
            rs.getStatement().getConnection().close();
            return listSPCTVM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(SanPhamCT spct) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, spct.getIdSanPham(), spct.getIdMauSac(), spct.getIdSize(), spct.getIdThuongHieu(), spct.getIdChatLieu(),spct.getIdLoaiSP(), spct.getGiaBan(), spct.getSoLuong());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

   
    public boolean update(String id, SanPhamCT spct) {
        int check = 0;
        try {
            check = DBConnect.Update(update, spct.getIdSanPham(), spct.getIdMauSac(), spct.getIdSize(), spct.getIdThuongHieu(), spct.getIdChatLieu(), spct.getIdLoaiSP(),spct.getGiaBan() ,spct.getSoLuong(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    
    public boolean hide(int trangThai, String id) {
        int check = 0;
        try {
            check = DBConnect.Update(hide, trangThai, id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    
    public List<SanPhamCTViewModel> getSearch(String tenSP) {
        List<SanPhamCTViewModel> listSPCTVM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(search, "%" + tenSP + "%");
            while (rs.next()) {
                SanPhamCTViewModel sp = new SanPhamCTViewModel();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenLoaiSP(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenKichThuoc(rs.getString(5));
                sp.setTenChatLieu(rs.getString(6));
                sp.setGiaBan(rs.getDouble(7));
                sp.setSoLuong(rs.getInt(8));
                listSPCTVM.add(sp);
            }
            rs.getStatement().getConnection().close();
            return listSPCTVM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

   
    public SanPhamCT getSanPhamByMa(Integer id) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Id, id);
            while (rs.next()) {
                SanPhamCT sp = new SanPhamCT();
                sp.setId(rs.getInt(1));
                sp.setIdSanPham(rs.getInt(2));
                sp.setGiaBan(rs.getDouble(3));
                sp.setSoLuong(rs.getInt(4));
                return sp;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;

    }

    
    public List<SanPhamCTViewModel> getSanPhamByMaLSP(String maSP) {
        List<SanPhamCTViewModel> listSPCTVM = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_By_MaLSP, maSP);
            while (rs.next()) {
                SanPhamCTViewModel sp = new SanPhamCTViewModel();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenLoaiSP(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenKichThuoc(rs.getString(5));
                sp.setTenChatLieu(rs.getString(6));
                sp.setGiaBan(rs.getDouble(7));
                sp.setSoLuong(rs.getInt(8));
                listSPCTVM.add(sp);
            }
            rs.getStatement().getConnection().close();
            return listSPCTVM;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    
    public int updateSLSP(String id, int soLuong) {
        String sql = "UPDATE SanPhamCT SET SoLuong = (SoLuong - ?) WHERE id LIKE ?";
        try {
            return DBConnect.Update(sql, soLuong, id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

   
    public int updateSLGH(String id, int soLuong) {
        String sql = "UPDATE SanPhamCT SET SoLuong = (SoLuong + ?) WHERE MaSanPham LIKE ?";
        try {
            return DBConnect.Update(sql, soLuong, id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
