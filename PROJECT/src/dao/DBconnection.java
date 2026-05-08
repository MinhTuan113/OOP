package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    public static Connection getConnection() {
        try
        {
            String url = "jdbc:mysql://localhost:3306/btl";
            String user = "root";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null)
        {
            System.out.println("Kết nối thành công!");
        }
    }
}