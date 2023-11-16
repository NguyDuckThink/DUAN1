package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ThuongHieu;
import utilities.DBConnect;

public class ThuongHieuRepository {

    private final String select_All = "SELECT * FROM ThuongHieu";
    private final String insert = "INSERT INTO ThuongHieu(Ten) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM ThuongHieu WHERE Ten = ?";
    private final String delete = "DELETE FROM ThuongHieu WHERE Id = ?";
    private final String update = "UPDATE ThuongHieu SET Ten = ? WHERE Id = ? ";

    public List<ThuongHieu> getList() {
        List<ThuongHieu> listCL = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu();
                th.setId(rs.getInt(1));
                th.setTen(rs.getString(2));
                listCL.add(th);
            }
            rs.getStatement().getConnection().close();
            return listCL;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(ThuongHieu th) {
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

    public ThuongHieu getThuongHieuByTen(String ten) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, ten);
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu();
                th.setId(rs.getInt(1));
                th.setTen(rs.getString(2));
                return th;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public boolean update(String id, ThuongHieu ten) {
        int check = 0;
        try {
            check = DBConnect.Update(update, ten.getTen(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
