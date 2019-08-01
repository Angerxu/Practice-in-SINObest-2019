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
     * delete方法调用jdbc执行sql语句的delete，可根据输入删除特定书本名称所在的记录。
     * @param option 删除选项，书本名称或ISBN
     * @param name 需要删除的书本的名称
     */
    public void delete(String option,String name);
    /**
     * update 根据书本的名称或ISBN，更新书本的价格
     * @param option 更新选项，书本名称或ISBN
     * @param name 需要更新的书本名称或ISBN
     * @param price 需要更新数据的书本价格
     */
    public void update(String option, String name, Float price);

    /**
     * getBook 根据书本的ISBN或书名，返回一个书本的对象
     * @param option 选择书本名称或ISBN进行查询
     * @param name 需要查询的书本的书名或ISBN
     * @return 返回根据条件查询的书本对象
     */
    public Book findBook(String option, String name);

}
