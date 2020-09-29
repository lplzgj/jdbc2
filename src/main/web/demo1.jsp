<%@ page import="com.csi.domain.Emp" %>
<%@ page import="com.csi.dao.EmpDao" %>
<%@ page import="com.csi.dao.impl.EmpDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/23
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    EmpDao empDao = new EmpDaoImpl();
    Emp emp = empDao.findEmpByEmpNo(7788);
    request.setAttribute("emp",emp);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${emp}<br><br><br>
<c:set target="${emp}" property="ename" value="dawa"/>
${emp}
</body>
</html>
