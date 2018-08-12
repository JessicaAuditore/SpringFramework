<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        function a() {
            var roleName=$("#roleName").val();
            var note=$("#note").val();
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/login.action',
                contentType: 'application/json;charset=utf-8',
                data:'{"roleName":'+roleName+',"note":'+note+'}',
                success:function (data) {
                    alert("roleName="+data.roleName+"note="+data.note);
                }
            });
        }
    </script>
</head>
<body>
<input type="text" name="roleName" id="roleName"><br/>
<input type="text" name="note" id="note"><br/>
<input type="button" onclick="a()" value="test">
</body>
</html>
