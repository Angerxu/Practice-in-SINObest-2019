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
ID定义为`int unsigned not null auto_increment`，自增量便于管理。Name、ISBN数据类型都定义为`String`类型，Price定义为`Float`类型。  
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
<br>重写`toString`方法，返回书本详细信息的组合形式的字符串。  
  ```java
public String toString() {
    String out;
    return out = "Book ID: " + this.getId()
                + "\nName: " + this.getName()
                + "\nISBN: " + this.getISBN()
                + "\nPrice: " + this.getPrice();
}
  ```
**<br>2.utils包，存放与数据库建立连接工具类。**  
封装`JdbcUtils`类，封装建立数据库连接的函数和释放、关闭连接的函数。  
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
<br>free方法，释放连接，传入参数为`ResultSet rs`, `PreparedStatement st`, `Connection conn`。  
为每次数据库操作建立的`ResultSet`, `PreparedStatement`, `Connection`关闭连接，释放资源。  
**<br>3.dao包(数据访问对象，存放底层数据库的相关数据的操作接口与函数)**  
使用JDBC对一个Book类的基本信息进行记录，存储在MySQL数据库中。每个jdbc操作声明对应的Connection, PreparedStatement, ResultSet。  
  ```java
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
  ```  
<br>当需要进行一个jdbc操作时，需要先调用JdbcUtils的getConnection()方法建立连接。执行完sql语句后再调用JdbcUtils的`free`方法释放相应连接。    
<br>dao包中的`BookManagementDao`接口，定义了图书管理的jdbc函数接口。dao包下impl包的`BookManageDaoImpl`类实现了接口，实现函数的主要功能包括：记录一个书本的编号，书名，ISBN，价格等信息、删除，修改某个书本的记录、查看书本的记录，返回一个书本的实例化对象，模拟挑选书本加入购物车并返回总价格。    
<br>1.查询记录  
定义为`get(String s)`函数，传入的字符串作为MySQL执行select语句的选项。当输入为`*`时返回数据库中所有列。  
<br>通过PrepareStatement的`executeQuery()`方法，返回得到ResultSet类型。  
  ```java
conn = JdbcUtils.getConnection();
String sql = "select " + s + " from books";
pstmt = (PreparedStatement)conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();

  ```
再通过`ResultSet的getMetaData().getColumnCount()`方法得到列的总数。`rs.next()`方法逐列读取每个列中的值。  
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
定义`insert(Book book)`函数，传入的Book类作为MySQL插入记录，使用PreparedStatement的`setString`方法设置insert语句的参数。  
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
    System.out.println("Error! Please check your input.");
}
  ```  
<br>3.删除记录  
定义`delete(String option, String name)`函数，传入的两个字符串，option代表选择通过查询书本的名字或者ISBN进行删除，name则代表具体书本的名字或者ISBN。执行sql的`delete`语句完成删除操作。  
  ```java
try {
    conn = JdbcUtils.getConnection();
    String sql = "delete from books where " 
        + option + "='" + name + "'";
    pstmt = (PreparedStatement)conn.prepareStatement(sql);
    i = pstmt.executeUpdate();
    System.out.println(i + " record has delete.\n");
} catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error! Please check your input.");
} finally {
     JdbcUtils.free(rs, pstmt, conn);
}
  ```
<br>4.更新书本价格  
定义`update(String option, String name,String price)`函数，传入三个参数：option代表选择通过查询书本的名字或者ISBN进行删除，name则代表具体书本的名字或者ISBN。price代表修改书本的价格。执行sql的`update`语句完成删除操作。  
  ```java
try {
    conn = JdbcUtils.getConnection();
    String sql = "pdate books set price='"
               + price + "' where "
               + option + "='" + name + "'";
    pstmt = (PreparedStatement)conn.prepareStatement(sql);
    i = pstmt.executeUpdate();
    System.out.println(i + " record has delete.\n");
} catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error! Please check your input.");
} finally {
    JdbcUtils.free(rs, pstmt, conn);
}
  ```
<br>5.查询记录并返回一个Book的实例化对象  
根据输入的书名或ISBN，查询记录并返回一个Book类实例。  
  ```java
try {
    conn = JdbcUtils.getConnection();
    String sql = "select id, name, isbn, price from books where " + option +"=?";
    pstmt = (PreparedStatement) conn.prepareStatement(sql);
    pstmt.setString(1, name);
    rs = pstmt.executeQuery();
    while (rs.next()) {
        book = mappingBook(rs);
    }
} catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error! Please check your input.");
} finally {
    JdbcUtils.free(rs, pstmt, conn);
}
  ```
<br>6.挑选书本，显示总价
根据输入条件的书名/ISBN，通过`findBook`方法返回的`book`实例，得到查询书本的价格，通过`parseFloat`方法转换浮点数累加的到总价。挑选结束后通过`select`配合`where`的查询条件一并显示书本的所有信息，以及总价格。  
  ```java
Book book = findBook(option, name);
totalPrice += Float.parseFloat(book.getPrice());
/* 拼接where语句*/
whereSQL = whereSQL.concat(option +"='"+ name 
            + "' or ");
  ```
挑选结束后，使用字符串的`subString`方法去除结尾的`or`。  
  ```java
whereSQL = whereSQL.substring(0, whereSQL.length() - 4);
  ```
之后再执行sql语句并输出ResultSet及总价。  
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
<br>项目启动有文字交互及选项菜单，封装在`BookManagement.welcome()`函数内：  
  ```java
System.out.println("Welcome to Book Management System!");
System.out.println("==================================");
System.out.println("1.Enter \"Get\" to get information from database.");
System.out.println("2.Enter \"Insert\" to insert a new book.");
System.out.println("3.Enter \"Delete\" to delete a book.");
System.out.println("4.Enter \"Update\" to delete a book.");
System.out.println("5.Enter \"Find\" to find a book and return a class entity.");
System.out.println("6.Enter \"Select\" to select some book and show total price.");
System.out.println("Enter \"q\" or \"quit\" or \"exit\" to leave.");
  ```
<br>`BookManagement.service()` 接收循环输入switch-判断体，输入对应字段可以执行相关的CRUD指令或者退出，输入价格字段时，输入错误提示输入有误并重新输入，接收的错误类型有：    
  ```
1.多个小数点。
2.无效的小数点（以小数点结尾）
3.非数字字符（如字母、其他字符等）
  ```
封装在`checkInputValid(String price)`函数中。  

<br>三、测试脚本  
在项目根目录下的`initialize.sql`脚本,在进行项目测试前使用命令提示符切换路径到项目根目录下，执行以下语句：  
  ```SQL
mysql -u root -p < ~/initialize.sql
  ```
(~代表SQL脚本所在目录)  
若已经存在名为`samp_db`的数据库，则注释掉`initialize.sql`中的第一行`create database samp_db`命令。执行完脚本即完成了建表操作，再运行BookManagementTest的main函数即可进行项目测试。  