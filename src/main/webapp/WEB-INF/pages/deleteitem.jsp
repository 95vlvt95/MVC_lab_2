<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Deleting book</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <div class="container" id="delete-container" align="center">
        <ul class="pager">
            <li class="previous"><a href="/">&larr; Назад</a></li>
        </ul>
        <div class="panel default-panel" id="delete-panel">
            <div class="panel-heading"><span class="lead">Вы действительно хотите удалить книгу?</span></div>
            <div class="panel-body">
                <form class="form-horizontal delete-form" action="" role="form">
                    <div class="from-group">
                        <label class="col-md-3 control-label">Название</label>
                        <div class="col-md-9">
                            <p class="form-control-static">${bookToDelete.name}</p>
                        </div>
                    </div>
                    <div class="from-group">
                        <label class="col-md-3 control-label">Жанр</label>
                        <div class="col-md-9">
                            <p class="form-control-static">${bookToDelete.genre}</p>
                        </div>
                    </div>
                    <div class="from-group">
                        <label class="col-md-3 control-label">Авторы</label>
                        <div class="col-md-9">
                            <p class="form-control-static">
                                ${bookToDelete.authors.iterator().next().getFirstName()}
                                ${bookToDelete.authors.iterator().next().getLastName()}
                                ${bookToDelete.authors.iterator().next().getPatronymic()}
                            </p>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel-footer">
                <form action="" role="form" method="get">
                    <%--<a class="btn btn-danger btn-lg" href="">Удалить</a>--%>
                    <button type="submit" name="delete-btn" class="btn btn-danger btn-lg" value="true" formmethod="get">Удалить</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
