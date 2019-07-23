import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookManagement {
    public static void main(String[] args) {

    }
    static class Book {
        private String Id;
        private String Name;
        private String ISBN;
        private String Price;

        Book(String Name, String ISBN, String Price) {
            this.Id = null;
            this.Name = Name;
            this.ISBN = ISBN;
            this.Price = Price;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public String getPrice() {
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }
    }

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/samp_db";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }



}
