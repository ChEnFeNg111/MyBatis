<%--
  Created by IntelliJ IDEA.
  User: 陈峰
  Date: 2018/11/12
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    省：<select id="sheng" onchange="findShi()"></select>
    市：<select id="shi" onchange="findXian()"></select>
    县：<select id="xian"></select>
</body>

<script>

    function findXian() {
        // 获得市的id
        var shiId = document.getElementById("shi").value;

        // 创建 XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 处理即时响应
        xhr.onload = function () {
            // 获得 市 的标签
            var xian  = document.getElementById("xian");
            // 获得响应数据，并将其格式由 JSON --> js对象
            var list = JSON.parse(xhr.responseText);

            // 先将原来的市的下拉列表清空
            xian.innerText="";

            // 填充下拉列表
            for (var i = 0; i < list.length; i++) {
                var option = document.createElement("option");
                option.value = list[i].region_id;
                option.innerText = list[i].region_name;

                // 添加父子关系
                xian.appendChild(option);
            }
        }

        // 发送请求
        xhr.open("get","/city?parent_id="+shiId,true);
        xhr.send();

    }


    function findShi() {
        // 获得省的id
        var shengId = document.getElementById("sheng").value;

        // 创建 XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 处理即时响应
        xhr.onload = function () {
            // 获得 市 的标签
            var shi  = document.getElementById("shi");
            // 获得响应数据，并将其格式由 JSON --> js对象
            var list = JSON.parse(xhr.responseText);

            // 先将原来的市的下拉列表清空
            shi.innerText="";

            // 填充下拉列表
            for (var i = 0; i < list.length; i++) {
                var option = document.createElement("option");
                option.value = list[i].region_id;
                option.innerText = list[i].region_name;

                // 添加父子关系
                shi.appendChild(option);
            }
            findXian();
        }

        // 发送请求
        xhr.open("get","/city?parent_id="+shengId,true);
        xhr.send();

    }

    function findSheng() {

        // 创建 XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 处理即时响应函数
        xhr.onload=function () {
            // 接收返回的响应数据（JSON）,把 JSON数据转化为 js对象
            var list = JSON.parse(xhr.responseText);
            // 获得 id=sheng 的标签
            var sheng = document.getElementById("sheng");
            for (var i = 0; i < list.length; i++) {

                var option = document.createElement("option");
                option.value = list[i].region_id;
                option.innerText=list[i].region_name;

                // 添加父子关系
                sheng.appendChild(option);
            }
            findShi();
        }

        // 发送请求
        xhr.open("get","/city?parent_id=1",true);
        xhr.send();
    }

    findSheng();
</script>
</html>
