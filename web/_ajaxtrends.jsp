<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="trends">
    
    <c:forEach var="trend" items="${trends}" varStatus="current">
        <div>
            <a target="_blank" href="https://twitter.com/${trend.screenName}/status/${trend.id}">${current.count} - ${trend.screenName}</a>
        </div>

    </c:forEach>

    <c:if test="${trends.size() eq 0 }">
        No Trend Found
    </c:if>
</div>