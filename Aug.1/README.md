# 8月1日实习日志  
*2019年8月1日 星期四*  
## 学习内容  
1.Git commit message  
配置commitizen & cz-conventional-changelog。  
  ```
npm install -g commitizen cz-conventional-changelog
  ```
`commitizen`是一个撰写合格`commit message`的工具，用于代替`git commit`指令，而`cz-conventional-changelog`适配器提供`conventional-changelog`标准（约定式提交标准）。基于不同需求，也可以使用不同适配器。  
安装完毕后，可直接使用git cz来取代git commit。  

## 编写代码  
**1.Dao层增加了新的接口和功能：**  
findBook(String option, String name)  
  ```
参数：
String option：选择根据书名或者ISBN查找书本
String name：输入需要查找的书本/ISBN

功能：
根据选择书名/ISBN查询书本，返回一个对应查询结果的Book实例对象。
  ```
**2.修改了几处函数细节**   
1.BookManagementTest中的欢迎界面和判断输入及业务操作单独封装为两个函数welcome()、service()，提高代码的可阅读性与简洁性。  
<br>2.判断输入由if-else体更改switch判断体。  
<br>3.在Dao层执行MySQL语句时抛出异常时提示输入错误。  
  ```java
catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error! Please check your input.");
}
  ```
<br>3.添加initialize.sql脚本，测试项目时在配置了mysql 8.0的环境下控制台输入以下命令进行数据库与建表初始化操作：  
  ```SQL
mysql -u root -p < ~/initialize.sql
  ```
(~代表SQL脚本所在目录)  
