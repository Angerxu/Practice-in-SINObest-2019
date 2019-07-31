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
    /**
     * get方法调用jdbc执行sql语句的select，根据输入的参数s返回对应列表中的列
     * @param s select的选项参数
     */
    public void get(String s);

    /**
     * 插入一个book对象到数据库记录中
     * @param book 一个book对象
     * */
    public void insert(Book book);

    /**
     * delete方法调用jdbc执行sql语句的delete，可根据输入删除特定书本名称所在的记录
     * @param option 删除选项，书本名称或ISBN
     * @param name 需要删除的书本的名称
     */
    public void delete(String option,String name);
    /**
     * update
     * @param option 更新选项，书本名称或ISBN
     * @param name 需要更行的书本名称或ISBN
     * @param price 需要更新数据的书本价格
     */
    public void update(String option, String name, String price);

    /**
     *
     */
}
