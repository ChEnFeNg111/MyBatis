<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/11
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{
            color: red;
        }

        .right{
            color: green;
        }

        img { cursor: pointer}
    </style>
</head>
<body>

  <form action="#" method="post" >
      <p>用户名: <input type="text" name="name" id="name" onblur="checkName()"> <span id="span"></span></p>
      <p>密码: <input type="password" name="password" id="password"></p>
      <p>验证码: <input type="text" name="code" id="code" onblur="checkCode()">
          <img src="/img" align="center"  >
          <span id="span2"></span>
      </p>
      <p><input type="submit" value="提交"></p>
  </form>

  <script>
      function checkName() {
           var name = document.getElementById("name").value;


           var xhr = new XMLHttpRequest();

           xhr.onload = function () {
               var span = document.getElementById("span");
               var obj = JSON.parse(xhr.responseText);
               if(obj.exits){
                    span.innerText = "用户名已被注册";
                    span.className = "error";
               }else {
                    span.innerText = "用户名可以使用";
                    span.className = "right";
               }
           }

           xhr.open("get","/register?name="+name,true);
           xhr.send();
      }

      function checkCode() {
          var code = document.getElementById("code").value;


          var xhr = new XMLHttpRequest();

          xhr.onload = function () {
              var span = document.getElementById("span2");
              var obj = JSON.parse(xhr.responseText);
              if(obj.check){
                  span.innerText = "验证码正确";
                  span.className = "right";
              }else {
                  span.innerText = "验证码错误";
                  span.className = "error";
              }
          }

          xhr.open("get","/checkcode?code="+code,true);
          xhr.send();
      }


  </script>
</body>
</html>
