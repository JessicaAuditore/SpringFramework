<%--
  Created by IntelliJ IDEA.
  User: JessicaAuditore
  Date: 2018/2/6
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>客户列表</title>
    <link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/Manage.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <script language="JavaScript">
        function to_page(page) {
            if (page) {
                $("#page").val(page);
            }
            document.customerForm.submit();
        }
    </script>
</head>
<body>
<form id="customerForm" name="customerForm" action="${pageContext.request.contextPath }/customer_list.action"
      method="post">
    <table cellpadding="0" cellspacing="0" width="98%" border="0">
        <tbody>
        <tr>
            <td width="15"><img src="${pageContext.request.contextPath }/images" border="0"></td>
            <td width="100%" background="${pageContext.request.contextPath }/images" height="20"></td>
            <td width="15"><img src="${pageContext.request.contextPath }/images" border="0"></td>
        </tr>
        </tbody>
    </table>
    <table cellspacing="0" cellpadding="0" width="98%" border="0">
        <tbody>
        <tr>
            <td width="15" background="${pageContext.request.contextPath }/images"><img
                    src="${pageContext.request.contextPath }/images" border="0"></td>
            <td valign="top" width="100%" bgcolor="#ffffff">
                <table cellpadding="5" cellspacing="0" width="100%" border="0">
                    <tr>
                        <td class="manageHead">当前位置：客户管理&gt; 客户列表</td>
                    </tr>
                    <tr>
                        <td height="2"></td>
                    </tr>
                </table>
                <table bordercolor="#cccccc" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                    <tbody>
                    <tr>
                        <td height="25">
                            <table cellspacing="0" cellpadding="2" border="0">
                                <tbody>
                                <tr>
                                    <td>客户名称：</td>
                                    <td><input class="textbox" id="sChannel2"
                                               style="width: 80px" maxlength="50" name="custName"></td>
                                    <td><input class="button" id="sButton2" type="submit" value=" 筛选" name="sButton2">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <table id="grid" style="border-top-width: 0px;font-weight: normal;border: none"
                                   cellspacing="1" cellpadding="2" rules="all" border="0">
                                <tbody>
                                <tr style="font-weight: bold; font-style: normal;background-color: white">
                                    <td>客户名称</td>
                                    <td>客户级别</td>
                                    <td>客户来源</td>
                                    <td>电话</td>
                                    <td>手机</td>
                                    <td>操作</td>
                                </tr>
                                <%--<c:forEach items="${list}" var="customer">--%>
                                <%--<tr style="font-weight: normal;font-style: normal;background-color: white; text-decoration: #2a8dc8">--%>
                                <%--<td>${customer.custName }</td>--%>
                                <%--<td>${customer.custLevel }</td>--%>
                                <%--<td>${customer.custSource }</td>--%>
                                <%--<td>${customer.custPhone }</td>--%>
                                <%--<td>${customer.custMobile }</td>--%>
                                <%--</tr>--%>
                                <%--</c:forEach>--%>

                                <s:iterator value="list" var="customer">
                                    <tr style="font-weight: normal;font-style: normal;background-color: white; text-decoration: #2a8dc8">
                                        <td><s:property value="#customer.custName"></s:property></td>
                                        <td><s:property value="#customer.custLevel"></s:property></td>
                                        <td><s:property value="#customer.custSource"></s:property></td>
                                        <td><s:property value="#customer.custPhone"></s:property></td>
                                        <td><s:property value="#customer.custMobile"></s:property></td>
                                    </tr>
                                </s:iterator>

                                </tbody>
                            </table>
                        </td>
                    </tr>

                    <tr>
                        <td><span id="pagelink">
                            <div style="line-height: 20px;height: 20px;text-align: center">
                                共[<b>${total}</b>]条记录，[<b>${totalPage}</b>]页
                                ，当前第[<b>${page}</b>]页
                                [<a href="javascript:to_page(${page-1})">前一页</a> ]
                                [<a href="javascript:to_page(${page+1})">后一页</a> ]
                            </div>
                        </span></td>
                    </tr>

                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
