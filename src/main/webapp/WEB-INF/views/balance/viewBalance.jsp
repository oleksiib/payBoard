<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <mytags:style />
    <title></title>
</head>
<body>
Ваш текущий баланс

<b>${amount}</b>

<a href="/j_spring_security_logout">Выйти из системы</a>

</body>
</html>