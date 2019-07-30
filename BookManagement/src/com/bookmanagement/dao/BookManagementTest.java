package com.bookmanagement.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bookmanagement.domain.Book;

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

        System.out.println("Welcome to Book Management System!");
        System.out.println("==================================");
        System.out.println("1.Enter \"Insert\" to insert a new book.");
        System.out.println("2.Enter \"get\" to get information from database.");
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
                System.out.println("Enter the name, ISBN and price of the book to insert.");
                String name = br.readLine();
                String isbn = br.readLine();
                String price = br.readLine();
                Book book = new Book();
                book.setName(name);
                book.setISBN(isbn);
                book.setPrice(price);
                //test.insert(book);
                break;
            } else if (mainOption.toLowerCase().equals("get")) {
                // 返回记录
                System.out.println("Enter the part to search, enter \'*\' to search all.");
                String s = br.readLine();
                //get(s);
                break;
            } else {
                System.out.println("Invalid input, please try again.");
            }
            // 循环输入
            System.out.println("1.Enter \"Insert\" to insert a new book.");
            System.out.println("2.Enter \"get\" to get information from database.");
            System.out.println("Enter \"q\" or \"quit\" or \"exit\" to leave.");
            mainOption = br.readLine();

        }



        }




}







