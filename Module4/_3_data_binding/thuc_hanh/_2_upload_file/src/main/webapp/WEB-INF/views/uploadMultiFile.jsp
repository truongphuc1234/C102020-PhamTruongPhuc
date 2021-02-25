<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload One File</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<form:form modelAttribute="myUploadForm" method="POST" action="" enctype="multipart/form-data">
    Description:
    <br>
    <form:input path="description" style="width:300px"/>
    <br/><br/>
    File To Upload
    <form:input path="fileData" type="file"/><br/>
    <input type="submit" value = "Upload">
</form:form>

</body>
</html>
