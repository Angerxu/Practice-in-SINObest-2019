# 8月2日实习日志  
*2019年8月2日 星期五*  
## 编写代码  
1.domain层，Book类增加`toString`函数，返回书本基本信息组合形式的字符串。字段`price`由float类型更改为`String`类型，调整相关接口及类型转换。  
<br>2.initial.sql脚本文件，增加对各字段的说明注释；修改`price`列类型为char(10)。  
<br>3.`BookManagementTest`测试类中添加对价格输入合法性的检测。  
<br>4.Dao层增加接口selectBook()，具体实现为：根据书名/ISBN挑选书本，挑选结束后列出挑选书本的信息，并返回总价格。  
<br>5.修改细节。  