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
        <label for="name" class="col-6">Customer Name: </label>
        <input type="text" class="form-control col-6" placeholder="Customer name" maxlength="45" id="name"
               name="name"
               value="${requestScope['name']}"/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('name').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('name').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label for="name" class="col-6">Customer Name: </label>
        <input type="text" class="form-control col-6" placeholder="Customer name" maxlength="45" id="name"
               name="name"
               value="${requestScope['name']}"/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('name').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('name').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label for="price" class="col-6">Price: </label>
        <input type="number" class="form-control col-6" placeholder="price" maxlength="45" id="price"
               name="price"
               value="${requestScope['price']}"/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('price').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('price').getComment()}</span></c:if>
    </div>

    <div class="row my-2">
        <label for="discount" class="col-6">Discount: </label>
        <input type="text" class="form-control col-6" placeholder="Discount" maxlength="45" id="discount"
               name="discount"
               value="${requestScope['discount']}"/>
    </div>

    <div class="row my-2 justify-content-end">
        <c:if test="${requestScope['resultValidate'] != null && !requestScope['resultValidate'].get('discount').isPass()}"><span
                class="alert alert-danger">${requestScope['resultValidate'].get('discount').getComment()}</span></c:if>
    </div>

    <div class="row my-2 justify-content-center">
        <input type="submit" class="btn btn-primary"/>
    </div>
</form>
