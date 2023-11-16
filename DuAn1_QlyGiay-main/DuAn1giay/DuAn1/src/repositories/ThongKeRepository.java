package repositories;

import repositories.*;
import java.util.ArrayList;
import java.util.List;
import viewmodels.ThongKeView;
import java.sql.*;
import utilities.DBConnect;

public class ThongKeRepository {

    public List<ThongKeView> getList(int nam) {
        List<ThongKeView> listTK = new ArrayList<>();
        String sql = "SELECT MONTH(NgayTao),SUM(TongTien) AS 'TongTien' FROM HoaDon WHERE YEAR(NgayTao) LIKE ? GROUP BY MONTH(NgayTao),TongTien";
        try {
            ResultSet rs = DBConnect.Query(sql, nam);
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setThang(rs.getString(1));
                tk.setDoanhThu(rs.getDouble(2));
                listTK.add(tk);
            }
            rs.getStatement().getConnection().close();
            return listTK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
