<%@ page import="java.util.List" %>
<%@ page import="com.csi.domain.Dept" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有部门</title>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse: collapse;
        }
        table ,th,td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>地点</th>
        <th>操作</th>
    </tr>
    <c:forEach var="d" items="${all}">
        <tr>
            <td>${d.deptno}</td>
            <td>${d.dname}</td>
            <td>${d.loc}</td>
            <td>
                <a href="<%=application.getContextPath()%>/dept?op=findById&deptno=${d.deptno}"><button>编辑</button></a>
                <a href="<%=application.getContextPath()%>/dept?op=remove&deptno=${d.deptno}"><button>删除</button></a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
