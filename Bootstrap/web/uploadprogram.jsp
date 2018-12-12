<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Dashboard with Off-canvas Sidebar</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="css/styles.css" rel="stylesheet">
    <style>
        .input-file{
            display: inline;
        }
    </style>
</head>
<body>


<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">用户中心</a>
        </div>
    </div>
</nav>


<div class="container-fluid">

    <div class="row row-offcanvas row-offcanvas-left">

        <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">

            <ul class="nav nav-sidebar">
                <li><a href="#">方案上传</a></li>
                <li><a href="#">购买记录</a></li>
                <li><a href="#">上传记录</a></li>
                <li><a href="#">修改密码</a></li>
            </ul>
        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">

            <div align="center">
                <form class="form-horizontal">
                    <fieldset>
                        <div id="legend" >
                            <legend >方案信息</legend>
                        </div>
                        <div class="control-group">
                            <!-- Text input-->

                            <div class="controls">
                                <label class="control-label" >方案名称</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" placeholder="请输入方案的名字" class="input-xlarge">
                                <p class="help-block"></p>
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->

                            <div class="controls">
                                <label class="control-label" >方案作者</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" placeholder="请输入作者的名字" class="input-xlarge">
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label class="control-label">上传图片</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input style="display: inline" id="fileInput" type="file">
                            <p class="help-block"></p>

                        </div>

                        <div class="control-group">

                            <!-- Select Basic -->

                            <div class="controls">
                                <label class="control-label">行业类型</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;
                                <select class="input-xlarge">
                                    <option>IT</option>
                                    <option>Teacher</option>
                                </select>
                                &nbsp;&nbsp;
                                <select class="input-xlarge">
                                    <option>Java</option>
                                    <option>English</option>
                                    <option></option>
                                </select>
                            </div>
                            <p class="help-block"></p>

                        </div>


                        <div class="control-group">


                            <div class="controls" style="display: inline">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;
                                <label class="control-label">方案类型</label>
                                <!-- Inline Radios -->
                                <label class="radio inline" style="display: inline">
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" value="重要保持客户" name="">重要保持客户
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" value="重要价值客户" name="">重要价值客户

                                    <p class="help-block"></p>

                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" value="重要发展客户" name="">重要发展客户
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" value="重要挽留客户" name="">重要挽留客户
                                    </div>
                                    <p class="help-block"></p>

                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;
                                        <input type="radio" value="一般维持客户" name="">
                                        一般维持客户
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="radio" value="有价值推广客户" name="">
                                        有价值推广客户
                                    </div>
                                    <p class="help-block"></p>

                                    <div>
                                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                                        <input type="radio" value="潜力客户" name="">
                                        潜力客户
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;
                                        <input type="radio" value="流失客户" name="">
                                        &nbsp;&nbsp;&nbsp;流失客户
                                    </div>

                                </label>
                            </div>
                        </div>

                        <br>
                        <br>

                        <div class="control-group">

                            <!-- Text input-->

                            <div class="controls">
                                <label class="control-label" >方案售价</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="text" placeholder="请输入理想价格" class="input-xlarge">
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <br>
                        <br>

                        <div class="control-group">
                            <!-- File Upload -->
                            <div class="controls">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;
                                <label class="control-label">上传附件</label>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input style="display: inline" type="file">
                            </div>
                        </div>
                        <br>
                        <br>

                        <div class="control-group">

                            <!-- Textarea -->
                            <label class="control-label">方案描述</label>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                            <div class="controls">
                                <div style="display: inline">
                                    <textarea  style="width: 300px;height: 300px;left: 1000px"> </textarea>
                                </div>
                            </div>
                        </div>


                        <br>
                        <br>
                        <br>
                        <br>

                        <div class="control-group">
                            <!-- Button -->
                            <div class="controls">
                                <button type="submit" class="btn btn-success" >上传方案</button>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-success" onclick="window.location.href='index.jsp' ">返回主界面</button>
                            </div>
                        </div>
                    </fieldset>
                </form>

            </div>

        </div>
    </div>
</div>

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>