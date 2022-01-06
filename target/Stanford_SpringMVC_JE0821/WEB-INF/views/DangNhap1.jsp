<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 11/25/21
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo sử dụng thẻ tags của Spring MVC -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Đăng nhập hệ thống</title>
</head>
<c:url value="/thucHienDangNhap1" var="urlDangNhap"/>
<body>
<s:form action="${urlDangNhap}" method="post" modelAttribute="user">
    <fieldset>
        <legend>Nhập thông tin đăng nhập</legend>
        <div>
            <div>
                <label>Tên đăng nhập:</label>
                <div>
                    <s:input path="username" />
                </div>
            </div>
            <br>
            <div>
                <label>Mật khẩu:</label>
                <div>
                    <s:password path="password" />
                </div>
            </div>
            <div>
                <label></label>
                <div>
                    <input type="submit" value="Đăng nhập">
                </div>
            </div>
            <div>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" /> <br/>
                <span style="color: red;">${message}</span>
            </div>
        </div>
    </fieldset>
</s:form>
</body>
</html>
