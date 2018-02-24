<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>视频认证</title>
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#videoAuthDatagrid").datagrid({
                method:'get',
                toolbar:'#videoAuth_toolbar',
                fit:true,
                fitColumns:true,
                singleSelect:true,
                columns:[[
                    {field:'applier',title:'用户名',width:100,formatter: function(value,row,index){
                    }},
                    {field:'realName',title:'状态',width:100},
                    {field:'sex',title:'审核人',width:100},
                    {field:'idNumber',title:'审核说明',width:100},
                    {field:'address',title:'审核时间',width:100}
                ]]
            });
            $("#addAudit").click(function(){
                $("#videoAuth_form").form('clear');
                $("#videoAuth_dialog").dialog('setTitle','添加审核');
                $("#videoAuth_dialog").dialog('open');
            });
            $("#cancel").click(function(){
                $("#videoAuth_dialog").dialog('close');
            });
        })
    </script>
</head>
<body>
<div id="videoAuth_toolbar">
    <div>
        <a id="addAudit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加审核</a>
    </div>
</div>
<table id="videoAuthDatagrid"></table>
<div id="videoAuth_diaglog_buttons">
    <button id="sure" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" value="1">审核通过</button>
    <button id="refuse" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" value="2">审核拒绝</button>
    <a id="cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>
<div id="videoAuth_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="modal:true,closed:true,buttons:'#videoAuth_diaglog_buttons'">
    <form id="videoAuth_form" method="post" style="align-items: center">
        <input type="hidden" name="id"/>
        <input id="state" type="hidden" name="state"/>
        <div>
            <label for="username">用户:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="username"/>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="id"/>
        </div>
        <div>
            <label for="remark">审核备注:</label>
            <textarea name="remark"/>
        </div>
    </form>
</div>
</body>
</html>