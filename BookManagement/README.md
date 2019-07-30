#  基于JDBC的图书管理项目  
使用Java 数据库连接，（Java Database Connectivity，简称JDBC）实现的一个基础的CRUD（增删查改）的图书管理项目。  
项目环境：MySQL 8.0.17、IntelliJ IDEA、JDBC。  
<br>一.项目结构
根据MVC(Model-View-Controller)模式，对项目进行分层。包结构定义如下：  
|--com.bookmanagement  
|----|--dao  
|----|----|--impl  
|----|--domain  
|----|--service  
|----|--utils  

**1.domain包，定义Book类，一个基础的类型单位：**  
数据部分：  
  ```  
1.ID-编号  
2.Name-书名  
3.ISBN-国际标准书号  
4.Price-价格  
  ```  
数据类型都定义为`String`类型，便于统一的修改和数据库的导入与导出。  
<br>方法部分：  
  ```
Book类的方法，主要功能为得到Book类的私有数据和修改数据。  
每个数据都有一个对应的get()方法得到该数据的值，及一个set()方法修改该数据的值。  
  ```  
以书本的ID为例，对应的方法如下：  
  ```java
public String getid() {
    return id;
}

public void setid(String id) {
    this.id = id;
}
  ```  
**<br>2.utils包，存放与数据库建立连接工具类。**  
封装JdbcUtils类，封装建立数据库连接的函数和释放、关闭连接的函数。  
<br>getConnection方法，返回一个与数据库的连接。  
java.sql下定义的一个接口，与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。定义如下：  
  ```java
public interface Connection extends Wrapper
  ```    
MySQL8.0以上版本的数据库连接中：  
1、与MySQL不需要建立SSL连接的，需要显示为关闭。  
2、后面还要设置CST（时区）。  
url修改后设置为
  ```java
String url = "jdbc:mysql://localhost::3306/samp_db?
useSSL=false&serverTimezone=UTC"
  ```  
<br>free方法，释放连接，传入参数为ResultSet rs, PreparedStatement st, Connection conn。  
为每次数据库操作建立的ResultSet, PreparedStatement, Connection关闭连接，释放资源。  
**<br>3.dao包(数据访问对象，存放底层数据库的相关数据的操作接口与函数)**  
使用JDBC对一个Book类的基本信息进行记录，存储在MySQL数据库中。每个jdbc操作声明对应的Connection, PreparedStatement, ResultSet。  
  ```java
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
  ```  
<br>当需要进行一个jdbc操作时，需要先调用JdbcUtils的getConnection()方法建立连接。执行完sql语句后再调用JdbcUtils的free方法释放相应连接。    
dao包中的BookManagementDao接口，定义了图书管理的jdbc函数接口。dao包下impl包的BookManageDaoImpl类实现了接口，实现函数如下：  
<br>1.查询记录  
定义为get(String s)函数，传入的字符串作为MySQL执行select语句的选项。当输入为`*`时返回数据库中所有列。  
<br>通过PrepareStatement的executeQuery()方法，返回得到ResultSet类型。  
  ```java
conn = JdbcUtils.getConnection();
pstmt = (PreparedStatement)conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
  ```
再通过ResultSet的getMetaData().getColumnCount()方法得到列的总数。rs.next()方法逐列读取每个列中的值。  
  ```java
while (rs.next()) {
    for (int i = 1; i <= col; i++) {
        System.out.print(rs.getString(i) + "\t");
        if ((i == 2) && (rs.getString(i).length() 
                        < 4)) {
        System.out.print("\t");
        }
    }
    System.out.println("");
}
  ```
<br>2.插入记录  
定义get(Book book)函数，传入的Book类作为MySQL插入记录，使用PreparedStatement的setString方法设置insert语句的参数。  
  ```java
conn = JdbcUtils.getConnection();
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
  ```  

方法的主要功能包括：记录一个书本的编号，书名，ISBN，价格等信息、删除，修改某个书本的记录、查看书本的记录。  
**<br>4.service**  
