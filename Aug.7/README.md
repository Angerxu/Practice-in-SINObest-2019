# 2019年8月7日实习日志  
## 学习内容  
1.Servlet的生命周期
  ```
init()，创建对象。
service()，相应客户端请求，实例化对象。
destroy()，销毁对象。
  ```
2.路径跳转  
response.sendRedirect()，重定向访问与request.getRequestDispatcher()。  
  ```
request.getRequestDispatcher()是请求转发，前后页面共享一个request;
response.sendRedirect()是重新定向，前后页面不是一个request。  

RequestDispatcher.forward()是在服务器端运行;
HttpServletResponse.sendRedirect()是通过向客户浏览器发送命令来完成. 
  ```
## 编写代码  
1.MyServletTest
  ```
Servlet生命周期
doGet, doPost方法
response.sendRedirect()，重定向访问与
request.getRequestDispatcher()请求转发。
  ```