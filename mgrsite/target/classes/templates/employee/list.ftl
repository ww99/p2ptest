<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工管理</title>
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div id="employee_toolbar">
    <div>
        <a id="toSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"><font color="#000000">添加</font></a>
        <a id="toUpdate" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"><font color="#000000">编辑</font></a>
    </div>
</div>
<div id="employee_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="modal:true,closed:true,buttons:'#employee_diaglog_buttons'">
<form id="emplloyee_form" method="post" style="align-items: center">
    <input type="hidden" name="id"/>
    <div>
        <label for="name">姓名:</label>
        <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="userName" data-options="required:true" />
    </div>
    <div>
        <label for="age">年龄:</label>
        <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="age"/>
    </div>
    <div>
        <label for="hireDate">入职时间:</label>
        <input class="easyui-validatebox" type="text" name="hireDate"/>
    </div>
</form>
</div>
<div id="employee_diaglog_buttons">
    <a id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
    <a id="cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>
<table id="employeeDatagrid"></table>
<script type="text/javascript">
    $('#employeeDatagrid').datagrid({
        url:'/employee/employeeList',
        method:'get',
        toolbar:'#employee_toolbar',
        fit:true,
        fitColumns:true,
        singleSelect:true,
        columns:[[
            {field:'id',title:'编号',width:450},
            {field:'userName',title:'姓名',width:450},
            {field:'age',title:'年龄',width:450},
            {field:'hireDate',title:'入职时间',width:450},
            {field:'caozuo',title:'操作',width:200,formatter: function(value,row,index){
                return '<a href="/employeeDelete?id=">删除</a>';
            }}
        ]]
    });

    //张开新增form
    $("#toSave").click(function(){
        $("#emplloyee_form").form('clear');
        $("#employee_dialog").dialog('setTitle',"新增");
        $("#employee_dialog").dialog("open");
    });
    //保存操作
    $("#save").click(function(){
        var url = $('[name="id"]').val() ? "/employee/employeeUpdate":"/employee/employeeSave";
        $("#emplloyee_form").form('submit',{
            url:url,
            success:function(data){
                var data = JSON.parse(data);
                if(!data){
                    $.messager.alert('温馨提示',data.msg,'error');
                    return;
                }
                $.messager.alert('温馨提示',data.msg,'info',function(){
                    $("#employee_dialog").dialog("close");
                    $('#employeeDatagrid').datagrid("reload");
                });
            }
        });
    });
    //关闭
    $("#cancel").click(function(){
        $("#employee_dialog").dialog("close");
    });
    //打开编辑form
    $("#toUpdate").click(function(){
        var row = $("#employeeDatagrid").datagrid('getSelected');
        if(!row){
            $.messager.alert('温馨提示','未选中一行','warning');
            return;
        }
        $("#emplloyee_form").form('clear');
        $("#employee_dialog").dialog('setTitle',"编辑");
        $("#emplloyee_form").form('load',row);
        $("#employee_dialog").dialog("open");
    });
</script>
</body>