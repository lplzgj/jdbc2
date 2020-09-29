
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加部门</title>
    <script src="<%=application.getContextPath()%>/js/jquery-2.0.3.js"></script>
    <script>
        $(function () {
            $("#deptno").blur(function () {
                $.ajax({
                    url:"<%=application.getContextPath()%>/dept?op=ajax",
                    type:"post",
                    data:{
                        "deptno":$("#deptno").val()
                    },
                    success:function (data) {
                        console.log(data);
                        if (data=="1"){
                            $("#message").text("对不起，编号重复").css("color","red");
                        }else {
                            $("#message").text("该编号可以").css("color","black");
                        }
                    },
                    error:function (e) {
                        alert("连接ajax请求失败"+e)
                    }
                });
            });
        })

    </script>
</head>
<body>

<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/dept?op=addDept" method="post">
    <input type="text" name="deptno"  id="deptno" placeholder="请输入部门编号"><span id="message"></span><br>
    <input type="text" name="dname" placeholder="请输入部门名称"><br>
    <input type="text" name="loc" placeholder="请输入部门地点"><br>
    <input type="submit" value="添加部门">
</form>
</body>
</html>
