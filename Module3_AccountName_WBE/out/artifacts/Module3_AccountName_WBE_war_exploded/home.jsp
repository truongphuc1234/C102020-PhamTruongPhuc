<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Eczar&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
</head>
<style>
    * {
        font-family: "Helvetica", sans-serif;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    h1 {
        font-family: 'Eczar', serif;
        font-size: 50px;
    }

</style>
<body>
<jsp:include page="jsp/layout/header.jsp"/>
<div class="row container-fluid mx-0 px-0 min-vh-100">
    <div class="col-0 col-lg-2 bg-light align-self-start align-self-lg-stretch">
        <jsp:include page="jsp/layout/left_nav.jsp"/>
    </div>
    <div class="col-0 col-lg-10">
        <c:if test="${requestScope['content'] != null}">
            <jsp:include page="${requestScope['content']}"/>
        </c:if>
    </div>
</div>
<jsp:include page="jsp/layout/footer.jsp"/>
</body>
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>


