<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Settings</title>
</head>
<body>
<h1>Email Settings</h1>
<table>
    <tr>
        <td>Languages</td>
        <td>${setting.language}</td>
    </tr>
    <tr>
        <td>Page Size</td>
        <td>${setting.pageSize}</td>
    </tr>
    <tr>
        <td>Spams filters</td>
        <td>${(setting.spamFilter)? "Enable":"Disable"}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${setting.signature}</td>
    </tr>
</table>
<button><a href="/setting">Setting</a></button>
</body>
</html>
