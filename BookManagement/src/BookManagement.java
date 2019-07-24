import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookManagement {
    public static void main(String[] args) {
        getConn();
    }
    static class Book {
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

}
