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
dao包中的BookManagementDao接口，定义了图书管理的jdbc函数接口。dao包下impl包的BookManageDaoImpl类实现了接口，实现函数的主要功能包括：记录一个书本的编号，书名，ISBN，价格等信息、删除，修改某个书本的记录、查看书本的记录。    
<br>1.查询记录  
定义为`get(String s)`函数，传入的字符串作为MySQL执行select语句的选项。当输入为`*`时返回数据库中所有列。  
<br>通过PrepareStatement的`executeQuery()`方法，返回得到ResultSet类型。  
  ```java
conn = JdbcUtils.getConnection();
String sql = "select " + s + " from books";
pstmt = (PreparedStatement)conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

  ```
再通过`ResultSet的getMetaData().getColumnCount()`方法得到列的总数。rs.next()方法逐列读取每个列中的值。  
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
定义`insert(Book book)`函数，传入的Book类作为MySQL插入记录，使用PreparedStatement的setString方法设置insert语句的参数。  
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
<br>3.删除记录  
定义`delete(String option, String name)`函数，传入的两个字符串，option代表选择通过查询书本的名字或者ISBN进行删除，name则代表具体书本的名字或者ISBN。执行sql的delete语句完成删除操作。  
  ```java
try {
     conn = JdbcUtils.getConnection();
     String sql = "delete from books where " 
        + option + "='" + name + "'";
     pstmt = (PreparedStatement) conn.prepareStatement(sql);
     i = pstmt.executeUpdate();
     System.out.println(i + " record has delete.\n");
} catch (SQLException e) {
     e.printStackTrace();
} finally {
     JdbcUtils.free(rs, pstmt, conn);
}
  ```
<br>4.更新书本价格  
定义`update(String option, String name,String price)`函数，传入三个参数：option代表选择通过查询书本的名字或者ISBN进行删除，name则代表具体书本的名字或者ISBN。price代表修改书本的价格。执行sql的update语句完成删除操作。  
  ```java
try {
     conn = JdbcUtils.getConnection();
     String sql = "pdate books set price='"
               + price + "' where "
               + option + "='" + name + "'";
     pstmt = (PreparedStatement) conn.prepareStatement(sql);
     i = pstmt.executeUpdate();
     System.out.println(i + " record has delete.\n");
} catch (SQLException e) {
     e.printStackTrace();
} finally {
     JdbcUtils.free(rs, pstmt, conn);
}
  ```

**<br>4.service包，主要负责业务模块的逻辑应用设计。**  
创建DBService类，定义BookMangementDao接口。再在配置文件daoconfig.properties中定义该接口的实现类，即`com.bookmanagement.dao.impl.BookManageDaoImpl`类，定义如下：  
  ```
bookDaoClass = com.bookmanagement.dao.impl.BookManageDaoImpl
  ```
接下来就可以在service层调用接口进行业务逻辑应用的处理。封装Service层的业务逻辑有利于业务逻辑的独立性和重复利用性。  
<br>在测试主函数中实例化service实现类即可调用数据库操作函数，实现从service层向dao层的调用。  
DBservice的实例化，加载实现类驱动：  
  ```java
private DBService() {
    try {
        Properties prop = new Properties();
        InputStream inStream = DBService.class.getClassLoader().
                getResourceAsStream("daoconfig.properties");
        prop.load(inStream);
        String bookDaoClass = prop.getProperty("bookDaoClass");
        Class clazz = Class.forName(bookDaoClass);
        bookManagementDao = (BookManagementDao) clazz.newInstance();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
    }
}
  ```
<br>二、测试函数  
dao包下的BookManagementTest.java代码为项目的测试入口，实例化service对象进行dao操作。  
  ```java
BookManagementDao serviceDao = DBService.getInstance().getBookManagementDao();
  ```
<br>项目启动有文字交互及选项菜单：  
  ```java
System.out.println("Welcome to Book Management System!");
System.out.println("==================================");
System.out.println("1.Enter \"Get\" to get information from database.");
System.out.println("2.Enter \"Insert\" to insert a new book.");
System.out.println("3.Enter \"Delete\" to delete a book.");
System.out.println("4.Enter \"Update\" to delete a book.");
System.out.println("Enter \"q\" or \"quit\" or \"exit\" to leave.");
  ```
<br>接收输入循环判断体，输入对应字段可以执行相关的CRUD指令或者退出，输入错误提示输入有误并重新输入。  