<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统数据字典明细</title>
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#systemDictionaryItemDatagrid").datagrid({
                url:'/systemDictionaryItem_data',
                method:'get',
                fit:true,
                fitColumns:true,
                singleSelect:true,
                columns:[[
                    {field:'title',title:'名称',width:100},
                    {field:'sequence',title:'序列',width:100},
                ]]
            });
            $("#toSave").click(function(){
                $("#systemDictionaryItem_form").form('clear');
                $("#systemDictionaryItem_dialog").dialog('setTitle','添加数据字典');
                $("#systemDictionaryItem_dialog").dialog('open');
            });
            $("#save").click(function(){
                var url = $('[name="id"]').val()?'systemDictionaryItem_update':'systemDictionaryItem_save';
                $("#systemDictionaryItem_form").form('submit',{
                    url:url,
                    success:function(data){
                        var  data = JSON.parse(data);
                        if (!data){
                            $.messager.alert("温馨提示",data.msg,'error');
                            return;
                        }
                        $.messager.alert("温馨提示",data.msg,'info',function(){
                            $("#systemDictionaryItem_dialog").dialog('close');
                            $("#systemDictionaryItemDatagrid").datagrid('reload');
                        });
                    }
                })
            });
            $("#cancel").click(function(){
                $("#systemDictionaryItem_dialog").dialog('close');
            });
            $("#toUpdate").click(function(){
                var row = $("#systemDictionaryItemDatagrid").datagrid('getSelected');
                console.log(row);
                $("#editFormParentId").val(row.parentId);
                if(!row){
                    $.messager.alert('温馨提示','未选中一行','warning');
                    return;
                }
                $("#systemDictionaryItem_form").form('clear');
                $("#systemDictionaryItem_dialog").dialog('setTitle','修改');
                $("#systemDictionaryItem_form").form('load',row);
                $("#systemDictionaryItem_dialog").dialog('open');
            });

            $("#search").click(function(){
                $("#systemDictionaryItemDatagrid").datagrid('load', {
                    'parentId' : $('input[name="parentId"]').val()
                });
            });

        })
    </script>
</head>
<body>
<div id="systemDictionary_toolbar">
    <div>
        <a id="toSave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"><font color="#000000">添加数据字典明细</font></a>
        <a id="toUpdate" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"><font color="#000000">修改</font></a>
    </div>
    <div>
        数据字典目录:<input id="systemDictionary" name="parentId" class="easyui-combobox" panelHeight="auto"
                                                 data-options="multiple:true, valueField:'id',textField:'title',panelHeight:'auto',url:'/selectParentId'"/>
        <a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
    </div>
</div>
<div id="systemDictionaryItem_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="modal:true,closed:true,buttons:'#systemDictionaryItem_diaglog_buttons'">
    <form id="systemDictionaryItem_form" method="post" style="align-items: center">
        <input type="hidden" name="id"/>
        <input type="hidden" id="editFormParentId" name="parentId" value="" />
        <div>
            <label for="title">名称:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="title"/>
        </div>
        <div>
            <label for="sequence">序列:</label>
            <input style="margin-left: 7%" class="easyui-validatebox" type="text" name="sequence"/>
        </div>
    </form>
</div>
<div id="systemDictionaryItem_diaglog_buttons">
    <a id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
    <a id="cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
</div>
<table id="systemDictionaryItemDatagrid"></table>
</body>
</html>