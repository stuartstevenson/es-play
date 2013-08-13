<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
    Search Results
</h1>
<div>
    <form method="GET">
        <input type="text" name="q"/>
        <input type="submit" value="Go"/>
    </form>
</div>
<div>
    <c:if test="${not empty result.items}">
        <ul>
            <c:forEach items="${result.items}" var="post">
                 <li>
                     <h2>
                        ${post.title} - ${post.postDate}
                     </h2>
                     <p>
                         ${post.content}
                     </p>
                 </li>
            </c:forEach>
        </ul>
    </c:if>
</div>
