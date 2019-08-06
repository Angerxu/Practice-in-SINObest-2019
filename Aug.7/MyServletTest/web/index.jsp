<%--
  Created by IntelliJ IDEA.
  User: xuan
  Date: 2019/8/7
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
  <head>
    <title>My JSP 'index.jsp'</title>
  </head>
  <body>
    <h1 style="align-content: normal;color: blueviolet;font-size: 24px">MyServletTest</h1>
    <hr>
    <!--<a href="/servlet/MyServlet1"> 第一个'/'表示服务器的根目录。-->
    <a href="servlet/MyServlet1" style="font-size: 30px">doGet method</a>
    <!--绝对路径访问时，使用path变量：path变量表示当前项目的根目录-->
    <form action= "<%=path%>/servlet/MyServlet2" method="post">
        <br/><input type="submit" value="Post method"
                    style="height: 40px;width: 200px;font-size: 30px">
    </form>
    <br/><a href="test.jsp" style="font-size: 30px">go to test.jsp</a>
  </body>
</html>
