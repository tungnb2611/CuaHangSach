<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 11/19/21
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo sử dụng tags của struts -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Trang chi tiết</title>
</head>
<body>

<h1>${objSach.tenSach}</h1>
<p style="text-align: right; width: 100%;">
    Giá sách:
    <b style="color:red;">
        <fmt:formatNumber type="number" maxFractionDigits="1" value="${objSach.giaSach}" />
    </b>
    đồng
</p>
<p style="font-size:16px;">
    ${objSach.moTa}
</p>
<p style="text-align: right; width: 100%;">
    Tác giả: ${objSach.tacGia}
<p>
</body>
</html>
