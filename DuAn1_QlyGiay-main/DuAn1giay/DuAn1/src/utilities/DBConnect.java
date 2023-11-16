package utilities;

import java.sql.*;

public class DBConnect {

    static String user = "sa";
    static String pass = "123";
    static String myURL = "jdbc:sqlserver://localhost:1433;databaseName=DBDUAN1";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection c = DriverManager.getConnection(myURL, user, pass);
        PreparedStatement ps;
        ps = c.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);

        }
        return ps;
    }

    public static ResultSet Query(String sql, Object... args) throws SQLException {
        PreparedStatement ps = DBConnect.getStmt(sql, args);
        return ps.executeQuery();
    }

    public static int Update(String sql, Object... args) throws SQLException {
        try {
            PreparedStatement ps = DBConnect.getStmt(sql, args);
            try {
                return ps.executeUpdate();
            } finally {
                ps.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

















