<%@ taglib prefix="c" uri="http://java.su/home/phuc/Documents/C102020-PhamTruongPhuc/Module4_caseStudy/src/main/resources/static/jsn.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="nav flex-column mt-lg-4">
    <c:forEach items="${requestScope['list_menu']}" var="item">
        <li class="nav-item">
            <a class="nav-link" href="<c:out value="${item.value}"/>"><c:out
                    value="${item.key}"/></a>
        </li>
    </c:forEach>
</ul>