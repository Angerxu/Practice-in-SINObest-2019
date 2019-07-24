#  基于JDBC的图书管理项目  
使用Java 数据库连接，（Java Database Connectivity，简称JDBC）实现的一个基础的CRUD（增删查改）的图书管理项目。  
项目环境：MySQL 8.0.17、IntelliJ IDEA、JDBC。
1.数据类型  
Book类，一个基础的类型单位：  
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
public String getId() {
    return Id;
}

public void setId(String Id) {
    this.Id = Id;
}
  ```  
<br>2.Connection方法  
java.sql下定义的一个接口，与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。定义如下：  
  ```java
public interface Connectionextends Wrapper
  ```    
MySQL8.0以上版本的数据库连接中：  
1、与MySQL不需要建立SSL连接的，需要显示为关闭。  
2、后面还要设置CST（时区）。  
url修改后设置为
  ```java
String url = "jdbc:mysql://localhost::3306/samp_db?
useSSL=false&serverTimezone=UTC"
  ```  

