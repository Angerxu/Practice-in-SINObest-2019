package com.bookmanagement.dao.impl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookmanagement.dao.BookManagementDao;
import com.bookmanagement.domain.Book;
import com.bookmanagement.utils.JdbcUtils;

/**
 * class BookManageDaoImpl
 * <p>
 *     图书管理jdbc接口实现类。
 * </p>
 * @author XuAn
 * @date 2019/7/30
 */
public class BookManageDaoImpl implements BookManagementDao {

    @Override
    public void get(String s) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select " + s + " from books";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            if (s.equals("*")) {
                // 通配匹配
                System.out.println("ID  Name    ISBN     Price");
            } else {
                System.out.println(s);
            }

            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 4)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, pstmt, conn);
        }
    }
    @Override
    public void insert(Book book) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int i = 0;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into books (name,isbn,price) values(?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getISBN());
            pstmt.setString(3, book.getPrice());
            i = pstmt.executeUpdate();
            System.out.println(i + " record has insert.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, pstmt, conn);
        }

    }
}
