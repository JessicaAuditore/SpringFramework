<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户信息管理</title>
    <link rel="stylesheet" type="text/css" href="../ui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../ui/themes/icon.css">
    <script type="text/javascript" src="../ui/jquery.min.js"></script>
    <script type="text/javascript" src="../ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../ui/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(function () {
            var columns = [[
                {field: 'custName', title: '客户名称', width: 200},
                {
                    field: 'custLevel', title: '客户级别', width: 200, formatter: function (value, row, index) {
                        if (row.custLevel) {
                            return row.custLevel.dname;
                        }
                    }
                },
                {field: 'custSource', title: '客户来源', width: 200},
                {field: 'custMobile', title: '客户电话', width: 150},
                {field: 'custPhone', title: '客户手机', width: 150},
                {
                    field: '-', title: '操作', width: 100, formatter: function (value, row, index) {
                        return "<a href='#' onclick='edit(" + row.cid + ")'>修改</a> <a href='#' onclick='del(" + row.cid + ")'>删除</a>";
                    }
                }
            ]];
            //加载datagrid
            $('#grid').datagrid({
                url: '${pageContext.request.contextPath}/customer_customerPageJson.action',
                columns: columns,
                pagination: true,
                singleSelect: true,
                toolbar: [{
                    iconCls: 'icon-add',
                    text: '增加',
                    handler: add
                }]
            });
        });

        //操作方法
        var method;

        //保存客户
        function save() {
            if (method == 'add') {
                //添加客户提交
                addsubmit();

            } else {
                //修改客户提交
                editsubmit();
            }
        }

        //新增客户
        function add() {
            $('#customerForm').form('clear');
            $('#customerWindow').window({modal: true});
            $('#customerWindow').window('open');
            //当前操作方法为添加
            method = "add";

        }

        //新增客户提交
        function addsubmit() {

            //绑定添加客户保存按钮
            //alert(0);
            //var formData=getFormData('addCustomerForm');
            /* $.ajax({
                url:'../customer/add.action',
                data:formData,
                type:'post',
                dataType:'json',
                success:function(value)
                {
                    alert(value);
                    if(value.success)
                    {
                        $('#formWindow').window('close');
                        $('#grid').datagrid('reload');
                    }
                    $.messager.alert('提示',value.message);
                }
            });	 */
            $('#customerForm').form('submit', {
                url: '${pageContext.request.contextPath}/customer_add.action',
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                },
                success: function (data) {
                    var data = eval('(' + data + ')');  // 将json串转为js对象
                    if (data.success) {
                        $('#customerWindow').window('close');
                        $('#grid').datagrid('reload');
                    }
                    $.messager.alert('提示', data.message);
                }
            });
            $('#customerWindow').window(close());
        }

        //删除客户
        function del(cid) {
            $.messager.confirm("提示", "确定要删除吗？", function (value) {
                if (value) {
                    $.ajax({
                        url: '${pageContext.request.contextPath}/customer_delete.action?cid=' + cid,
                        dataType: 'json',
                        success: function (value) {
                            $.messager.alert('提示', value.message);
                            if (value.success) {
                                $('#grid').datagrid('reload');
                            }
                        }
                    });

                }
            });
        }

        /**
         * 修改 页面
         */
        function edit(custId) {
            $('#customerForm').form('clear');
            $('#customerForm').form('load', '../customer/getById.action?custId=' + custId);
            //$('#customerForm').form('load',{"baseDictByCustIndustry":{"dictEnable":"1","dictId":"2","dictItemName":"电子商务","dictSort":2,"dictTypeCode":"001","dictTypeName":"客户行业"},"baseDictByCustLevel":{"dictEnable":"1","dictId":"22","dictItemName":"普通客户","dictSort":1,"dictTypeCode":"006","dictTypeName":"客户级别"},"baseDictByCustSource":{"dictEnable":"1","dictId":"7","dictItemName":"网络营销","dictSort":2,"dictTypeCode":"002","dictTypeName":"客户信息来源"},"custId":23,"custLinkman":"王总","custMobile":"1333333","custName":"山东黑马程序员","custPhone":"32432432"});

            $('#customerForm').form('load', '../customer/getDetailById.action?custId=' + custId);
            $('#customerWindow').window({modal: true});
            $('#customerWindow').window('open');
            method = "update";

        }

        //修改客户提交
        function editsubmit() {
            //绑定修改客户保存按钮
            //alert(99);
            /* var formData=getFormData('editCustomerForm');
            $.ajax({
                url:'../customer/update.action',
                data:formData,
                type:'post',
                dataType:'json',
                success:function(value)
                {
                    alert(value);
                    if(value.success)
                    {
                        $('#editCustomerWindow').window('close');
                        $('#grid').datagrid('reload');
                    }
                    $.messager.alert('提示',value.message);
                }
            });	 */
            $('#customerForm').form('submit', {
                url: '../customer/update.action',
                onSubmit: function () {
                    // do some check
                    // return false to prevent submit;
                },
                success: function (data) {
                    var data = eval('(' + data + ')');  // 将json串转为js对象
                    if (data.success) {
                        $('#customerWindow').window('close');
                        $('#grid').datagrid('reload');
                    }
                    $.messager.alert('提示', data.message);
                }
            });
            // submit the form
            //$('#editCustomerForm').submit();

        }

        //查询
        function query() {
            var formData = getFormData('searchForm');
            $('#grid').datagrid('load', formData);
        }

        /**
         * 将表单数据封装为json
         * @param form
         * @returns
         */
        function getFormData(form) {
            var formValues = $("#" + form).serialize();

            //关于jquery的serialize方法转换空格为+号的解决方法
            formValues = formValues.replace(/\+/g, " ");   // g表示对整个字符串中符合条件的都进行替换
            var temp = decodeURIComponent(JSON.stringify(conveterParamsToJson(formValues)));
            var queryParam = JSON.parse(temp);
            return queryParam;
        }

        function conveterParamsToJson(paramsAndValues) {
            var jsonObj = {};

            var param = paramsAndValues.split("&");
            for (var i = 0; param != null && i < param.length; i++) {
                var para = param[i].split("=");
                jsonObj[para[0]] = para[1];
            }

            return jsonObj;
        }
    </script>
</head>
<body>
<div class="easyui-panel">
    <form id="searchForm">
        <table cellpadding="5">
            <tr>
                <td>客户名称：</td>
                <td><input name="custName"/></td>
                <td>客户来源：</td>
                <td><input name="custSource"/></td>
                <td>客户级别：</td>
                <td><input name="custLevel.did" class="easyui-combobox"
                           data-options="url:'${pageContext.request.contextPath}/customer_customerDict.action',textField:'dname',valueField:'did',editable:false"/>
                </td>
            </tr>
        </table>

        <button type="button" id="btnSearch" onclick="query()">查询</button>
    </form>
</div>
<table id="grid"></table>

<div id="customerWindow" class="easyui-window" title="客户信息"
     style="width: 550px;height: 300px" data-options="closed:true">
    <form id="customerForm" method="post">
        <input name="custId" type="hidden">
        <table cellpadding="5">
            <tr>
                <td>客户名称:</td>
                <td><input type="text" name="custName"/></td>
            </tr>
            <tr>
                <td>客户来源:</td>
                <td><input name="custSource"/></td>
                <td>客户级别:</td>
                <td><input name="custLevel.did" class="easyui-combobox"
                           data-options="url:'${pageContext.request.contextPath}/customer_customerDict.action',textField:'dname',valueField:'did',editable:false"/>
                </td>
            </tr>
            <tr>
                <td>固定电话:</td>
                <td><input name="custPhone"/></td>
                <td>移动电话:</td>
                <td><input name="custMobile"/></td>
            </tr>
            <tr>
                <td colspan="4">
                    <button id="customerBtn" type="button" onclick="addsubmit()">保存</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
