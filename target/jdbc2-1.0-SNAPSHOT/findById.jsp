<%@ page import="com.csi.domain.Dept" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<%--<%=request.getAttribute("dept")%>--%>
<form action="<%=application.getContextPath()%>/dept?op=update&deptno=${dept.deptno}" method="post">
<%--    部门编号：<input type="text" name="deptno" placeholder="<%=dept.getDeptno()%>"><br>--%>
    部门名称：<input type="text" name="dname" placeholder="${dept.dname}"><br>
    部门地点： <input type="text" name="loc" placeholder="${dept.loc}"><br>
    <input type="submit" value="修改部门信息">
</form>

</body>
</html>
