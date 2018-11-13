<%--
  Created by IntelliJ IDEA.
  User: 陈峰
  Date: 2018/11/13
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>
        function sendRequest() {

            // 创建 XMLHttpRequest
            var xhr = new XMLHttpRequest();

            // 调用即时处理响应
            xhr.onload = function () {

                //
                var map = JSON.parse(xhr.responseText);

                // 遍历集合
                for (var key in map){
                    var word = map[key];

                    var span = document.createElement('span');

                    var top = parseInt(Math.random() * 500) - 20;

                    var color1 = parseInt(Math.random() * 256);

                    var color2 = parseInt(Math.random() * 256);

                    var color3 = parseInt(Math.random() * 256);

                    var color = "rgb(" + color1 + "," + color2 + "," + color3 + ")";

                    top = top < 0 ? 0 : top;

                    span.style.position = 'absolute' ;


                    span.style.top = top + "px";

                    span.style.color = color;

                    span.style.left = '500px';

                    span.style.whiteSpace = 'nowrap';

                    var nub = (Math.random() * 10) + 1;

                    span.setAttribute('speed', nub);

                    span.speed = nub;

                    span.innerHTML = word;

                    document.getElementById("v").appendChild(span);

                    document.getElementById("barrage").value = "";
                }

            }

            var barrage = document.getElementById("barrage");
            //var video = document.getElementById("v");

            //获取发送的弹幕和时间
            var text = barrage.value;

            // 发送请求
            xhr.open("get","/barrage?text="+text,true);
            xhr.send();
        }

        setInterval(move, 200);

        function move() {

            var spanArray = document.getElementById("v").children;

            for (var i = 0; i < spanArray.length; i++) {

                    spanArray[i].style.left =

                        parseInt(spanArray[i].style.left) - spanArray[i].speed + 'px';

            }

        }




    </script>
</head>
<body>

            <video src="vedio/tomcatcluster.mp4" controls width="500" id="v">
                <span>11</span>
            </video>

        <hr>
        <input type="text" name="barrage" id="barrage">
        <input type="button"  value="发送弹幕" onclick="sendRequest()">
        <div style="width:100%; height: 100px; border: 1px solid black;" id="div1"> </div>
</body>

</html>
