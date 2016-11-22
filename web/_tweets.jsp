<%--
  Created by IntelliJ IDEA.
  User: Asme
  Date: 11/20/2016
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter API Project</title>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <script src="assets/js/twitterbar.js" typ="text/javascript"></script>
    <link href="assets/css/default.css" rel="stylesheet">
    <script>
        var activeLink = "${queryType}";
        activeLink = "documentary";
        //        var queryies=[""]
        $(function () {

            //save params using
            saveQueryParams();
            $("." + activeLink).addClass("active_link");

            $("nav > ul > li").click(function () {
                var queryParam = $(this).data().queryParam;
                alert(queryParam);
            })


        })
        function saveQueryParams() {
            $(".documentary").data("queryParam", {name: "documentary"})
            $(".action").data("action", {name: "action"})
            $(".adventure").data("adventure", {name: "adventure"})
            $(".comedy").data("comedy", {name: "comedy"})
        }
    </script>
    <style>


    </style>
</head>
<body>
<header>

</header>
<nav id="nav2">
    <ul>
        <li id="documentary" class="documentary"><a href="tweets?q=documentary">Documentary</a></li>
        <li class="action"><a href="tweets?q=action">Action</a></li>
        <li class="adventure"><a href="tweets?q=adventure">Adventure</a></li>
        <li class="comedy"><a href="tweets?q=comedy">Comedy</a></li>
    </ul>

</nav>
</body>
<footer>

</footer>
</html>

