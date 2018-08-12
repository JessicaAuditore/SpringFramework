<%--
  Created by IntelliJ IDEA.
  User: JessicaAuditore
  Date: 2018/2/11
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加客户</title>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8">
    <link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/Manage.css" type="text/css" rel="stylesheet">
    <meta content="MSHTML 6.00.2900.3492" name="GENERATOR">
</head>
<body>
<form id="form1" name="form1" action="${pageContext.request.contextPath }/customer_addCustomer.action" method="post">
    <table cellpadding="0" cellspacing="0" width="98%" border="0">
        <tbody>
        <tr>
            <td width="15"></td>
            <td width="100%"></td>
            <td width="15"></td>
        </tr>
        </tbody>
    </table>

    <table cellpadding="0" cellspacing="0" width="98%" border="0">
        <tbody>
        <tr>
            <td width="15"></td>
            <td valign="top" width="100%" bgcolor="#ffffff">
                <table cellspacing="0" cellpadding="5" width="100%" border="0">
                    <tr>
                        <td class="mangeHead">当前位置：客户管理&gt; 添加客户</td>
                    </tr>
                    <tr>
                        <td height="2"></td>
                    </tr>
                </table>

                <table cellspacing="0" cellpadding="5" border="0">
                    <tr>
                        <td>客户名称：</td>
                        <td>
                            <input class="textbox" id="sChannel2"
                                   style="width: 180px" maxlength="50" name="custName">
                        </td>
                        <td>客户级别：</td>
                        <td>
                            <input class="textbox" id="sChannel2"
                                   style="width: 180px" maxlength="50" name="custLevel">
                        </td>
                    </tr>

                    <tr>
                        <td>客户来源：</td>
                        <td>
                            <input class="textbox" id="sChannel2"
                                   style="width: 180px" maxlength="50" name="custSource">
                        </td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>固定电话：</td>
                        <td>
                            <input class="textbox" id="sChannel2"
                                   style="width: 180px" maxlength="50" name="custPhone">
                        </td>
                        <td>移动电话：</td>
                        <td>
                            <input class="textbox" id="sChannel2"
                                   style="width: 180px" maxlength="50" name="custMobile">
                        </td>
                    </tr>

                    <tr>
                        <td rowspan="2">
                            <input class="button" id="sButton2" type="submit" value="保存" name="sButton2">
                        </td>
                    </tr>
                </table>
            </td>
            <td width="15" background="${pageContext.request.contextPath }/images"><img
                    src="${pageContext.request.contextPath }/images" border="0"></td>
        </tr>
        </tbody>
    </table>
    <table cellpadding="0" cellspacing="0" width="98%" border="0">
        <tbody>
        <tr>
            <td width="15"><img src="${pageContext.request.contextPath }/images" border="0"></td>
            <td align="middle" width="100%" background="${pageContext.request.contextPath }/images"></td>
        </tr>
        </tbody>
    </table>

</form>
</body>
</html>
