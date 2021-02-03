<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="/customer" style="font-size: medium" class="col-12 col-lg-8 p-5">
    <div class="row my-2">
        <c:if test="${requestScope['msg'] != null}">
            <span class="alert alert-success"><c:out value="${requestScope['msg']}"/></span>
        </c:if>
    </div>
    <input type="hidden" name="actionUser" value="update"/>
    <div class="row my-2">
        <label for="id" class="form-label col-6">Customer Id: </label>
        <input type="text" class="form-control col-6" placeholder="Customer ID" maxlength="45" id="id"
               name="id"
               value="${requestScope['customerView'].customerId}" readonly/>
    </div>
    <div class="row my-2">
        <label for="name" class="col-6">Customer Name: </label>
        <input type="text" class="form-control col-6" placeholder="Customer name" maxlength="45" id="name"
               name="name"
               value="${requestScope['customerView'].customerName}"/>
    </div>
    <div class="row my-2">
        <label for="customer_type" class="col-6">Customer Type: </label>
        <select id="customer_type" class="form-control col-6" name="customer_type">
            <c:forEach items="${requestScope['customer_types']}" var="type">
                <option value="${type.customerTypeId}"
                        <c:if test="${Integer.toString(type.customerTypeId).equals(requestScope['customerView'].customerTypeId)}">selected="selected"</c:if>>
                    <c:out value="${type.customerTypeName}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="row my-2">
        <label for="birthday" class="col-6">Birthday: </label>
        <input type="date" class="form-control col-6" placeholder="dd-MM-yyyy" maxlength="45" id="birthday"
               name="birthday"
               value="${requestScope['customerView'].customerBirthday}"/>
    </div>
    <div class="row my-2">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('birthday').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('birthday').getComment()}</span></c:if>
    </div>
    <div class="row my-2">
        <label class="col-6">Gender: </label>
        <div class="col-6 d-flex flex-row justify-content-around">
            <div class="form-check">
                <input type="radio" class="form-check-input" id="gender_male" name="gender" value="1"
                       <c:if test="${requestScope['customerView'].customerGender}">checked</c:if>><label
                    for="gender_male" class="form-check-label">Male</label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="gender_female" name="gender" value="0"
                       <c:if test="${!requestScope['customerView'].customerGender}">checked</c:if>><label
                    for="gender_female" class="form-check-label">Female</label>
            </div>
        </div>
    </div>
    <div class="row my-2">
        <label for="id_card" class="col-6">Id Card: </label>
        <input type="text" class="form-control col-6" placeholder="ID card" maxlength="45" id="id_card"
               name="id_card"
               value="${requestScope['customerView'].customerIdCard}"/>
    </div>
    <div class="row my-2">
        <c:if test="${requestScope['resultValidate'] != null &&!requestScope['resultValidate'].get('id_card').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('id_card').getComment()}</span></c:if>
    </div>
    <div class="row my-2">
        <label for="phone" class="col-6">Phone Number: </label>
        <input type="text" class="form-control col-6" placeholder="Phone Number" maxlength="45" id="phone"
               name="phone"
               value="${requestScope['customerView'].customerPhone}"/>
    </div>
    <div class="row my-2">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('phone').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('phone').getComment()}</span></c:if>
    </div>
    <div class="row my-2">
        <label for="email" class="col-6">Email: </label>
        <input type="text" class="form-control col-6" placeholder="Email" maxlength="45" id="email"
               name="email"
               value="${requestScope['customerView'].customerEmail}"/>
    </div>
    <div class="row my-2">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('email').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('email').getComment()}</span></c:if>
    </div>
    <div class="row my-2">
        <label for="address" class="col-6">Address: </label>
        <input type="text" class="form-control col-6" placeholder="Address" maxlength="45" id="address"
               name="address"
               value="${requestScope['customerView'].customerAddress}"/>
    </div>
    <div class="row my-2 w-50 justify-content-lg-end justify-content-center">
        <input type="submit" id="submit" value="submit" class="btn btn-secondary"/>
    </div>
</form>