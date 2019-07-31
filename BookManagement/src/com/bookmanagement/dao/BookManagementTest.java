package com.bookmanagement.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bookmanagement.domain.Book;
import com.bookmanagement.service.DBService;

/**
 * class BookManagement
 *
 * <p>
 *     基于JDBC与MySQL连接实现的基本CRUD图书管理项目
 * </p>
 * @author XuAn
 * @date 2019/7/22
 */
public class BookManagementTest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BookManagementDao serviceDao = DBService.getInstance().getBookManagementDao();

        System.out.println("Welcome to Book Management System!");
        System.out.println("==================================");
        System.out.println("1.Enter \"Get\" to get information from database.");
        System.out.println("2.Enter \"Insert\" to insert a new book.");
        System.out.println("3.Enter \"Delete\" to delete a book.");
        System.out.println("4.Enter \"Update\" to delete a book.");
        System.out.println("Enter \"q\" or \"quit\" or \"exit\" to leave.");
        String mainOption = br.readLine();
        /*
        退出检测
         */
        while (!mainOption.toLowerCase().equals("q")
                && !mainOption.toLowerCase().equals("quit")
                && !mainOption.toLowerCase().equals("exit")) {

            if (mainOption.toLowerCase().equals("insert")) {
                // 插入一条记录
                System.out.println("Enter the name of the book to insert.");
                String name = br.readLine();
                System.out.println("Enter the isbn of the book to insert.");
                String isbn = br.readLine();
                System.out.println("Enter the price of the book to insert.");
                String price = br.readLine();
                Book book = new Book();
                book.setName(name);
                book.setISBN(isbn);
                book.setPrice(price);
                serviceDao.insert(book);
            } else if (mainOption.toLowerCase().equals("get")) {
                // 返回记录
                System.out.println("Enter the part to search, enter \'*\' to search all.");
                String s = br.readLine();
                //get(s);
                serviceDao.get(s);
            } else if (mainOption.toLowerCase().equals("delete")) {

                System.out.println("Choose the name/isbn of the book to delete.");
                System.out.println("You may delete by name or isbn.");
                String option = br.readLine();
                System.out.println("Enter the name/isbn of the book to delete.");
                String name = br.readLine();
                serviceDao.delete(option, name);
            } else if (mainOption.toLowerCase().equals("update")) {
                System.out.println("Choose the name/isbn of the book to update.");
                System.out.println("You may update by name or isbn.");
                String option = br.readLine();
                System.out.println("Enter the name/isbn of the book to update.");
                String name = br.readLine();
                System.out.println("Enter the price of the book to update.");
                String price = br.readLine();
                serviceDao.update(option, name, price);
            } else {
                System.out.println("Invalid input, please try again.");
            }
            // 循环输入
            System.out.println("==================================");
            System.out.println("1.Enter \"Get\" to get information from database.");
            System.out.println("2.Enter \"Insert\" to insert a new book.");
            System.out.println("3.Enter \"Delete\" to delete a book.");
            System.out.println("4.Enter \"Update\" to delete a book.");
            System.out.println("Enter \"q\" or \"quit\" or \"exit\" to leave.");
            mainOption = br.readLine();

        }



        }




}







