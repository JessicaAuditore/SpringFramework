<%--
  Created by IntelliJ IDEA.
  User: JessicaAuditore
  Date: 2018/2/11
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        body {
            padding-right: 0px;
            padding-left: 0px;
            padding-bottom: 0px;
            margin: 0px;
            padding-top: 0px;
            background-color: #2a8dc8;
        }

        body {
            font-size: 11px;
            color: #003366;
            font-family: Verdana;
        }

        TD {
            font-size: 11px;
            color: #003366;
            font-family: Verdana;
        }

        div {
            font-size: 11px;
            color: #003366;
            font-family: Verdana;
        }

        p {
            font-size: 11px;
            color: #003366;
            font-family: Verdana;
        }

        .mainMenu {
            font-weight: bold;
            font-size: 14px;
            cursor: pointer;
            color: #000000;
        }

        A.style2:link {
            padding-left: 4px;
            color: #0055bb;
            text-decoration: none;
        }

        A.style2:visited{
            padding-left: 4px;
            color: #0055bb;
            text-decoration: none;
        }

        A.style2:hover {
            padding-left: 4px;
            color: #ff0000;
            text-decoration: none;
        }

        A.active {
            padding-left: 4px;
            color: #ff0000;
            text-decoration: none;
        }

        .span {
            color: #ff0000;
        }

    </style>
</head>
<body>
<form id="form1" name="form1" action="YHMenu.aspx" method="post">
    <table cellpadding="0" cellspacing="0" width="210" align="center" border="0">
        <tbody>
        <tr>
            <td width="15"><img src="images" border="0"></td>
            <td align="middle" width="180" height="35" background="images"><b>人力资源-功能菜单</b></td>
            <td width="15"><img src="images" border="0"></td>
        </tr>
        </tbody>
    </table>
    <table cellspacing="0" cellpadding="0" width="210" align="center" border="0">
        <tbody>
        <tr>
            <td width="15" background="images"></td>
            <td valign="top" width="180" bgcolor="#ffffff">
                <table cellspacing="0" cellpadding="3" width="165" align="center" border="0">
                    <tbody>
                    <tr>
                        <td class="mainMenu" onclick="MenuDisplay('table_1');"><span
                                class="span" id="table_1Span">+</span> 客户管理</td>
                    </tr>
                    <tr>
                        <td>
                            <table id="table_1" style="display: none" cellspacing="0"
                                   cellpadding="2" width="155" align="center" border="0">
                                <tbody>
                                <tr>
                                    <td class="menuSmall"><a class="style2"
                                                             href="${pageContext.request.contextPath }/customer_toAddPage.action"
                                                             target="main">- 新增用户</a></td>
                                </tr>
                                <tr>
                                    <td class="menuSmall"><a class="style2"
                                                             href="${pageContext.request.contextPath }/customer_list.action"
                                                             target="main">- 客户列表</a></td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td background="images" height="1"></td>
                    </tr>
                    <tr>
                        <td class="mainMenu" onclick="MenuDisplay('table_2');"><span
                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</form>

<script language="JavaScript">
    function MenuDisplay(obj_id) {
        for (var i = 1; i <= 9; i++) {
            var obj = document.getElementById('table_' + i);
            if (obj) {
                document.getElementById('table_' + i).style.display = 'none';
                document.getElementById('table_' + i + 'Span').innerText = '+';
            }
        }
        var obj = document.getElementById(obj_id);
        if (obj) {
            if (obj.style.display == 'none') {
                obj.style.display = 'block';
                document.getElementById(obj_id + 'Span').innerText = '-';
            } else {
                obj.style.display = 'none';
                document.getElementById(obj_id + 'Span').innerText = '+';
            }
        }
    }
</script>


</body>
</html>
