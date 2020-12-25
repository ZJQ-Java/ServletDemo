<%--
  Created by IntelliJ IDEA.
  User: zhangjinqiu03
  Date: 2020/10/21
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Object onlineCount = config.getServletContext().getAttribute("onlineCount");
%>
<h1>在线人数:</h1><%=onlineCount%>
</body>
</html>
