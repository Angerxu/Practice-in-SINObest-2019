<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'readStudInf.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my readstudInf JSP page. <br>
     <a href = "HTML/Welcome.html">go to home page</a><br>
    <%
   			Connection con = null;
	 		Statement stm = null;
     	try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/studinf","root","");
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM studInf");
			while(rs.next()){
				out.print("---------------------------------<br>");
				out.print("|  " + rs.getString("studName") + "  |");
				out.print("  " + rs.getString("studID") + "  |");
				out.print("  " + rs.getString("schoolName") + "| <br>");
			}
			
		}catch(Exception e){
			System.out.println("ERROR_READ : " + e.getMessage());
		}
      %>
  </body>
</html>
