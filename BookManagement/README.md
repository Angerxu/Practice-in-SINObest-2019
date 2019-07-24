#  基于JDBC的图书管理项目  
使用Java 数据库连接，（Java Database Connectivity，简称JDBC）实现的一个基础的CRUD（增删查改）的图书管理项目。  
项目环境：MySQL 5.0、IntelliJ IDEA、JDBC。
1. 数据类型  
Book类，一个基础的类型单位：  
数据部分：
  ```  
1.ID-编号  
2.Name-书名  
3.ISBN-国际标准书号  
4.Price-价格  
  ``` 
方法部分：  
  ```

  ```
2. Connection方法  
java.sql下定义的一个接口，与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。定义如下：  
  ```java
public interface Connectionextends Wrapper
  ```    
3.  