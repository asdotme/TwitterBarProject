<%--
  Created by IntelliJ IDEA.
  User: Asme
  Date: 11/20/2016
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Twitter API Project</title>
    <meta charset="utf-8">
    <link rel="icon" href="assets/img/search-icon.png">
    <link href="assets/css/default.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <script src="assets/js/twitterbar.js" typ="text/javascript"></script>
    <script>var activeLink = "${queryType}";</script>
</head>
<body>
<header>
    <div id="header">
        <div id="first_header">
            <div id="project_name"><a href="home.jsp">CS472 TwitterBar</a></div>
            <nav id="nav1">
                <ul>
                    <li><a href="tweets">Tweets</a></li>
                    <li><a href="map">Map</a></li>
                    <li><a href="trends">Trends</a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div id="banner">
    </div>
</header>
<section id="main">
    <c:if test="${currentPageContent ne null}">
        <jsp:include page="${currentPageContent}" flush="true"/>
    </c:if>

    <c:if test="${currentPageContent eq null}">
        <div id="home_cont">
            <h1 align="center" id="home_text">Welcome to Twitter Bar Project</h1>
            <div id="home_logo"></div>
        </div>
    </c:if>
</section>
</body>
<footer>
    <p>Powered By WAP Group One, 2016</p>
</footer>
</html>

