package vn.com.stanford.je0821.springmvcbasic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataProvider {
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/JE082101DEV?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    /**
     * Hàm kết nối đến db cần làm việc
     * @return
     */
    public static Connection ketNoi()
    {
        Connection conn = null;

        try {
            //Nạp driver
            Class.forName(JDBC_DRIVER);

            //Kết nối đến db trong mysql cần làm việc
            conn = DriverManager.getConnection(DATABASE_LINK, "root", "Stanford2012");

        } catch (ClassNotFoundException ex) {
            System.err.println("Lỗi không tìm thấy driver. Chi tiết: " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Không kết nối được với Database trên MySQL. Chi tiết: " + ex.getMessage());
        }

        return conn;

    }
}
