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
            <c:forEach items="${result.items}" var="property">
                 <li>
                     <h2>
                        ${property.address} - ${property.price}
                     </h2>
                     <p>
                         ${property.description}
                     </p>
                 </li>
            </c:forEach>
        </ul>
    </c:if>
</div>
