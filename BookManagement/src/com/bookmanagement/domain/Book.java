package com.bookmanagement.domain;

/**
 * class Book
 * <p>
 *     Book类，基本操作主类
 * </p>
 * @author XuAn
 * @date 2019/7/22
 */
public class Book {
    private String id;
    private String name;
    private String isbn;
    private Float price;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
