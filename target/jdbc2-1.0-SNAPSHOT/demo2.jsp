<%@ page import="com.csi.service.EmpService" %>
<%@ page import="com.csi.service.impl.EmpServiceImpl" %>
<%@ page import="com.csi.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/24
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    EmpService empService = new EmpServiceImpl();
    Emp emp = empService.findEmpByEmpNo(7788);
    request.setAttribute("emp",emp);
%>
<body>
<%--<c:if test="${emp  ne null}">--%>
<%--    1--%>
<%--</c:if>--%>
<%--<c:if test="${emp  eq null}">--%>
<%--    2--%>
<%--</c:if>--%>
<c:set var="islogin" value="${emp  ne null}"/>
<c:if test="${islogin}">
    1
</c:if>
<c:if test="${!islogin}">
    2
</c:if>
</body>
</html>
