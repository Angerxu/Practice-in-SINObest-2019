package com.bookmanagement.service;
import com.bookmanagement.dao.BookManagementDao;

import java.io.InputStream;
import java.util.Properties;

public class DBService {
    private static BookManagementDao bookManagementDao = null;
    private static DBService instance = new DBService();

    private DBService() {
        try {
            Properties prop = new Properties();
            InputStream inStream = DBService.class.getClassLoader().
                    getResourceAsStream("daoconfig.properties");
            prop.load(inStream);
            String bookDaoClass = prop.getProperty("bookDaoClass");
            Class clazz = Class.forName(bookDaoClass);
            bookManagementDao = (BookManagementDao) clazz.newInstance();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DBService getInstance() {
        return instance;
    }

    public BookManagementDao getBookManagementDao() {
        return bookManagementDao;
    }
}
