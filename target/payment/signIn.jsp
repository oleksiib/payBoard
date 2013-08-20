<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <mytags:style />
</head>
<body>
Добро пожаловать!
Для начала войдите в систему под своим логином
<form name="f" action="/j_spring_security_check" method="POST">
    <table>
        <tbody>
        <tr>
            <td>Логин(email):</td>
            <td><input type="text" name="j_username" value=""></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="j_password"></td>
        </tr>
        <tr>
            <td><a href="/registration.jsp">Зарегистрироваться</a></td>
            <td><input name="submit" type="submit" value="Войти"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>