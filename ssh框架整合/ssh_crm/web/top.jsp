<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94806
  Date: 2018/3/7
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>顶部</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <STYLE type=text/css>
        BODY {
            PADDING-RIGHT: 0px;
            PADDING-LEFT: 0px;
            PADDING-BOTTOM: 0px;
            MARGIN: 0px;
            PADDING-TOP: 0px;
            BACKGROUND-COLOR: #2a8dc8
        }

        BODY {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }

        TD {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }

        DIV {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }

        P {
            FONT-SIZE: 12px;
            COLOR: #003366;
            FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
        }
    </STYLE>
</head>
<body>
<c:if test="${sessionScope.user.realname==null}">
    <c:redirect url="${pageContext.request.contextPath }/login.jsp"></c:redirect>
</c:if>

<FORM id=form1 name=form1 action="" method=post>
    <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
            <TD width=10><IMG src="images/new_001.jpg" border=0></TD>
            <TD background=images/new_002.jpg><FONT size=5><B>客户关系管理系统v1.0</B></FONT></TD>
            <TD background=images/new_002.jpg>
                <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                        <TD align=right height=35></TD>
                    </TR>
                    <TR>
                        <TD height=35 align="right">
                            当前用户：${sessionScope.user.realname}
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            等级：${sessionScope.user.level}
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <A href="${pageContext.request.contextPath}/jsp/user/modify.jsp" target=main><FONT color=red>修改密码</FONT></A>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <A href="${pageContext.request.contextPath}/user_exit.action" target=_top><FONT color=red>安全退出</FONT></A>
                        </TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
            <TD width=10><IMG src="images/new_003.jpg" border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</body>
</html>
