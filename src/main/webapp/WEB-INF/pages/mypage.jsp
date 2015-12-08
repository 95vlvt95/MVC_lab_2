<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>My Library</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
    <div class="container" id="my-page-container">
        <div class="panel default-panel">
            <div class="panel-heading"><span class="lead">Список всех книг</span></div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Название</th>
                            <th>Жанр</th>
                            <th>Описание</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td>${book.name}</td>
                            <td>${book.genre}</td>
                            <td>${book.description}</td>
                            <td><a href="<c:url value='/delete-book-${book.id}' />" class="btn btn-danger btn-delete">Удалить</a></td>
                        </tr>
                    </c:forEach>
                    <form action="" role="form" method="post">
                        <div class="form-group">
                            <tr class="add-book-row">
                                <td><input type="text" class="form-control" name="name" id="inputName" placeholder="Название"></td>
                                <td><input type="text" class="form-control" name="genre" id="inputGenre"  placeholder="Жанр"></td>
                                <td><input type="text" class="form-control" name="desc" id="inputDesc" placeholder="Описание"></td>
                                <td>
                                    <select class="form-control" name="authorId">
                                        <option>Выберите автора</option>
                                        <option name="author1" value="${authors.get(0).id}">${authors.get(0).firstName} ${authors.get(0).lastName} ${authors.get(0).patronymic}</option>
                                        <option name="author2" value="${authors.get(1).id}">${authors.get(1).firstName} ${authors.get(1).lastName} ${authors.get(1).patronymic}</option>
                                    </select>
                                </td>
                            </tr>
                            <tr class="add-book-row">
                                <td colspan="4">
                                    <div id="btn-add" class="center-block">
                                        <button type="submit" class="btn btn-primary btn-lg" formmethod="post">Добавить</button>
                                    </div>
                                </td>
                            </tr>
                        </div>
                    </form>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="panel default-panel" id="select-pan">
            <select class="form-control" onchange="if (this.value) window.location.href=this.value" >
                <option>Выберите автора</option>
                <option value="/${authors.get(0).id}">${authors.get(0).firstName} ${authors.get(0).lastName} ${authors.get(0).patronymic}</option>
                <option value="/${authors.get(1).id}">${authors.get(1).firstName} ${authors.get(1).lastName} ${authors.get(1).patronymic}</option>
            </select>
        </div>

        <div class="panel default-panel">
            <div class="panel-heading">
                <span class="lead">${selectedAuthor.firstName}
                                   ${selectedAuthor.lastName}
                                   ${selectedAuthor.patronymic}
                </span>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Жанр</th>
                    <th>Описание</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authorBooks}" var="authorBook">
                    <tr>
                        <td>${authorBook.name}</td>
                        <td>${authorBook.genre}</td>
                        <td>${authorBook.description}</td>
                        <td><a href="<c:url value='/delete-book-${authorBook.id}' />" class="btn btn-danger btn-delete">Удалить</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
