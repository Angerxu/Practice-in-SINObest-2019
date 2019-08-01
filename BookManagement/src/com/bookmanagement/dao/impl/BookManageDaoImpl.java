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
                System.out.println("\nID  Name    ISBN            Price");
            } else {
                System.out.println("\n" + s);
            }

            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    boolean condition = ((i == 2) || (i == 3))
                            && (rs.getString(i).length() < 4);
                    if (condition) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error! Please check your input.");
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
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into books (name,isbn,price) values(?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getISBN());
            pstmt.setFloat(3, book.getPrice());
            i = pstmt.executeUpdate();
            System.out.println(i + " record has insert.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error! Please check your input.");
        } finally {
            JdbcUtils.free(rs, pstmt, conn);
        }
    }

    @Override
    public void delete(String option, String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int i = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from books where " + option + "=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, name);
            i = pstmt.executeUpdate();
            System.out.println(i + " record has delete.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error! Please check your input.");
        } finally {
            JdbcUtils.free(rs, pstmt, conn);
        }
    }

    @Override
    public void update(String option, String name, Float price) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int i = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update books set price=? where "
                    + option + "=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setFloat(1, price);
            pstmt.setString(2, name);
            i = pstmt.executeUpdate();
            System.out.println(i + " record has update.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error! Please check your input.");
        } finally {
            JdbcUtils.free(rs, pstmt, conn);
        }
    }

    @Override
    public Book findBook(String option, String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Book book = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select id, name, isbn, price from books where " + option +"=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                book = mappingBook(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error! Please check your input.");
        } finally {
            JdbcUtils.free(rs, pstmt, conn);
        }

        return book;
    }

    private Book mappingBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getString("id"));
        book.setName(rs.getString("name"));
        book.setISBN(rs.getString("isbn"));
        book.setPrice(rs.getFloat("price"));
        return book;
    }
}
