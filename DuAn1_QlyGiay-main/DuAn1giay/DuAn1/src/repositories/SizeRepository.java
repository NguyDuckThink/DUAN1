package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Size;
import utilities.DBConnect;

public class SizeRepository {

    private final String select_All = "SELECT * FROM Size";
    private final String insert = "INSERT INTO Size(Ten) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM Size WHERE Ten = ?";
    private final String delete = "DELETE FROM Size WHERE Id = ?";
    private final String update = "UPDATE Size SET Ten = ? WHERE Id = ? ";

    public List<Size> getList() {
        List<Size> listSize = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                Size kt = new Size();
                kt.setId(rs.getInt(1));
                kt.setTen(rs.getString(2));
                listSize.add(kt);
            }
            rs.getStatement().getConnection().close();
            return listSize;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(Size kt) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, kt.getTen());
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

    public Size getSizeByTen(String ten) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, ten);
            while (rs.next()) {
                Size kt = new Size();
                kt.setId(rs.getInt(1));
                kt.setTen(rs.getString(2));
                return kt;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public boolean update(String id, Size ten) {
        int check = 0;
        try {
            check = DBConnect.Update(update, ten.getTen(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
