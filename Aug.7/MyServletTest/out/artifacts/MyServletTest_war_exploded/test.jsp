<%--
  Created by IntelliJ IDEA.
  User: xuan
  Date: 2019/8/7
  Time: 15:58
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
    <title>test.jsp</title>
  </head>
  <body>
    <h1>Test.jsp</h1>
    <hr>
    <a href="index.jsp" style="color: #F0F0F0;font-family: Consolas;font-size: 36px">
        go back to "index.jsp"
    </a>
  </body>
</html>
