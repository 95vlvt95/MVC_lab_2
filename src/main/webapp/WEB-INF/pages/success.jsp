<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <div class="container" align="center" id="success-container">
        <ul class="pager">
            <li class="previous"><a href="/">&larr; Назад</a></li>
        </ul>
        <div class="panel default-panel" id="success-panel">
            <div class="panel-body">
                <p class="text-success">${success}</p>
            </div>
        </div>
    </div>
</body>
</html>
