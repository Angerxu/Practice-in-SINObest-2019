package com.bookmanagement.dao;

import com.bookmanagement.domain.Book;

/**
 * interface BookManagementDao
 * <p>
 *     图书管理jdbc操作接口，定义CRUD操作。
 * </p>
 * @author XuAn
 * @date 2019/7/30
 */
public interface BookManagementDao {

    public void get(String s);
    public void insert(Book book);

}
