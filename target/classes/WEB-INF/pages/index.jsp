<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Library</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">
            <h1><a href="/">Library</a></h1>

            <nav class="navbar navbar-default">
                <div class="container-fluid">

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul id="groupList" class="nav navbar-nav">
                            <li><button type="button" id="add_book" class="btn btn-primary navbar-btn">Add Book</button></li>
                            <li><button type="button" id="add_genre" class="btn btn-primary navbar-btn">Add Genre</button></li>
                            <li><button type="button" id="delete_book" class="btn btn-warning navbar-btn">Delete Book</button></li>

                            <li class="dropdown">

                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Genre <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/">Default</a></li>
                                    <c:forEach items="${genre}" var="genre">
                                        <li><a href="/genre/${genre.id}">${genre.name}</a></li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left" role="search" action="/search" method="post">
                            <div class="form-genre">
                                <input type="text" class="form-control" name="pattern" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                    </div>
                </div>
            </nav>

            <table class="table table-striped">
                <thead>
                <tr>
                    <td></td>
                    <td><b>Name</b></td>
                    <td><b>Writer</b></td>
                    <td><b>Description</b></td>
                    <td><b>Genre</b></td>
                </tr>
                </thead>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td><input type="checkbox" name="toDelete[]" value="${book.id}" id="checkbox_${book.id}"/></td>
                        <td>${book.name}</td>
                        <td>${book.writer}</td>
                        <td>${book.description}</td>
                        <c:choose>
                            <c:when test="${book.genre ne null}">
                                <td>${book.genre.name}</td>
                            </c:when>
                            <c:otherwise>
                                <td>Default</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <script>
            $('.dropdown-toggle').dropdown();

            $('#add_book').click(function(){
                window.location.href='/book_add_page';
            })

            $('#add_genre').click(function(){
                window.location.href='/genre_add_page';
            })

            $('#delete_book').click(function(){
                var data = { 'toDelete[]' : []};
                $(":checked").each(function() {
                    data['toDelete[]'].push($(this).val());
                });
                $.post("/book/delete", data);
            })

            $( "li .searchterm" ).click(function() {
                console.log('testing');
            });
        </script>
    <p class = "text-info"><em><blockguote class = "pull-right">
       <br> Non refert quam multos, sed quam bonos habeas (lat.) &emsp;</blockguote>  </em> </p>

    </body>
</html>