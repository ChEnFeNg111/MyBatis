
<!-- 需求分析
用户点击发送按钮 把input的内容展示到box里面
1.元素 .con .send-btn .box span（创建）
2.事件：点击事件 键盘事件
3.行为
1.点击.send-btn获取.con的内容
    (1)规范发送信息
    (2)禁止空及全空格
    (3)存储value值
2.根据内容动态生成span标签
    (1)创建节点document.createElement
    (2)改变节点内容innerHTML
    (3)节点 生成初始化位置等
    (4)标签添加到oBox appendChild
3.message运动
    (1)改变元素的left值
    (2)定时器改变 setInterval
    (3)this代表当前弹幕
    (4)弹幕left = 当前left-1
4.随机函数
Math.random 0-1 包括0但不包括1
    (1)top
    (2)color
    (3)fontsize
    (4)textShadow
    (5)timing运动曲线
        linear
        ease-out
5.业务完善
    (1)过去的删除掉
         停止计时器
         删除自身
         终止函数
    (2)完善回车输入
        在oCon上回车 发送弹幕
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Js原生弹幕</title>
    <link rel="stylesheet" href="">
    <style type="text/css" media="screen">
        * {
            margin: 0px;
            padding: 0px
        }

        html, body {
            height: 100%
        }

        body {
            overflow: hidden;
            background-color: #FFF;
            text-align: center;
        }

        .flex-column {
            display: flex;
            flex-direction: column;
            justify-content: space-between;, align-items: center;
        }

        .flex-row {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
        }

        .wrap {
            overflow: hidden;
            width: 70%;
            height: 600px;
            margin: 100px auto;
            padding: 20px;
            background-color: transparent;
            box-shadow: 0 0 9px #222;
            border-radius: 20px;
        }

        .wrap .box {
            position: relative;
            width: 100%;
            height: 90%;
            background-color: #000000;
            border-radius: 10px
        }

        .wrap .box span {
            position: absolute;
            top: 10px;
            left: 20px;
            display: block;
            padding: 10px;
            color: #336688
        }

        .wrap .send {
            display: flex;
            width: 100%;
            height: 10%;
            background-color: #000000;
            border-radius: 8px
        }

        .wrap .send input {
            width: 40%;
            height: 60%;
            border: 0;
            outline: 0;
            border-radius: 5px 0px 0px 5px;
            box-shadow: 0px 0px 5px #d9d9d9;
            text-indent: 1em
        }

        .wrap .send .send-btn {
            width: 100px;
            height: 60%;
            background-color: #fe943b;
            color: #FFF;
            text-align: center;
            border-radius: 0px 5px 5px 0px;
            line-height: 30px;
            cursor: pointer;
        }

        .wrap .send .send-btn :hover {
            background-color: #4cacdc
        }

        .send-btn1{
            width: 100px;
            height: 60%;
            background-color: #fe943b;
            color: #FFF;
            text-align: center;
            border-radius: 0px 5px 5px 0px;
            line-height: 30px;
            cursor: pointer;
        }

        .send-btn1:hover{
            background-color: #4cacdc
        }

    </style>
</head>
<body>
    <div class="wrap flex-column">
        <div class="box">
            <video src="vedio/tomcatcluster.mp4" width="100%" height="100%" controls  autoplay></video>
        </div>
        <div class="send flex-row">
            <div class="send-btn1">开启弹幕</div>
            <input type="text" class="con" placeholder="弹幕发送[]~(^v^)~*">
            <div class="send-btn">发送</div>
        </div>
    </div>

<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script>



    //1.获取元素
    var oBox = document.querySelector('.box');   //获取.box元素
    var oCon = document.querySelector('.con');   //获取input框
    var oBtn = document.querySelector('.send-btn');   //获取发送按钮
    var oBtn1 = document.querySelector('.send-btn1');   //获取开启弹幕按钮

    var cW = oBox.offsetWidth;   //获取box的宽度
    var cH = oBox.offsetHeight;   //获取box的高度

    oBtn.onclick = send;   //点击发送
    oBtn1.onclick = sendRequest; // 开启弹幕

    oCon.onkeydown = function (e) {
        e = e || window.event;
        if (e.keyCode === 13) {
            //回车键
            send();
        }
    };



    function send() {


        //获取oCon的内容
        if (oCon.value.length <= 0 || (/^\s+$/).test(oCon.value)) {
            alert('请输入弹幕');
            return false;
        }

        sendRequest();

    }

    function sendRequest() {

        // 创建 XMLHttpRequest
        var xhr = new XMLHttpRequest();

        xhr.onload = function () {

            var list = JSON.parse(xhr.responseText);

            for (var i = 0; i < list.length; i++) {
                var message = list[i].text;

                console.log("返回的："+message);
                //生成标签
                createEle(message);   //执行节点创建模块
                oCon.value = '';   //收尾工作清空输入框
            }
        }

        xhr.open("get","/barrage?text="+oCon.value,true);
        xhr.send();
    }
    function createEle(txt) {
        //动态生成span标签
        var oMessage = document.createElement('span');   //创建标签
        oMessage.innerHTML = txt;   //接收参数txt并且生成替换内容
        oMessage.style.left = cW + 'px';  //初始化生成位置x
        oBox.appendChild(oMessage);   //把标签塞到oBox里面
        roll.call(oMessage, {
            //call改变函数内部this的指向
            timing: ['linear', 'ease-out'][~~(Math.random() * 2)],
            color: '#' + (~~(Math.random() * (1 << 24))).toString(16),
            top: random(0, cH),
            fontSize: random(16, 32)
        });
    }
    function roll(opt) {
        //弹幕滚动
        //如果对象中不存在timing 初始化
        opt.timing = opt.timing || 'linear';
        opt.color = opt.color || '#fff';
        opt.top = opt.top || 0;
        opt.fontSize = opt.fontSize || 16;
        this._left = parseInt(this.offsetLeft);   //获取当前left的值
        this.style.color = opt.color;   //初始化颜色
        this.style.top = opt.top + 'px';
        this.style.fontSize = opt.fontSize + 'px';
        this.timer = setInterval(function () {
            if (this._left <= 100) {
                clearInterval(this.timer);   //终止定时器
                this.parentNode.removeChild(this);
                return;   //终止函数
            }
            switch (opt.timing) {
                case 'linear':   //如果匀速
                    this._left += -2;
                    break;
                case 'ease-out':   //
                    this._left += (0 - this._left) * .01;
                    break;
            }
            this.style.left = this._left + 'px';
        }.bind(this), 1000 / 60);
    }
    function random(start, end) {
        //随机数封装
        return start + ~~(Math.random() * (end - start));
    }
    var aLi = document.querySelectorAll('li');   //10

    function forEach(ele, cb) {
        for (var i = 0, len = aLi.length; i < len; i++) {
            cb && cb(ele[i], i);
        }
    }
    forEach(aLi, function (ele, i) {
        ele.style.left = i * 100 + 'px';
    });

    //产生闭包
    var obj = {
        num: 1,
        add: function () {
            this.num++;   //obj.num = 2;
            (function () {
                console.log(this.num);
            })
        }
    };
    obj.add();  //window
</script>
</body>
</html>
