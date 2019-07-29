import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * class BookManagement
 *
 * <p>
 *     基于JDBC与MySQL连接实现的基本CRUD图书管理项目
 * </p>
 * @author XuAn
 * @date 2019/7/22
 */
public class BookManagement {
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
                Book book = new Book(name, isbn, price);
                insert(book);
                break;
            } else if (mainOption.toLowerCase().equals("get")) {
                // 返回记录
                System.out.println("Enter the part to search, enter \'*\' to search all.");
                String s = br.readLine();
                get(s);
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



    private static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/samp_db?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "";
        Connection conn = null;
        try {
            /* classLoader,加载对应驱动 */
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static void get(String s) {
        Connection conn = getConn();
        String sql = "select " + s + " from books";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            if (s.equals("*")) {
                // 通配匹配
                System.out.println("ID  Name    ISBN     Price");
            } else {
                System.out.println(s);
            }

            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 4)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error!\n");
        }
    }

    private static void insert(Book book) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into books (name,isbn,price) values(?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getISBN());
            pstmt.setString(3, book.getPrice());
            i = pstmt.executeUpdate();
            System.out.println(i + " record has insert.\n");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}




class Book {
    private String id;
    private String name;
    private String isbn;
    private String price;

    Book(String name, String isbn, String price) {
        this.id = null;
        this.name = name;
        this.isbn = isbn;
        this.price = price;
    }

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

}


