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
                method:'get',
                fit:true,
                fitColumns:true,
                singleSelect:true,
                columns:[[
                    {field:'username',title:'用户名',width:100},
                    {field:'realname',title:'真实姓名',width:100},
                    {field:'sex',title:'性别',width:100},
                    {field:'idNumber',title:'身份证号码',width:100},
                    {field:'address',title:'身份证地址',width:100},
                    {field:'state',title:'状态',width:100},
                    {field:'auditor',title:'审核人',width:100}
                ]]
            });
        })
    </script>
</head>
<body>
<table id="realAuthDatagrid"></table>
</body>
</html>