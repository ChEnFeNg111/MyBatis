<%--
  Created by IntelliJ IDEA.
  User: 陈峰
  Date: 2018/11/12
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>文件描述：</td>
                <td>
                    <input type="text" name="description" >
                </td>
            </tr>
            <tr>
                <td>请选择文件：</td>
                <td>
                    <input type="file" name="file">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="上传文件">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
