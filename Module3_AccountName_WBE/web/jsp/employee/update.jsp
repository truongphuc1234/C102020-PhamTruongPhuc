<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="/employee" style="font-size: medium" class="col-12 col-lg-8 p-5">
    <div class="row my-2">
        <c:if test="${requestScope['msg'] != null}">
            <span class="alert alert-success"><c:out value="${requestScope['msg']}"/></span>
        </c:if>
    </div>

    <input type="hidden" name="actionUser" value="${requestScope['actionUser']}"/>
    <div class="row my-2">
        <label for="id" class="form-label col-6">Customer Id: </label>
        <input type="text" class="form-control col-6" placeholder="Employee ID" maxlength="45" id="id"
               name="id"
               value="${requestScope['id']}" readonly/>
    </div>

    <div class="row my-2">
        <label for="name" class="col-6">Customer Name: </label>
        <input type="text" class="form-control col-6" placeholder="Employee name" maxlength="45" id="name"
               name="name"
               value="${requestScope['name']}"/>
    </div>

    <div class="row my-2">
        <label for="id_card" class="col-6">Employee Id Card: </label>
        <input type="text" class="form-control col-6" placeholder="Employee Id Card" maxlength="45" id="id_card"
               name="id_card"
               value="${requestScope['id_card']}"/>
    </div>

    <div class="row my-2">
        <label for="salary" class="col-6">Employee Salary: </label>
        <input type="text" class="form-control col-6" placeholder="Employee Salary" maxlength="45" id="salary"
               name="salary"
               value="${requestScope['salary']}"/>
    </div>

    <div class="row my-2">
        <label for="phone" class="col-6">Employee Phone: </label>
        <input type="text" class="form-control col-6" placeholder="Employee Phone" maxlength="45" id="phone"
               name="phone"
               value="${requestScope['phone']}"/>
    </div>

    <div class="row my-2">
        <label for="email" class="col-6">Employee Email: </label>
        <input type="text" class="form-control col-6" placeholder="Employee Email" maxlength="45" id="email"
               name="email"
               value="${requestScope['email']}"/>
    </div>

    <div class="row my-2">
        <label for="address" class="col-6">Employee Address: </label>
        <input type="text" class="form-control col-6" placeholder="Employee Address" maxlength="45" id="address"
               name="address"
               value="${requestScope['salary']}"/>
    </div>

    <div class="row my-2">
        <label for="position" class="col-6">Position: </label>
        <select id="position" class="form-control col-6" name="position">
            <c:forEach items="${requestScope['positions']}" var="position">
                <option value="${position.positionId}"
                        <c:if test="${Integer.toString(position.positionId).equals(requestScope['position'])}">selected="selected"</c:if>>
                    <c:out value="${position.positionName}"/></option>
            </c:forEach>
        </select>
    </div>

    <div class="row my-2">
        <label for="education_degree" class="col-6">Education Degree: </label>
        <select id="education_degree" class="form-control col-6" name="education_degree">
            <c:forEach items="${requestScope['education_degrees']}" var="education_degree">
                <option value="${education_degree.educationDegreeId}"
                        <c:if test="${Integer.toString(education_degree.educationDegreeId).equals(requestScope['education_degree'])}">selected="selected"</c:if>>
                    <c:out value="${education_degree.educationDegreeName}"/></option>
            </c:forEach>
        </select>
    </div>

    <div class="row my-2">
        <label for="division" class="col-6">Position: </label>
        <select id="division" class="form-control col-6" name="division">
            <c:forEach items="${requestScope['divisions']}" var="division">
                <option value="${division.divisionId}"
                        <c:if test="${Integer.toString(position.positionId).equals(requestScope['division'])}">selected="selected"</c:if>>
                    <c:out value="${division.divisionName}"/></option>
            </c:forEach>
        </select>
    </div>

    <div class="row my-2">
        <label for="username" class="col-6">User name: </label>
        <input type="text" class="form-control col-6" placeholder="User name" maxlength="45" id="username"
               name="username"
               value="${requestScope['username']}"/>
    </div>
    <div class="row my-2">
        <label for="password" class="col-6">Password: </label>
        <input type="password" class="form-control col-6" placeholder="Password" maxlength="45" id="password"
               name="password"
               value="${requestScope['password']}"/>
    </div>

</form>