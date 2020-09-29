
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="<%=application.getContextPath()%>/addDept.jsp">添加部门</a>
    <a href="#">查询部门</a>
    <a href="<%=application.getContextPath()%>/dept?op=findAll">显示所有部门</a>
    <a href="<%=application.getContextPath()%>/emp?op=addFind">添加员工信息</a>
    <a href="<%=application.getContextPath()%>/emp?op=findAll">显示所有员工信息</a>
</div>
</body>
</html>
