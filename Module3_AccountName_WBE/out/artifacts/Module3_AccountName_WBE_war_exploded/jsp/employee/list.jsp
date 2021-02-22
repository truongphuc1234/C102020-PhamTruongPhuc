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
    <a href="/product?actionUser=create">Create</a>
    <table id="table" class="table table-hover table-striped table-responsive"
           style="font-size: 12px;">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Id Card</th>
            <th>Salary</th>
            <th>ID card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education Degree</th>
            <th>Division</th>
            <th>Username</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['employee_view']}" var="customer">
            <tr>
                <td><c:out value="${customer.employeeId}"/></td>
                <td><c:out value="${customer.employeeName}"/></td>
                <td><c:out value="${customer.employeeBirthday}"/></td>
                <td><c:out value="${customer.employeeIdCard}"/></td>
                <td><c:out value="${customer.employeeSalary}"/></td>
                <td><c:out value="${customer.employeeIdCard}"/></td>
                <td><c:out value="${customer.employeePhone}"/></td>
                <td><c:out value="${customer.employeeEmail}"/></td>
                <td><c:out value="${customer.employeeAddress}"/></td>
                <td><c:out value="${customer.positionName}"/></td>
                <td><c:out value="${customer.educationDegreeName}"/></td>
                <td><c:out value="${customer.divisionName}"/></td>
                <td><c:out value="${customer.username}"/></td>
                <td class="flex-row"><a href="/employee?actionUser=view&id=${customer.employeeId}"><span
                        class="material-icons">visibility</span></a></td>
                <td><a href="/employee?actionUser=update&id=${customer.employeeId}"><span
                        class="material-icons">create</span></a></td>
                <td><a href="#" data-toggle="modal" data-target="#deleteModal"
                       data-id="${customer.employeeId}" data-action="/employee"><span
                        class="material-icons">delete</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

