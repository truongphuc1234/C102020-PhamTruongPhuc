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
    <table id="table" class="table table-hover table-striped table-responsive w-100"
           style="font-size: 12px;">
        <thead>
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
        </thead>
        <tbody>
        <c:forEach items="${requestScope['customer_view']}" var="customer">
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
                <td class="flex-row"><a href="/customer?actionUser=view&id=${customer.customerId}"><span
                        class="material-icons">visibility</span></a></td>
                <td><a href="/customer?actionUser=update&id=${customer.customerId}"><span
                        class="material-icons">create</span></a></td>
                <td><a href="#" data-toggle="modal" data-target="#deleteModal"
                       data-id="${customer.customerId}" data-action="/customer"><span
                        class="material-icons">delete</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

