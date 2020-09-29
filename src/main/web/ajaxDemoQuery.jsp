<%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/25
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-2.0.3.js"></script>
    <script>
        $(function () {
            $("#myForm").submit(function () {
                $.ajax({
                    url:$("#myForm").attr("action"),
                    type:"post",
                    data:{
                      "account":$("#account").val(),
                      "password":$("#password").val()
                    },
                    success:function (data) {
                        alert("接收服务器返回结果是："+data);
                    },
                    error:function (e) {
                        alert("连接ajax请求失败"+e)
                    }
                });
                return false;
            });
        })
    </script>
</head>
<body>
<form id="myForm" action="<%=application.getContextPath()%>/query" method="post">
    <input type="text" name="account" id="account" placeholder="请输入账号"><br>
    <input type="password" name="password" id="password" placeholder="请输入密码"><br>
    <input type="submit" value="登录">
</form>

</body>
</html>
