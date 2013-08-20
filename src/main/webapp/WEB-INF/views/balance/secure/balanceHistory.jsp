<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <mytags:style />
    <title></title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="/js/jquery.pajinate.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $('#page_container').pajinate({
                num_page_links_to_display: 3,
                items_per_page: 10,
                wrap_around: true,
                show_first_last: false
            });

            $('#search').click(function(){

                var dateStart = $('#dateStart').value;
                var dateEnd = $('#dateEnd').value;

//                $.post("balanceHistoryDateFilter.htm", { dateStart: dateStart, endDate: endDate });
                $.ajax({
                    type: "POST",
                    url: "balanceHistoryDateFilter.htm",
                    data: { dateStart: dateStart, dateEnd: dateEnd }
                }).done(function( msg ) {
                            alert( "Data Saved: " + msg );
                        });

            });


        });

    </script>
</head>
<body>
Журнал пополнений баланса
<a href="balanceManagement.htm">Управлеие балансами</a>
<BR/>
Дата С <input type="text" value="2013-01-01" id="dateStart"/>
<BR/>
Дата ПО <input type="text" value="2013-01-01" id="dateEnd"/>

<input type="button" value="Поиск" id="search"/>
<%--<table>--%>
<div id="page_container">
    <div class="page_navigation"></div>
    <ul class="content">
        <c:forEach var="balance" items="${balanceList}">
            <li>

                <table>
                    <tr>

                        <td>${balance.editedBy.username}</td>
                        <td>${balance.user.username}</td>
                        <td>${balance.money}</td>
                        <td>${balance.saveMoneyDate}</td>

                    </tr>
                </table>
            </li>
        </c:forEach>
    </ul>
    <div class="page_navigation"></div>
</div>
<%--</table>--%>

</body>
</html>