<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <mytags:style />
</head>
<body>
Управление балансом пользователя

<a>Журнал пополнений</a>
Email<input type="text" value="">
<input type="button" value="Поиск"  />
<div> Pagination </div>

<table>
    <thead>
    <tr>
       <td>Email</td>
       <td>Балансе</td>
       <td>Дата регистрации</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="balance" items="${balanceList}">
        <tr>
            <td><a href="">${balance["0"]}</a></td>
            <td>${balance["1"]}</td>
            <td>${balance["2"]}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>