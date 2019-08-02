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
    private String price;



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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * toString，返回书本的基本信息组合形式的字符串。
     * @return String，一定组合格式的书本信息的字符串
     */
    @Override
    public String toString() {
        String out;
        return out = "Book ID: " + this.getId()
                + "\nName: " + this.getName()
                + "\nISBN: " + this.getISBN()
                + "\nPrice: " + this.getPrice();
    }
}
