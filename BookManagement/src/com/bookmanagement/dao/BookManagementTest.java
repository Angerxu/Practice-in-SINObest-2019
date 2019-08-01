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
        BookManagementTest.service();
    }


    private static void welcome() {
        System.out.println("\nWelcome to Book Management System!");
        System.out.println("==================================");
        System.out.println("1.Enter \"Get\" to get information from database.");
        System.out.println("2.Enter \"Insert\" to insert a new book.");
        System.out.println("3.Enter \"Delete\" to delete a book.");
        System.out.println("4.Enter \"Update\" to delete a book.");
        System.out.println("5.Enter \"Find\" to find a book and return a class entity.");
        System.out.println("Enter \"q\" or \"quit\" or \"exit\" to leave.");

    }

    private static void service() throws IOException {

        BookManagementDao serviceDao = DBService.getInstance().getBookManagementDao();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        欢迎界面
         */
        BookManagementTest.welcome();
        String mainOption = br.readLine();
        /*
        输入检测
         */

        String q = "q";
        String exit = "exit";
        String quit = "quit";
        while (!(q.equals(mainOption)
                || (exit.equals(mainOption))
                || (quit.equals(mainOption)))) {

            switch (mainOption) {
                case "insert":
                    // 插入一条记录
                    System.out.println("Enter the name of the book to insert.");
                    String name = br.readLine();
                    System.out.println("Enter the isbn of the book to insert.");
                    String isbn = br.readLine();
                    System.out.println("Enter the price of the book to insert.");
                    Float price = Float.parseFloat(br.readLine());
                    Book book = new Book();
                    book.setName(name);
                    book.setISBN(isbn);
                    book.setPrice(price);
                    serviceDao.insert(book);
                    break;
                case "get":
                    // 返回记录
                    System.out.println("Enter the part to search, enter \'*\' to search all.");
                    String s = br.readLine();
                    serviceDao.get(s);
                    break;
                case "delete":
                    // 删除
                    System.out.println("Choose the name/isbn of the book to delete.");
                    System.out.println("You may delete by name or isbn.");
                    String option = br.readLine();
                    System.out.println("Enter the name/isbn of the book to delete.");
                    name = br.readLine();
                    serviceDao.delete(option, name);
                    break;
                case "update":
                    // 更新
                    System.out.println("Choose the name/isbn of the book to update.");
                    System.out.println("You may update by name or isbn.");
                    option = br.readLine();
                    System.out.println("Enter the name/isbn of the book to update.");
                    name = br.readLine();
                    System.out.println("Enter the price of the book to update.");
                    price = Float.parseFloat(br.readLine());
                    serviceDao.update(option, name, price);
                    break;
                case "find":
                    // 返回一个查询的Book对象
                    System.out.println("Choose the name/isbn of the book to find.");
                    System.out.println("You may update by name or isbn.");
                    option = br.readLine();
                    System.out.println("Enter the name/isbn of the book to find.");
                    name = br.readLine();
                    book = serviceDao.findBook(option, name);
                    System.out.println(book.getId() + book.getISBN() + book.getName());
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;

            }
            BookManagementTest.welcome();
            mainOption = br.readLine();
        }

    }

}







