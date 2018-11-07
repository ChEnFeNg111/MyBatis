<%--
  Created by IntelliJ IDEA.
  User: 陈峰
  Date: 2018/11/7
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table  border="1" align="center">
    <tbody>
    <tr>
        <td colspan="2" align="center">
            商品信息
        </td>
    </tr>
    <tr>
        <td>学号</td>
        <td><input type="text"  name="sid" value="${s.id}" readonly></td>
    </tr>
    <tr>
        <td>商品名字</td>
        <td><input type="text" name="name" value="${s.name}" readonly></td>
    </tr>
    <tr>
        <td>价格</td>
        <td><input type="text" name="price" value="${s.price}" readonly></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <a href="select">主页面</a>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
