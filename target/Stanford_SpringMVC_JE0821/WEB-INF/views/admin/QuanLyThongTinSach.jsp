<%--
  Created by IntelliJ IDEA.
  User: DangQuang
  Date: 11/23/21
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Quản lý thông tin sách</title>
</head>

<body>
<c:url value="/admin/sach-them" var="urlSachAdd"/>
<c:url value="/admin/sach-sua" var="urlSachEdit"/>
<c:url value="/admin/sach-xoa" var="urlSachDelete"/>
<c:url value="/admin/timKiemSach" var="urlTimKiemSach"/>
<div style="width: 100%; text-align: center;">
    <h2>Quản lý thông tin sách</h2>
</div>

<s:form action="${urlTimKiemSach}" method="post">
    <div class="container-fluid">
        <fieldset>
            <legend>Nhập thông tin tìm kiếm sách</legend>
            <div class="row">
                <label class="col-md-2">Từ khóa:</label>
                <div class="col-md-3">
                    <input type="text" name="tuKhoa" value="${tuKhoa}" class="form-control"/>
                </div>
                <label class="col-md-2">Chủ đề:</label>
                <div class="col-md-3">
                    <select name="maChuDe" class="form-control">
                        <option value="">---Chọn chủ đề---</option>
                        <c:forEach var="c" items="${lstChuDe1}">
                            <option ${c.maChuDe.equals(maChuDe) ? 'selected="selected"' : ''}
                                    value="${c.maChuDe}">${c.tenChuDe}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-2">
                    <input type="submit" name="btnTimKiem" value="Tìm kiếm" class="btn btn-primary"/>
                </div>
            </div>
        </fieldset>
    </div>
</s:form>
<div style="width: 100%; text-align: right">
    <a href="${urlSachAdd}">Thêm mới</a>
</div>
<table id="sampleTable" class="table table-striped table-bordered" border="1" style="border-collapse: collapse;">
    <thead>
    <tr>
        <th>Ảnh</th>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Mô tả</th>
        <th>Giá</th>
        <th>Tác giả</th>
        <th>Mã CĐ</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty lstSach}">
        <c:forEach var="s" items="${lstSach}">
            <tr>
                <td>
                    <img class="img-thumbnail" src="images/${s.anhSach}" width="100" height="100"/>
                </td>
                <td>${s.maSach}</td>
                <td>${s.tenSach}</td>
                <td>${s.moTa}</td>
                <td>${s.giaSach}</td>
                <td>${s.tacGia}</td>
                <td>${s.maChuDe}</td>
                <td>
                    <a href="${urlSachEdit}/${s.maSach}">Sửa</a>
                    &nbsp;
                    <a href="${urlSachDelete}/${s.maSach}" onclick="return confirm('Bạn có chắc chắn muốn xóa sách này không ?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
