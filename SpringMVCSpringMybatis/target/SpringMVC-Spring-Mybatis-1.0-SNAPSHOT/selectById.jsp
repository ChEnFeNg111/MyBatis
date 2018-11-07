<%--
  Created by IntelliJ IDEA.
  User: 陈峰
  Date: 2018/11/7
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/selectById1" method="post">
        <table>
            <tbody>
                <tr>
                    <td>输入想要查询的学号(从1开始)</td>
                    <td><input type="text" name="id"></td>
                    <td><input type="submit" value="查询"></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
