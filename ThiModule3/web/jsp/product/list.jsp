<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['msg'] != null}">
            <span class="alert alert-success"><c:out value="${requestScope['msg']}"/></span>
        </c:if>
    </div>
    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['msg-fail'] != null}">
            <span class="alert alert-danger"><c:out value="${requestScope['msg-fail']}"/></span>
        </c:if>
    </div>
    <table id="table" class="table table-hover table-striped table-responsive"
           style="font-size: 12px;">
        <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Stock</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['products']}" var="product">
            <tr>
                <td><c:out value="${product.productId}"/></td>
                <td><c:out value="${product.productName}"/></td>
                <td><c:out value="${product.productPrice}"/></td>
                <td><c:out value="${product.productDiscount}"/></td>
                <td><c:out value="${product.productStock}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

