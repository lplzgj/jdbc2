<%@ page import="java.util.List" %>
<%@ page import="com.csi.domain.Dept" %>
<%@ page import="com.csi.domain.Emp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加员工</title>
</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/emp?op=addEmp" method="post">
    <input type="text" name="empno" placeholder="请输入员工编号"><br>
    <input type="text" name="ename" placeholder="请输入员工姓名"><br>
    职位：
        <select name="job">
            <option value="CLERK">CLERK</option>
            <option value="SALESMAN">SALESMAN</option>
            <option value="MANAGER">MANAGER</option>
            <option value="ANALYST">ANALYST</option>
            <option value="PRESIDENT">PRESIDENT</option>
        </select><br>
    直系领导：
    <select name="mgr">
       <c:forEach items="${emps}" var="e">
        <option value="${e.empno}">${e.ename}</option>
       </c:forEach>
    </select><br>
    <input type="date" name="hiredate" placeholder="请输入入职日期"><br>
    <input type="number" name="sal" placeholder="请输入薪资"><br>
    <input type="number" name="comm" placeholder="请输入提成"><br>
    <select name="deptno">
        <c:forEach items="${depts}" var="d">
            <option value="${d.deptno}">${d.dname}</option>
        </c:forEach>
    </select>
    <input type="submit" value="添加员工">
</form>
</body>
</html>
