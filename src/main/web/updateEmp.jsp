
<%@ page import="java.util.List" %>
<%@ page import="com.csi.domain.Dept" %>
<%@ page import="com.csi.domain.Emp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工</title>
    <%
        //接收后台传递过来的信息
        //查询所有部门信息
        List<Dept> deptAll = (List<Dept>) request.getAttribute("deptAll");
        //查询所有领导
        List<Emp> managerAll = (List<Emp>) request.getAttribute("managerAll");
        //接收修改的员工信息
        Emp emp = (Emp) request.getAttribute("emp");
    %>
</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/emp?op=updateEmp" method="post">
    <input type="hidden" name="empno" placeholder="请输入员工编号" value="<%=emp.getEmpno()%>"><br>
    <input type="text" name="ename" placeholder="请输入员工姓名" value="<%=emp.getEname()%>"><br>
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
        <%
            for (Emp e : managerAll) {
        %>
        <option value="<%=e.getEmpno()%>" <%
            if (e.getEmpno()==emp.getMgr()){
         %>
                selected
            <%
            }
            %>  ><%=e.getEname()%></option>
        <%
            }
        %>
    </select><br>
    <input type="date" name="hiredate" placeholder="请输入入职日期" value="<%=emp.getHiredate()%>"><br>
    <input type="number" name="sal" placeholder="请输入薪资" value="<%=emp.getSal()%>"><br>
    <input type="number" name="comm" placeholder="请输入提成" value="<%=emp.getComm()%>"><br>
    <select name="deptno">
        <%
            for (Dept d : deptAll) {
        %>
        <option value="<%=d.getDeptno()%>"
        <%
            if (emp.getDept().getDeptno()==d.getDeptno()){
        %> selected     <%
                    }
        %>

        ><%=d.getDname()%></option>
        <%
            }
        %>
    </select>
    <input type="submit" value="修改员工">
</form>
</body>
</html>
