<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Genre</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/genre/add" method="post">
                <div class="form-genre"><h3>New Genre</h3></div>
                <div class="form-genre"><input type="text" class="form-control" name="name" placeholder="Name"></div>
                <div class="form-genre"><input type="submit" class="btn btn-success" value="Add"></div>
            </form>
        </div>
    </body>
</html>