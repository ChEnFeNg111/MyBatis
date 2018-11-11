<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/11
  Time: 11:48
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
    <div style="width:100%; height: 100px; border: 1px solid black;" id="div1">

    </div>

    <script>
        /*
        *  同步提交请求
        * */

     /*   function sendRequest() {
            // 1) 创建 XMLHttpRequest
            var xhr = new XMLHttpRequest();

            // 2) 发送请求
            var content = document.getElementById("c").value;
            xhr.open("get","/pinglun?content="+content,false);
            xhr.send();

            // 3) 接收响应信息(JSON对象)
            var text = xhr.responseText;

            // 4) 将 JSON对象转换为js对象
            var obj = JSON.parse(text);
            document.getElementById("div1").innerText = obj.content;
        }
*/
        /*
       *  异步提交请求
       * */
        function sendRequest() {
            // 1) 创建 XMLHttpRequest
            var xhr = new XMLHttpRequest();
            
            // 2) 即时处理响应
            xhr.onload=function () {
                // 将返回的 JSON对象转化为js对象
                var obj = JSON.parse(xhr.responseText);
                document.getElementById("div1").innerText = obj.content;
            }

            // 3)  发送请求
            var content = document.getElementById("c").value;
            xhr.open("get","/pinglun?content="+content,true);
            xhr.send();
        }
        
    </script>
</body>
</html>
