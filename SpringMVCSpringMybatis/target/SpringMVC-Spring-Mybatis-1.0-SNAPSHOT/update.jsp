<%--
  Created by IntelliJ IDEA.
  User: 陈峰
  Date: 2018/11/7
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>

        var flag1=true;
        var flag2=true;


        function checkname(){
            var name = document.getElementById("name").value;
            var nameMsg = document.getElementById("nameMsg");
            if(name.length==0){
                nameMsg.innerText="必须输入用户名";
                flag1=false;
            }else if(name.length<2){
                nameMsg.innerText="必须输入大于1个字符的名字";
                flag1=false;
            }else{
                nameMsg.innerText="";
                flag1=true;
            }
            check();
        }

        function checkprice(){
            var price = document.getElementById("price").value;
            var priceMsg = document.getElementById("priceMsg");
            var reg = /^(\d+).(\d+)$/;

            if(price.length==0){
                priceMsg.innerText="编号不能为空";
                flag2=false;
            }else if(!reg.test(price)){
                priceMsg.innerText="必须输入数字(主键唯一)";
                flag2=false;
            }else{
                priceMsg.innerText="";
                flag2=true;
            }
            check();
        }

        function check(){
            var submit = document.getElementById("submit");


            console.log( "f2"+flag1 );
            console.log( "f3"+flag2);

            if(flag1==true && flag2==true){
                submit.disabled=false;
            }else{
                submit.disabled=true;
            }
        }

    </script>
</head>
<body>
<div id="update">
    <form action="/update" method="post">
        <table  align="center" width="50%">
            <tbody>
            <tr>
                <td colspan="2" align="center">
                    商品信息
                </td>
            </tr>
            <tr>
                <td align="right">编号</td>
                <td><input type="text"  name="id" value="${s.id}" readonly></td>
            </tr>
            <tr>
                <td width="25%" align="right">商品信息</td>
                <td width="40%">
                    <input type="text" name="name" value="${s.name}" id="name" onblur="checkname()">
                    <span id="nameMsg" style="color: red"></span>
                </td>

            </tr>

            <tr>
                <td align="right">价格</td>
                <td>
                    <input type="text" name="price" value="${s.price}" id="price" onblur="checkprice()">
                    <span id="priceMsg" style="color: red"></span>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="修改"  disabled="true" id="submit">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
