<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/11
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <div>
       省 <select id="sheng" onchange="findSheng()"></select>
       市 <select id="shi" onchange="findShi()"></select>
       县 <select id="xian"></select>
   </div>

   <script>
       function findSheng(){
           // 获取选中的城市编号值
           var sheng_id = document.getElementById("sheng").value;

           var xhr = new XMLHttpRequest();
           xhr.onload = function () {
               // 获得 省 的下拉列表
                var list = JSON.parse(xhr.responseText)
                //清除下拉列表
                var option = 
           }

           xhr.open("get","/city?id="+sheng_id,true);
           xhr.send();

       }
   </script>
</body>
</html>
