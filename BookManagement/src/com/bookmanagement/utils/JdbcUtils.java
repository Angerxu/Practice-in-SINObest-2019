package com.bookmanagement.utils;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class JdbcUtils
 * <p>
 *     jdbc连接工具类，获得数据库的Connection。
 * </p>
 * @author XuAn
 * @date 2019/7/30
 */
public class JdbcUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/samp_db?useSSL=false&serverTimezone=Asia/Shanghai";
    private static String username = "root";
    private static String password = "";
    Connection conn = null;

    private JdbcUtils() {

    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, username, password);
    };

    public static void free(ResultSet rs, PreparedStatement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
