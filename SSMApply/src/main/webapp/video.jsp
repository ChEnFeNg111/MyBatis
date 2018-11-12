<%--
  Created by IntelliJ IDEA.
  User: 陈峰
  Date: 2018/11/11
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <video src="video/tomcatcluster.mp4" controls width="500"></video>
    <input type="text" name="content" id="c"/>
    <input type="button" value="提交评论" onclick="sendRequest()"/>
    <hr>
    <div style="width:100%; height: 100px; border: 1px solid black;" id="div1"> </div>
</body>

<script>
    /*function sendRequest(){
        /!**
         *    ajax  页面无刷新技术，在页面不刷新的情况下与服务器进行交互
         *
         *         同步提交请求：open("请求方式", "url", 异步or同步)
                            false ==> 同步请求 , send()会一直等待到响应返回后，send才会结束
         *
         *!/
        var content = document.getElementById("c").value;

        //1) 创建 XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        //2) 设置请求并发送请求
        xhr.open("get","/comment?content="+content,false);
        xhr.send();


        //3)处理返回的 JSON数据，将 JSON数据 转化为 js对象
        var obj = JSON.parse(xhr.responseText);
        document.getElementById("div1").innerText = obj.content;

    }*/

    function sendRequest(){
        /**
         * 异步提交请求：
         *      open("请求方式", "url", 异步or同步)
                     true ==> 异步请求, send() 不会等待响应返回，请求发送后立刻结束
         */
        var content = document.getElementById("c").value;

        //1) 创建 XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        //2) 即时处理返回的响应
        xhr.onload = function () {
            // 将 JSON数据 转化为 js对象
            var obj = JSON.parse(xhr.responseText);

            document.getElementById("div1").innerText=obj.content;
        }

        //3) 设置请求并发送请求
        xhr.open("get","/comment?content="+content,true);
        xhr.send();
    }
</script>
</html>
