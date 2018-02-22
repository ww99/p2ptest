<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统数据字典目录</title>
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#systemDictionaryDatagrid").datagrid({
                url:'/systemDictionary_data',
                method:'get',
                toolbar:'#systemDictionary_toolbar',
                fit:true,
                fitColumns:true,
                singleSelect:true,
                columns:[[
                    {field:'title',title:'名称',width:100},
                    {field:'sn',title:'编码',width:100},
                ]]
            });
            $("#toSave").click(function(){
                $("#systemDictionary_form").form('clear');
                $("#systemDictionary_dialog").dialog('setTitle','添加数据字典');
                $("#systemDictionary_dialog").dialog('open');
            });
            $("#save").click(function(){
                var url = $('[name="id"]').val()?'systemDictionary_update':'systemDictionary_save';
                $("#systemDictionary_form").form('submit',{
                    url:url,
                    success:function(data){
                        var  data = JSON.parse(data);
                        if (!data){
                            $.messager.alert("温馨提示",data.msg,'error');
                            return;
                        }
                        $.messager.alert("温馨提示",data.msg,'info',function(){
                            $("#systemDictionary_dialog").dialog('close');
                            $("#systemDictionaryDatagrid").datagrid('reload');
                        });
                    }
                })
            });
            $("#cancel").click(function(){
                $("#systemDictionary_dialog").dialog('close');
            });
            $("#toUpdate").click(function(){
                var row = $("#systemDictionaryDatagrid").datagrid('getSelected');
                console.log(row);
                if(!row){
                    $.messager.alert('温馨提示','未选中一行','warning');
                    return;
                }
                $("#systemDictionary_form").form('clear');
                $("#systemDictionary_dialog").dialog('setTitle','修改');
                $("#systemDictionary_form").form('load',row);
                $("#systemDictionary_dialog").dialog('open');
            });
        })
    </script>
</head>
<body>
<div id="systemDictionary_toolbar">
    <div>
        <a id="toSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"><font color="#000000">添加数据字典</font></a>
        <a id="toUpdate" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"><font color="#000000">修改</font></a>
    </div>
</div>
<div id="systemDictionary_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="modal:true,closed:true,buttons:'#systemDictionary_diaglog_buttons'">
    <form id="systemDictionary_form" method="post" style="align-items: center">
        <input type="hidden" name="id"/>
        <div>
            <label for="name">名称:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="title"/>
        </div>
        <div>
            <label for="age">编码:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="sn"/>
        </div>
    </form>
</div>
<div id="systemDictionary_diaglog_buttons">
    <a id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
    <a id="cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>
<table id="systemDictionaryDatagrid"></table>
</body>
</html>