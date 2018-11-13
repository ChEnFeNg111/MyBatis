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

    <script langugae="javascript">
        var timer;
        var btn = document.getElementById('btn');
        btn.onclick = function() { addBarrage();}
        document.onkeydown = function(evt) {var event = evt || window.event;if (event.keyCode == 13) {addBarrage();}}
        var colors = ['#2C3E50', '#FF0000', '#1E87F0', '#7AC84B', '#FF7F00', '#9B39F4', '#FF69B4'];//弹幕颜色库
        function addBarrage() {
            clearInterval(timer);
            var text = document.getElementById('text').value;
            document.getElementById('text').value = "";
            var index = parseInt(Math.random() * colors.length); //随机弹幕颜色
            var screenW = window.innerWidth;
            var screenH = dm.offsetHeight;
            var max = Math.floor(screenH / 40);
            var height = 10 + 40 * (parseInt(Math.random() * (max + 1)) - 1);
            var span = document.createElement('span');
            span.style.left = screenW + 'px';
            span.style.top = height + 'px';
            span.style.color = colors[index];
            span.innerHTML = text;
            var dmDom = document.getElementById('dm');
            dmDom.appendChild(span);
            timer = setInterval(move, 10);
        }
        function move() {
            var arr=[];
            var oSpan=document.getElementsByTagName('span');
            for(var i=0;i<oSpan.length;i++){
                arr.push(oSpan[i].offsetLeft);
                arr[i] -= 2;
                oSpan[i].style.left = arr[i]+'px';
                if(arr[i]<-oSpan[i].offsetWidth){
                    var dmDom=document.getElementById('dm');
                    dmDom.removeChild(dmDom.childNodes[0]);
                }
            }
        }
    </script>
</head>
<body>

            <video src="vedio/tomcatcluster.mp4" controls width="500" id="v">

            </video>

        <hr>
        <input type="text" name="barrage" id="barrage">
        <input type="button"  value="发送弹幕" onclick="sendRequest()">
        <div style="width:100%; height: 100px; border: 1px solid black;" id="div1"> </div>
</body>

</html>
