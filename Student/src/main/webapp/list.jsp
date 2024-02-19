<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 19/02/2024
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="my-3">Quản Lý Học Sinh</h1>
    <div class="row d-flex mx-3">
        <div class="col-8">
            <a class="btn btn-warning" role="button" href="/student?action=create">Thêm mới</a>
        </div>
        <div class="col-4">
            <form class="d-flex" role="search" action="#" method="post">
                <input name="action" value="find" hidden="">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="country">
                <button class="btn btn-outline-secondary" type="submit">Tìm</button>
            </form>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Stt</th>
            <th scope="col">Tên Học Sinh</th>
            <th scope="col">Email</th>
            <th scope="col">Địa chỉ</th>


            <th scope="col">Chỉnh sửa</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="s" items="${student}" >
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.address}</td>

                <td>
                    <a class="btn btn-warning" href="#" role="button">Chỉnh
                        sửa</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="#" role="button">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
