<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="tablePagination" class="table table-bordered table-hover table-striped overflow-auto" style="font-size: small;">
    <tr>
        <th>Customer ID</th>
        <th>Customer Type</th>
        <th>Customer Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>ID card</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope['customerView']}" var="customer">
        <tr>
            <td><c:out value="${customer.customerId}"/></td>
            <td><c:out value="${customer.customerTypeName}"/></td>
            <td><c:out value="${customer.customerName}"/></td>
            <td><c:out value="${customer.customerBirthday}"/></td>
            <td>
                <c:if test="${customer.customerGender}">Male</c:if>
                <c:if test="${!customer.customerGender}">Female</c:if>
            </td>
            <td><c:out value="${customer.customerIdCard}"/></td>
            <td><c:out value="${customer.customerPhone}"/></td>
            <td><c:out value="${customer.customerEmail}"/></td>
            <td><c:out value="${customer.customerAddress}"/></td>
            <th><a href="/customer?actionUser=view&id=${customer.customerId}">View</a></th>
            <th><a href="/customer?actionUser=update&id=${customer.customerId}">Update</a></th>
            <th><a href="/customer?actionUser=delete&id=${customer.customerId}">Delete</a></th>
        </tr>
    </c:forEach>
</table>

