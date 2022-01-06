<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 11/9/21
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Khai báo sử dụng thẻ tags của Spring MVC -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Thêm mới sách</title>
    <!--Sử dụng bootstrap-->
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link href="<c:url value="/resources/js/bootstrap.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>">
    </script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>">
    </script>
    <style type="text/css">
        .error
        {
            color:red;
        }

        .errorblock{
            border: 1px solid red;
            background-color: #fad4ca;
            color: black;
            font-size: 16px;
            padding: 5px;
        }
    </style>
</head>
<body>
<c:url value="/admin/themMoiSach" var="urlThemMoi"/>
<c:url value="/admin/qlsach" var="urlDanhSach"/>
 <div style="width:100%; text-align: center;">
     <h2>Thêm mới thông tin sách</h2>
 </div>
<s:form action="${urlThemMoi}" method="post" modelAttribute="sach" enctype="multipart/form-data">
    <fieldset class="container-fluid">
        <legend>Nhập thông tin sách</legend>
        <div class="row">
            <s:label path="maSach" cssClass="col-md-2">Mã sách:</s:label>
            <div class="col-md-10">
                <s:input path="maSach" cssClass="form-control"/>
                <s:errors path="maSach" cssClass="error"/>
            </div>
        </div>
        <br>
        <div class="row">
            <s:label path="tenSach" class="col-md-2">Tên sách:</s:label>
            <div class="col-md-10">
                <s:input cssClass="form-control" path="tenSach"/>
                <s:errors path="tenSach" cssClass="error"/>
            </div>
        </div>
        <br>
        <div class="row">
            <s:label path="moTa" class="col-md-2">Mô tả:</s:label>
            <div class="col-md-10">
                <s:textarea cssClass="form-control" path="moTa" rows="5"/>
            </div>
        </div>
        <div class="row">
            <label class="col-md-2">Ảnh sách:</label>
            <div class="col-md-4">
                <input type="file" name="fUpload"/>
            </div>
        </div>
        <br>
        <div class="row">
            <s:label cssClass="col-md-2" path="giaSach">Giá sách:</s:label>
            <div class="col-md-4">
                <s:input cssClass="form-control" path="giaSach"/>
            </div>
        </div>
        <br>
        <br>
        <div class="row">
            <s:label cssClass="col-md-2" path="tacGia">Tác giả:</s:label>
            <div class="col-md-4">
                <s:input path="tacGia" cssClass="form-control"/>
                <s:errors path="tacGia" cssClass="error"/>
            </div>
        </div>
        <br>
        <div class="row">
            <s:label cssClass="col-md-2" path="maChuDe">Chủ đề:</s:label>
            <div class="col-md-4">
               <s:select path="maChuDe" cssClass="form-control">
                   <s:option value="">---Chọn chủ đề---</s:option>
                   <s:options items="${lstChuDe}"/>
               </s:select>
                <s:errors path="maChuDe" cssClass="error"/>
            </div>
        </div>
        <div class="row">
            <label class="col-md-2">&nbsp;</label>
            <div class="col-md-10">
                <input type="submit" name="btnThemMoi" class="btn btn-primary" value="Thêm mới"/>
                &nbsp;
                <a href="${urlDanhSach}" class="btn btn-danger">Trở lại</a>
            </div>

        </div>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-10">
                <s:errors path="*" cssClass="alert alert-danger" element="div"/>
            </div>
        </div>
        <br>
        <br>
    </fieldset>

</s:form>
</body>
</html>
