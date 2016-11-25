<%--
  Created by IntelliJ IDEA.
  User: Asme
  Date: 11/20/2016
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="assets/css/tweets.css" rel="stylesheet">

<div>
    <nav id="nav2">
        <ul>
            <li id="documentary" class="documentary"><a href="tweets?q=documentary">Documentary</a></li>
            <li class="action"><a href="tweets?q=action">Action</a></li>
            <li class="adventure"><a href="tweets?q=adventure">Adventure</a></li>
            <li class="comedy"><a href="tweets?q=comedy">Comedy</a></li>
        </ul>

    </nav>
    <div id="tweetsContent">
        <c:forEach var="tweet" items="${tweets}">
            <div class="tweet">
                <p class="profile">
                    <img src="${tweet.imageUrl}">
                    <span>${tweet.screenName}</span>
                </p>
                <div class="text ellipsis">
                    <span class="text-concat">
                        <a target="_blank"
                           href="https://twitter.com/${tweet.screenName}/status/${tweet.id}">${tweet.text}</a>
                    </span>
                </div>
                <br>
            </div>
        </c:forEach>


    </div>
</div>
