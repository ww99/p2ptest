<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/plugins/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/plugins/jquery-easyui/base.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#index_tree").tree({
                url:'/systemMenu/indexMenu',
                onClick:function(node){
                    if (!node.text || !node.attributes || !node.attributes.url){
                        $.messager.alert("温馨提示","树菜单有问题","warning");
                        return;
                    }
                    var exist = $("#index_tabs").tabs('exists',node.text);
                    if(exist){
                        $("#index_tabs").tabs('select',node.text);
                        return;
                    }
                    $("#index_tabs").tabs('add',{
                        title:node.text,
                        closable:true,
                        content:'<iframe src="' + node.attributes.url +'" frameborder="0" style="width: 100%;height: 100%"></iframe>'
                    })
                }
            })
        })
    </script>
</head>
<body>
<div id="index_layout" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north'" style="height:70px;background:rgba(6, 8, 2, 0.79);">
        <h1 style="padding-left: 10px;"><font color="#fffaf0">后台管理系统</font></h1>
        <div style="float: right;margin-top: -25px;margin-right: 15px;">
            <a href="/logout" style="margin-top: 100%"></a>
            <font color="#8a2be2">当前用户：</font><a data-cmd="to_edit_password" href="#"><shiro:principal property="username"/></a>
        </div>
    </div>
    <div data-options="region:'south'" style="height:30px;background:rgba(6, 8, 2, 0.79);">
        <p style="text-align: center;overflow: hidden;margin-top: 0px;"><font color="#fff8dc">Copyright © 20018 - 2088 无限未来责任公司 版权所有</font></p>
    </div>



    <div data-options="region:'west'" style="width:200px;">
        <ul id="index_tree" style="padding: 5px;"></ul>
        <#--<div id="index_accordion" class="easyui-accordion" style="width:300px;height:200px;">
            <div title="菜单" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
            </div>
        </div>-->
    </div>


    <div data-options="region:'center'">
        <div id="index_tabs" class="easyui-tabs" data-options="fit:true,border:false">
            <div title="我的主页" class="mySheet">
                <font face="楷体" size="6">你是第<font face="楷体" size="8">十二个</font>,欢迎来到这里!!</font>
            </div>
        </div>
    </div>

    <#--<div id="password_diaglog_buttons">
        <a data-cmd="save" href="#" class="easyui-linkbutton btn_save" data-options="iconCls:'icon-save'">保存</a>
        <a data-cmd="cancel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</a>
    </div>-->
</div>
</body>
</html>