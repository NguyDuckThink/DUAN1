
package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.MauSac;
import utilities.DBConnect;


public class MauSacRepository {
       private final String select_All = "SELECT * FROM MauSac";
    private final String insert = "INSERT INTO MauSac(Ten) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM MauSac WHERE Ten = ?";
    private final String delete = "DELETE FROM MauSac WHERE Id = ?";
    private final String update = "UPDATE MauSac SET Ten = ? WHERE Id = ? ";

    public List<MauSac> getList() {
        List<MauSac> listMS = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getInt(1));
                ms.setTen(rs.getString(2));
                listMS.add(ms);
            }
            rs.getStatement().getConnection().close();
            return listMS;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(MauSac ms) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, ms.getTen());
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

    public MauSac getMauSacByTen(String ten) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, ten);
            while (rs.next()) {
                MauSac ms = new MauSac();
                 ms.setId(rs.getInt(1));
                ms.setTen(rs.getString(2));
                return ms;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public boolean update(String id, MauSac ten) {
        int check = 0;
        try {
            check = DBConnect.Update(update, ten.getTen(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
