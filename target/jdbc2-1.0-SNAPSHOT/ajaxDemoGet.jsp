<%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/25
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var xhr;
        window.onload=function (ev) {
            document.getElementById("btn").onclick=function (ev1) {
                var info = document.getElementById("info").value;
                if (window.XMLHttpRequest){
                    xhr = new XMLHttpRequest();
                }else {
                    xhr=new ActiveXObject("Mirosoft.XMLHTTP");
                }
                xhr.onreadystatechange=callback;
                xhr.open("get","<%=application.getContextPath()%>/ajax?info="+info,true);
                xhr.send(null);

            }
        }
        function callback() {
            if (xhr.readyState==4){
                if (xhr.status==200){
                    var s = xhr.responseText;
                    document.getElementById("myDiv").innerHTML=s;
                }
            }

        }
    </script>
</head>
<body>
    <input type="text" name="info" id="info">
    <button id="btn">提交</button>
    <div id="myDiv">。。。。。。</div>

</body>
</html>
