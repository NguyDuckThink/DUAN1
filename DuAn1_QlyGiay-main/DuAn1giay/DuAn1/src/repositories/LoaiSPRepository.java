
package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.LoaiSP;
import utilities.DBConnect;


public class LoaiSPRepository {
       private final String select_All = "SELECT * FROM LoaiSP";
    private final String insert = "INSERT INTO LoaiSP(Ten) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM LoaiSP WHERE Ten = ?";
    private final String delete = "DELETE FROM LoaiSP WHERE Id = ?";
    private final String update = "UPDATE LoaiSP SET Ten = ? WHERE Id = ? ";

    public List<LoaiSP> getList() {
        List<LoaiSP> listCL = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                LoaiSP lsp = new LoaiSP();
                lsp.setId(rs.getInt(1));
                lsp.setTen(rs.getString(2));
                listCL.add(lsp);
            }
            rs.getStatement().getConnection().close();
            return listCL;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(LoaiSP lsp) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, lsp.getTen());
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

    public LoaiSP getLoaiSPByTen(String ten) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, ten);
            while (rs.next()) {
                LoaiSP lsp = new LoaiSP();
                lsp.setId(rs.getInt(1));
                lsp.setTen(rs.getString(2));
                return lsp;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public boolean update(String id, LoaiSP ten) {
        int check = 0;
        try {
            check = DBConnect.Update(update, ten.getTen(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
