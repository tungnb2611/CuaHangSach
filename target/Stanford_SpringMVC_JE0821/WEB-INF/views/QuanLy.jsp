<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 11/25/21
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý thông tin</title>
</head>
<body>
<h1>Trang quản lý hệ thống</h1>
<h2>Xin chào, ${pageContext.request.userPrincipal.name} !</h2>
<form action="<c:url value="/dangXuat1" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" /> <br/>
    <input type="submit" value="Đăng xuất" />
</form>
</body>
</html>
