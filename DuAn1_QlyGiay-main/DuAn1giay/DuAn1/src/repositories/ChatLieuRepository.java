package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ChatLieu;
import utilities.DBConnect;

public class ChatLieuRepository {

    private final String select_All = "SELECT * FROM ChatLieu";
    private final String insert = "INSERT INTO ChatLieu(Ten) VALUES (?)";
    private final String select_By_Name = "SELECT * FROM ChatLieu WHERE Ten = ?";
    private final String delete = "DELETE FROM ChatLieu WHERE Id = ?";
    private final String update = "UPDATE ChatLieu SET Ten = ? WHERE Id = ? ";

    public List<ChatLieu> getList() {
        List<ChatLieu> listCL = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.Query(select_All);
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                 cl.setId(rs.getInt(1));
                cl.setTen(rs.getString(2));
                listCL.add(cl);
            }
            rs.getStatement().getConnection().close();
            return listCL;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(ChatLieu cl) {
        int check = 0;
        try {
            check = DBConnect.Update(insert, cl.getTen());
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

    public ChatLieu getChatLieuByTen(String ten) {
        try {
            ResultSet rs = DBConnect.Query(select_By_Name, ten);
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                    cl.setId(rs.getInt(1));
                cl.setTen(rs.getString(2));
                return cl;
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    public boolean update(String id, ChatLieu ten) {
        int check = 0;
        try {
            check = DBConnect.Update(update, ten.getTen(), id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return check > 0;
    }
}
