<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="/employee">
    <c:if test="${requestScope['msg'] != null}">
        <c:out value="${requestScope['msg']}"/>
    </c:if>
    <input type="hidden" name="actionUser" value="create"/>
    <div>
        <label for="id">Employee Id: </label>
        <input type="text" placeholder="Employee ID" maxlength="45" id="id" name="id"
               value="${requestScope['id'][0]}"/>
        <c:if test="${!requestScope['resultValidate'].get('id').isPass()}"><span>${requestScope['resultValidate'].get('id').getComment()}</span></c:if>
    </div>
    <div>
        <label for="name">Customer Name: </label>
        <input type="text" placeholder="Customer name" maxlength="45" id="name" name="name"
               value="${paramValues['name'][0]}"/>
    </div>
    <div>
        <label for="customer_type">Customer Type: </label>
        <select id="customer_type" name="customer_type">
            <c:forEach items="${requestScope['customer_types']}" var="type">
                <option value="${type.customerTypeId}"
                        <c:if test="${Integer.toString(type.customerTypeId).equals(paramValues['customer_type'][0])}">selected="selected"</c:if>>
                    <c:out value="${type.customerTypeName}"/></option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="birthday">Birthday: </label>
        <input type="date" placeholder="dd-MM-yyyy" maxlength="45" id="birthday" name="birthday"
               value="${paramValues['birthday'][0]}"/>
        <c:if test="${!requestScope['resultValidate'].get('birthday').isPass()}"><span>${requestScope['resultValidate'].get('birthday').getComment()}</span></c:if>
    </div>
    <div>
        <span>Gender: </span>
        <input type="radio" id="gender_male" name="gender" value="1"
               <c:if test="${!'0'.equals(paramValues['gender'][0])}">checked</c:if>><label for="gender_male">Male</label>
        <input type="radio" id="gender_female" name="gender" value="0"
               <c:if test="${'0'.equals(paramValues['gender'][0])}">checked</c:if>><label
            for="gender_female">Female</label>
    </div>
    <div>
        <label for="id_card">Id Card: </label>
        <input type="text" placeholder="ID card" maxlength="45" id="id_card" name="id_card"
               value="${paramValues['id_card'][0]}"/>
        <c:if test="${!requestScope['resultValidate'].get('id_card').isPass()}"><span>${requestScope['resultValidate'].get('id_card').getComment()}</span></c:if>
    </div>
    <div>
        <label for="phone">Phone Number: </label>
        <input type="text" placeholder="Phone Number" maxlength="45" id="phone" name="phone"
               value="${paramValues['phone'][0]}"/>
        <c:if test="${!requestScope['resultValidate'].get('phone').isPass()}"><span>${requestScope['resultValidate'].get('phone').getComment()}</span></c:if>
    </div>
    <div>
        <label for="email">Email: </label>
        <input type="text" placeholder="Email" maxlength="45" id="email" name="email"
               value="${paramValues['email'][0]}"/>
        <c:if test="${!requestScope['resultValidate'].get('email').isPass()}"><span>${requestScope['resultValidate'].get('email').getComment()}</span></c:if>
    </div>
    <div>
        <label for="address">Address: </label>
        <input type="text" placeholder="Address" maxlength="45" id="address" name="address"
               value="${paramValues['address'][0]}"/>
    </div>
    <div>
        <input type="submit" id="submit" value="submit"/>
    </div>
</form>