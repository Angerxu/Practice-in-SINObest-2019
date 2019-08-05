<%--
  Created by IntelliJ IDEA.
  User: xuan
  Date: 2019/8/5
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<html>
<head><title>Hello World</title></head>
<body>
Hello World!<br/>
<%
    out.println("Your IP address is " + request.getRemoteAddr());
%>
</body>
</html>