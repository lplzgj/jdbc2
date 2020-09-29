<%@ page import="com.csi.domain.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.csi.util.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/22
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    table{
        margin: auto;
        text-align: center;
        border-collapse: collapse;
    }
    table,th,td{
        border: 1px solid black;
    }
</style>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>职位</th>
        <th>领导编号</th>
        <th>入职日期</th>
        <th>薪资</th>
        <th>提成</th>
        <th>部门</th>
        <th>操作</th>
    </tr>
    <c:forEach var="e" items="${empPage.data}">
        <tr>
            <td>${e.empno}</td>
            <td>${e.ename}</td>
            <td>${e.job}</td>
            <td>${e.mgr}</td>
            <td>${e.hiredate}</td>
            <td>${e.sal}</td>
            <td><c:out value="${e.comm}"  default="无提成"/></td>
            <td>${e.dept.deptno}</td>
            <td>
                <a href="<%=application.getContextPath()%>/emp?op=findById&empno=${e.empno}"><button>编辑</button></a>
                <a class="delClass" href="<%=application.getContextPath()%>/emp?op=remove&empno=${e.empno}"><button>删除</button></a>
            </td>

        </tr>
    </c:forEach>
    <tr>
        <td colspan="9">
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=1">首页</a>
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=${empPage.prev()}">上一页</a>
            当前页${empPage.currentPage}/${empPage.getTotalPageCount()}
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=${empPage.next()}">下一页</a>
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=${empPage.getTotalPageCount()}">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
