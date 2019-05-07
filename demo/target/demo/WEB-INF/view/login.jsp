<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <script src="http://cdn.jsdelivr.net/sockjs/1.0.1/sockjs.min.js"></script>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!--<script type="text/javascript" src="js/jquery-1.7.2.js"></script>-->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>webSocket测试</title>
    <script type="text/javascript">
      var chater;
      if (window.WebSocket) {
            console.log("您的浏览器支持多个websocket通信的实例");
            }
          else {
            console.log("您的浏览器不支持多个websocket通信的实例,建议使用火狐浏览器或者谷歌浏览器");
            }

      $(function(){

        var websocket;
        function connectServer() {
          var clientName = $("#client_name").val();
          if ("WebSocket" in window) {
            websocket = new WebSocket("ws://127.0.0.1:8080/websocket/socketServer");
            websocket.onerror = console.log;
          } else if ("MozWebSocket" in window) {
            alert("MozWebSocket");
            websocket = new WebSocket("ws://127.0.0.1:8080/websocket/socketServer");
          } else {
            alert("SockJS");
            websocket = new SockJS("http://127.0.0.1:8080/sockjs/echo");
          }
        }

//             websocket.onopen = function (evnt) {
//                 $("#tou").html("链接服务器成功!")
//             };
//             websocket.onmessage = function (evnt) {
//                 $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
//             };
//             websocket.onerror = function (evnt) {
//             };
//             websocket.onclose = function (evnt) {
//                 $("#tou").html("与服务器断开了链接!")
//             }

        $("#conncet_server").bind("click", function() {
          connectServer();

          websocket.onopen = function (evnt) {
            $("#tou").html("链接服务器成功!")
          };
          websocket.onmessage = function (evnt) {
            $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
          };
          websocket.onerror = function (evnt) {
          };
          websocket.onclose = function (evnt) {
            $("#tou").html("与服务器断开了链接!")
          }
        });

        $("#send").bind("click", function() {
          send();
        });

        function send(){
          if (websocket != null) {
            var message = document.getElementById("message").value;

            if ($.trim(chater) != "") {
              message = chater + "|" + message;
            }

            websocket.send(message);
          } else {
            alert("未与服务器链接.");
          }
        }
      });

      function changeChater(e) {
        chater = $(e).html();
        alert("您将和" + chater + "进行聊天...");
      }
    </script>

</head>
<body>

<div class="page-header" id="tou">webSocket及时聊天Demo程序</div>
<div class="well" id="msg"></div>
<div class="col-lg">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="请输入用户名..." id="client_name">
        <span class="input-group-btn">
                <button class="btn btn-default" type="button" id="conncet_server">连接服务器</button>
            </span>
    </div>
</div>

<br/>

<div class="col-lg">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="发送信息..." id="message">
        <span class="input-group-btn">
                <button class="btn btn-default" type="button" id="send">发送</button>
            </span>
    </div>
</div>
</body>

</html>
