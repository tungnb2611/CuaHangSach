<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 12/2/21
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo sử dụng thẻ tags của Spring MVC -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Sử dụng gọi API</title>
    <!--Sử dụng bootstrap-->
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="<c:url value="/resources/js/bootstrap.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>">
    </script>
    <script type="text/javascript">
        $(document).ready(function() {

            layDanhSachNguoiDung();
         });

        function layDanhSachNguoiDung()
        {
            //Lấy danh sách người dùng
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/Stanford_SpringMVC_JE0821_war_exploded/nguoidungs",
                dataType : "json",
                contentType: "application/json; charset=utf-8",
                async: true,
                traditional: true,
                success: function(result) {

                    var thongtin = "";

                    $.each(result, function(index, user)
                    {
                        thongtin += "<tr>";
                        thongtin += "<td>" + user.userId + "</td>";
                        thongtin += "<td>" + user.username + "</td>";
                        thongtin += "<td>" + user.hoTen + "</td>";
                        thongtin += "<td>" + user.dienThoai + "</td>";
                        thongtin += "<td>" + user.email + "</td>";
                        thongtin += "<td>" + user.diaChi + "</td>";
                        var sua = "suaThongTin('" + user.userId + "')";
                        var xoa = "xoaThongTin('" + user.userId + "')";
                        thongtin += "<td><a href='#' onclick=\"" + sua + "\" title='Sửa người dùng'>Sửa</a>&nbsp;";
                        thongtin += "<a href='#' title='Xóa người dùng' onclick=\"" + xoa + "\">Xóa</a></td>";
                        thongtin += "</tr>";
                    });

                    $("#dsNguoiDung").append(thongtin);
                }
            });
        };

        function suaThongTin(maNV) {

        };
        function xoaThongTin(ma) {
        };

    </script>
</head>
<body>
    <div style="text-align: center; width: 100%">
        <h2>Danh sách người dùng</h2>
    </div>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Tên đăng nhập</th>
        <th>Họ tên</th>
        <th>Điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
    </tr>
    </thead>
    <tbody id="dsNguoiDung">
    </tbody>
</table>
</body>
</html>
