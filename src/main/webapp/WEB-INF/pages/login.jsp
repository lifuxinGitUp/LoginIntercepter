<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/10
  Time: 上午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="/login" method="post">
    用户名: <input type="text" name="username" placeholder="请输入用户名">
    <c:if test="${uError != null and uError != ''}">
        ${uError.defaultMessage}
    </c:if>
    <br>
    密 码: <input type="password" name="password" placeholder="请输入密码">
    <c:if test="${pError != null and pError != ''}">
        ${pError.defaultMessage}
    </c:if>
    <br>
    <input type="submit" value="提交">
</form>
<c:if test="${loginError != null and loginError != ''}">
    ${loginError}
</c:if>
<h3>*******输入验证错误信息显示********</h3>
<c:if test="${errors != null and errors.size() > 0}">
    <c:forEach items="${errors}" var="err">
        ${err.defaultMessage}
    </c:forEach>
</c:if>
</body>
</html>
