<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="/customer?actionUser=delete&id=${requestScope['customerView'].customerId}">Delete</a>
<a href="/customer?actionUser=update&id=${requestScope['customerView'].customerId}">Update</a>
<div>
    <div>
        <label for="id">Customer Id: </label>
        <input type="text" placeholder="Customer ID" maxlength="45" id="id" name="id"
               value="${requestScope['customerView'].customerId}" readonly/>
    </div>
    <div>
        <label for="name">Customer Name: </label>
        <input type="text" placeholder="Customer name" maxlength="45" id="name" name="name"
               value="${requestScope['customerView'].customerName}" readonly/>
    </div>
    <div>
        <label for="customer_type">Customer Type: </label>
        <select id="customer_type" name="customer_type" readonly>
            <c:forEach items="${requestScope['customer_types']}" var="type">
                <option value="${type.customerTypeId}"
                        <c:if test="${Integer.toString(type.customerTypeId).equals(requestScope['customerView'].customerTypeId)}">selected="selected"</c:if>>
                    <c:out value="${type.customerTypeName}"/></option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="birthday">Birthday: </label>
        <input type="date" placeholder="dd-MM-yyyy" maxlength="45" id="birthday" name="birthday"
               value="${requestScope['customerView'].customerBirthday}" readonly/>
    </div>
    <div>
        <span>Gender: </span>
        <input type="radio" id="gender_male" name="gender" value="1"
               <c:if test="${requestScope['customerView'].customerGender}">checked</c:if> readonly><label
            for="gender_male">Male</label>
        <input type="radio" id="gender_female" name="gender" value="0"
               <c:if test="${!requestScope['customerView'].customerGender}">checked</c:if> readonly><label
            for="gender_female">Female</label>
    </div>
    <div>
        <label for="id_card">Id Card: </label>
        <input type="text" placeholder="ID card" maxlength="45" id="id_card" name="id_card"
               value="${requestScope['customerView'].customerIdCard}" readonly/>
    </div>
    <div>
        <label for="phone">Phone Number: </label>
        <input type="text" placeholder="Phone Number" maxlength="45" id="phone" name="phone"
               value="${requestScope['customerView'].customerPhone}" readonly/>
    </div>
    <div>
        <label for="email">Email: </label>
        <input type="text" placeholder="Email" maxlength="45" id="email" name="email"
               value="${requestScope['customerView'].customerEmail}" readonly/>
    </div>
    <div>
        <label for="address">Address: </label>
        <input type="text" placeholder="Address" maxlength="45" id="address" name="address"
               value="${requestScope['customerView'].customerAddress}" readonly/>
    </div>
</div>
