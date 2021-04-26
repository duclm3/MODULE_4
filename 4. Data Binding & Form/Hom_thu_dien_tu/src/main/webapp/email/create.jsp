<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Setting</title>
  </head>
  <body>
  <form:form action="/create-setting" method="post" modelAttribute="setting">
  <h1>Settings</h1>
    Languages: <form:select path="language" items="${languageArray}"/><br>
    Page size: Show <form:select path="pageSize" items="${pageSizeArray}"/> emails per page<br>
    Spam filter: <form:checkbox path="spamFilter"/> Enable spams filter<br>
    Signature: <form:input path="signature"/>
    <button type="submit" style="color: white; background-color: cornflowerblue">Update</button>
    <button><a href="/create-setting">Cancel</a></button>
  </form:form>
  </body>
</html>
