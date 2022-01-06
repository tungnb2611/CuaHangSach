<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 11/19/21
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Trang chủ - BookStore</title>
</head>
<body>
<% int i = 0;%>
<c:if test="${not empty lstSach}">
    <c:forEach var="b" items="${lstSach}">
<div class="templatemo_product_box">
    <h1>${b.tenSach}<span>(by ${b.tacGia})</span></h1>
    <img width="100" height="150" src="images/${b.anhSach}" alt="image" />
    <div class="product_info">
        <p>${b.moTa}</p>
        <h3>${b.giaSach}</h3>
        <div class="buy_now_button"><a href="subpage.html">Mua ngay</a></div>
        <div class="detail_button"><a href="chiTiet/${b.maSach}">Chi tiết</a></div>
    </div>
    <div class="cleaner">&nbsp;</div>
</div>
 <% if(i%2 == 0){ %>
        <div class="cleaner_with_width">&nbsp;</div>
        <%} else { %>
      <div class="cleaner_with_height">&nbsp;</div>
<% }
i++;%>
</c:forEach>
</c:if>
</body>
</html>
