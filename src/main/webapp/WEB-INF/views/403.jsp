<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 11/25/21
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Thông báo lỗi</title>
</head>
<body>
<h1>403</h1>
<span>Hi: ${pageContext.request.userPrincipal.name} bạn không có quyền truy xuất trang này</span>
<a href="<c:url value="/dang-nhap1" />">Trang Đăng nhập</a>
<br/><br/>
<form action="<c:url value="/j_spring_security_logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Logout" />
</form>
</body>
</html>
