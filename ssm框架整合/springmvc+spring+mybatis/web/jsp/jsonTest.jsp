<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        //请求json，输出json
        function requestJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/requestJson.action',
                contentType: 'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data:'{"name":"手机","price":999}',
                success:function (data) {
                    //返回json结果
                    alert("name="+data.name+" price="+data.price);
                }
            });
        }

        //请求key/value，输出json
        function responseJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/responseJson.action',
                //不需要制定contentType
                //contentType: 'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data:'name=手机&price=999',
                success:function (data) {
                    //返回json结果
                    alert("name="+data.name+" price="+data.price);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求json，输出json">
<input type="button" onclick="responseJson()" value="请求key/value，输出json">
</body>
</html>
