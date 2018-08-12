<%--
  Created by IntelliJ IDEA.
  User: JessicaAuditore
  Date: 2018/2/6
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href=menu.jsp>
    <script language="JavaScript">
        var comment = document.getElementsByTagName('a')[0];
        if (document.all) {
            // For IE
            comment.click();
        }else if (document.createEvent) {
            //FOR DOM2
            var ev = document.createEvent('MouseEvents');
            ev.initEvent('click', false, true);
            comment.dispatchEvent(ev);
        }
    </script>
  </body>
</html>
