<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Setting</title>
  </head>
  <body>
  <h1>Settings</h1>
  Languages: ${setting.language}<br>
  Page size: ${setting.pageSize}<br>
  Spam filter: ${setting.spamFilter}<br>
  Signature: ${setting.signature}

  </body>
</html>
