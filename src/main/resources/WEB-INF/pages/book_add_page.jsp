<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Book</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/book/add" method="post">
                        <h3>New book</h3>
                        <select class="selectpicker form-control form-genre" name="genre">
                            <option value="-1">Default</option>
                            <c:forEach items="${genre}" var="genre">
                                <option value="${genre.id}">${genre.name}</option>
                            </c:forEach>
                        </select>
                        <input class="form-control form-genre" type="text" name="name" placeholder="Name">
                        <input class="form-control form-genre" type="text" name="writer" placeholder="Writer">
                        <input class="form-control form-genre" type="text" name="description" placeholder="Description">
                        <input type="submit" class="btn btn-success" value="Add">
            </form>
        </div>

        <script>
            $('.selectpicker').selectpicker();
        </script>
    </body>
</html>