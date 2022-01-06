<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- Khai báo thư viện sử dụng tiles để thiết kế giao diện-->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><tiles:insertAttribute name="title"/></title>
    <meta name="keywords" content="Book Store Template, Stanford - Day lap trinh"/>
    <meta name="description" content="Book Store Template, Stanford - Day lap trinh"/>
    <link href="<c:url value="/resources/css/templatemo_style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<!-- Templates from www.stanford.com.vn -->
<div id="templatemo_container">
    <tiles:insertAttribute name="menu"/>
    <!-- end of menu -->
    <tiles:insertAttribute name="header"/>
    <!-- end of header -->
    <div id="templatemo_content">
        <div id="templatemo_content_left">
            <tiles:insertAttribute name="sidebar"/>
        </div> <!-- end of content left -->
        <div id="templatemo_content_right">
            <tiles:insertAttribute name="body"/>
            <a href="subpage.html"><img src="${pageContext.request.contextPath}/resources/images/templatemo_ads.jpg" alt="ads"/></a>
        </div> <!-- end of content right -->
        <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    <tiles:insertAttribute name="footer"/>
    <!-- end of footer -->
</div> <!-- end of container -->
<div align=center>This template downloaded form <a href='http://www.stanford.com.vn'>Stanford.com.vn</a></div>
</body>
</html>