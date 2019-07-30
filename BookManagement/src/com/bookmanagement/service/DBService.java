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

        }
    }
}
