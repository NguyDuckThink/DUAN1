package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.SanPham;
import utilities.DBConnect;

public class SanPhamRepository {

    private final String select_All = "SELECT * FROM SanPham";
    private final String insert = "INSERT INTO SanPham(Ten) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM SanPham WHERE Ten = ?";
    private final String delete = "DELETE FROM SanPham WHERE Id = ?";
    private final String update = "UPDATE SanPham SET Ten = ? WHERE Id = ? ";

    public List<SanPham> getList() {
        List<SanPham> listSP = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                SanPham th = new SanPham();
                th.setId(rs.getInt(1));
                th.setTen(rs.getString(2));
                listSP.add(th);
            }
            rs.getStatement().getConnection().close();
            return listSP;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(SanPham th) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, th.getTen());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        int check = 0;
        try {
            check = DBConnect.Update(delete, id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }

    public SanPham getSanPhamByTen(String ten) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, ten);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt(1));
                sp.setTen(rs.getString(2));
                return sp;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public boolean update(String id, SanPham ten) {
        int check = 0;
        try {
            check = DBConnect.Update(update, ten.getTen(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
