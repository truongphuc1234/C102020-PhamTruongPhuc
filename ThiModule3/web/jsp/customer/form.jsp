<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="/product" style="font-size: medium" class="col-12 col-lg-8 p-5">
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

    <input type="hidden" name="actionUser" value="${requestScope['actionUser']}"/>
    <div class="row my-2">
        <label for="id" class="form-label col-6">Customer Id: </label>
        <input type="text" class="form-control col-6" placeholder="Customer ID" maxlength="45" id="id"
               name="id"
               value="${requestScope['id']}"
               <c:if test="${'view'.equals(requestScope['actionUser']) ||'update'.equals(requestScope['actionUser'])}">readonly</c:if>/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${'create'.equals(requestScope['actionUser']) && requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('id').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('id').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label for="name" class="col-6">Customer Name: </label>
        <input type="text" class="form-control col-6" placeholder="Customer name" maxlength="45" id="name"
               name="name"
               value="${requestScope['name']}"
               <c:if test="${'view'.equals(requestScope['actionUser'])}">readonly</c:if>/>
    </div>

    <div class="row my-2">
        <label for="customer_type" class="col-6">Customer Type: </label>
        <select id="customer_type" class="form-control col-6" name="customer_type"
                <c:if test="${'view'.equals(requestScope['actionUser'])}">disabled</c:if>>
            <c:forEach items="${requestScope['customer_types']}" var="customer_type">
                <option value="${customer_type.customerTypeId}"
                        <c:if test="${Integer.toString(customer_type.customerTypeId).equals(requestScope['customer_type'])}">selected="selected"</c:if>>
                    <c:out value="${customer_type.customerTypeName}"/></option>
            </c:forEach>
        </select>
    </div>

    <div class="row my-2">
        <label for="birthday" class="col-6">Employee Birthday: </label>
        <input type="date" class="form-control col-6" placeholder="Customer Birthday" maxlength="45" id="birthday"
               name="birthday"
               value="${requestScope['birthday']}"
               <c:if test="${'view'.equals(requestScope['actionUser'])}">readonly</c:if>/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('birthday').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('birthday').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label class="col-6">Gender: </label>
        <div class="col-6 d-flex flex-row justify-content-around">
            <div class="form-check">
                <input type="radio" class="form-check-input" id="gender_male" name="gender" value="1"
                       <c:if test="${requestScope['gender']}">checked</c:if>
                       <c:if test="${'view'.equals(requestScope['actionUser'])}">disabled</c:if>/>
                <label for="gender_male" class="form-check-label">
                    Male
                </label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="gender_female" name="gender" value="0"
                       <c:if test="${!requestScope['gender']}">checked</c:if>
                       <c:if test="${'view'.equals(requestScope['actionUser'])}">disabled</c:if>/>
                <label for="gender_female" class="form-check-label">
                    Female
                </label>
            </div>
        </div>
    </div>

    <div class="row my-2">
        <label for="id_card" class="col-6">Customer Id Card: </label>
        <input type="text" class="form-control col-6" placeholder="Customer Id Card" maxlength="45" id="id_card"
               name="id_card"
               value="${requestScope['id_card']}"
               <c:if test="${'view'.equals(requestScope['actionUser'])}">readonly</c:if>/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('id_card').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('id_card').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label for="phone" class="col-6">Customer Phone: </label>
        <input type="text" class="form-control col-6" placeholder="Customer Phone" maxlength="45" id="phone"
               name="phone"
               value="${requestScope['phone']}"
               <c:if test="${'view'.equals(requestScope['actionUser'])}">readonly</c:if>/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('phone').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('phone').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label for="email" class="col-6">Customer Email: </label>
        <input type="text" class="form-control col-6" placeholder="Customer Email" maxlength="45" id="email"
               name="email"
               value="${requestScope['email']}"
               <c:if test="${'view'.equals(requestScope['actionUser'])}">readonly</c:if>/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('email').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('email').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label for="address" class="col-6">Customer Address: </label>
        <input type="text" class="form-control col-6" placeholder="Customer Address" maxlength="45" id="address"
               name="address"
               value="${requestScope['address']}"
               <c:if test="${'view'.equals(requestScope['actionUser'])}">readonly</c:if>/>
    </div>

    <c:if test="${!'view'.equals(requestScope['actionUser'])}">
        <div class="row my-2 justify-content-center">
            <input type="submit" class="btn btn-primary"/>
        </div>
    </c:if>

</form>
