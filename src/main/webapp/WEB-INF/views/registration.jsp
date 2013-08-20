<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <mytags:style />
</head>
<body>

Регистрация
<form name="f" action="/user/registration.htm" method="POST">
    <table>
        <tbody>
        <tr>
            <td>Логин(email):</td>
            <td><input type="text" name="username" value=""></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>Подтвердить пароль:</td>
            <td><input type="password" name="passwordConfirm"></td>
        </tr>
        <tr>
            <td><a href="/signIn.jsp">Войти</a></td>
            <td><input name="submit" type="submit" value="Сохранить"></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>