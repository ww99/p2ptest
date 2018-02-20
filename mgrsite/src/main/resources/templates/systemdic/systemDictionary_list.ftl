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
                fit:true,
                fitColumns:true,
                singleSelect:true,
                columns:[[
                    {field:'title',title:'名称',width:100},
                    {field:'sn',title:'编码',width:100},
                ]]
            });
        })
    </script>
</head>
<body>
<table id="systemDictionaryDatagrid"></table>
</body>
</html>