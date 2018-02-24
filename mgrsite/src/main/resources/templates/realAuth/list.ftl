<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>实名认证审核</title>
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script>
        $(function(){
            $("#realAuthDatagrid").datagrid({
                url:'/realAuth_data',
                method:'post',
                toolbar:'#realAuth_toolbar',
                fit:true,
                fitColumns:true,
                singleSelect:true,
                columns:[[
                    {field:'applier',title:'用户名',width:100,formatter: function(value,row,index){
                        return row.applier.username;
                    }},
                    {field:'realName',title:'真实姓名',width:100},
                    {field:'sex',title:'性别',width:100},
                    {field:'idNumber',title:'身份证号',width:100},
                    {field:'address',title:'身份证地址',width:100},
                    {field:'state',title:'状态',width:100},
                    {field:'auditor',title:'审核人',width:100,formatter: function(value,row,index){
                        if (row.auditor){
                            return row.auditor.username;
                        } else {
                            return value;
                        }

                    }}
                ]]
            });
            $("#audit").click(function(){
                var row = $("#realAuthDatagrid").datagrid('getSelected');
                if(!row){
                    $.messager.alert('温馨提示','未选中一行','warning');
                    return;
                }
                $("#realAuth_form").form('clear');
                $("#realAuth_dialog").dialog('setTitle','审核');
                $("#realAuth_form").form('load',row);
                $("#realAuth_dialog").dialog('open');
            });
            $("#cancel").click(function(){
                $("#realAuth_dialog").dialog('close');
            });
            $("#sure").click(function(){
                $("#state").val($(this).val());
                $("#realAuth_form").form('submit',{
                    url:'/audit',
                    success:function(data){
                        var data = JSON.parse(data);
                        if (!data){
                            $.messager.alert("温馨提示",data.msg,'error');
                            return;
                        }
                        $.messager.alert("温馨提示",data.msg,'info',function(){
                            $("#realAuth_dialog").dialog('close');
                            $("#realAuthDatagrid").datagrid('reload');
                        });
                    }
                });
            });

            $("#refuse").click(function(){
                $("#state").val($(this).val());
                $("#realAuth_form").form('submit',{
                    url:'/audit',
                    success:function(data){
                        var data = JSON.parse(data);
                        if (!data){
                            $.messager.alert("温馨提示",data.msg,'error');
                            return;
                        }
                        $.messager.alert("温馨提示",data.msg,'info',function(){
                            $("#realAuth_dialog").dialog('close');
                            $("#realAuthDatagrid").datagrid('reload');
                        });
                    }
                });
            });
        })
    </script>
</head>
<body>
<div id="realAuth_toolbar">
    <div>
        <a id="audit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">审核</a>
    </div>
</div>
<div id="realAuth_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="modal:true,closed:true,buttons:'#realAuth_diaglog_buttons'">
    <form id="realAuth_form" method="post" style="align-items: center">
        <input type="hidden" name="id"/>
        <input id="state" type="hidden" name="state"/>
        <div>
            <label for="username">用户名:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="username"/>
        </div>
        <div>
            <label for="realName">真实姓名:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="anonymousRealName"/>
        </div>
        <div>
            <label for="idNumber">身份证号:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="anonymousIdNumber"/>
        </div>
        <div>
            <label for="address">身份证地址:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="anonymousAddress"/>
        </div>
        <div>
            <label for="birthDate">出生日期:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="birthDate"/>
        </div>
        <div>
            <label for="remark">描述</label>
            <textarea style="margin-left: 7%" class="easyui-validatebox" name="remark"></textarea>
        </div>
    </form>
</div>
<div id="realAuth_diaglog_buttons">
    <button id="sure" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" value="1">审核通过</button>
    <button id="refuse" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" value="2">审核拒绝</button>
    <a id="cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>
<table id="realAuthDatagrid"></table>
</body>
</html>