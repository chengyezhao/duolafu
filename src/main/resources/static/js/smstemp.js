    var grid_selector = "#jqGrid";
    var pager_selector = "#jqGridPager";
    var rowNum = 10; 			//每页显示记录数
    var task = null;			//任务（新增或编辑）
    var loading;
    $(function () {
        $(window).resize(function () {
            $(grid_selector).setGridWidth($(window).width() * 0.95);
        });

        $(grid_selector).jqGrid({
            url: "smstemp/querySmsTempList",
            datatype: "json",
            mtype: 'POST',
            height: window.screen.height - 550,
            colModel: [
                { label: 'id', name: 'id', width: 75, hidden: true},
                { label: '模版类型', name: 'templatetype', width: 60},
                { label: '触发条件', name: 'touch', width: 100 /*,formatter: function (cellvalue, options, cell) {
                    var stateStr = "发送成功";
                    if (cell.touch.equals("pass")) {
                        stateStr = "通过";
                    } else {
                        stateStr = "未通过";
                    }
                    return stateStr;
                }*/},
                { label: '短信内容', name: 'content', width: 520 },
                { label: '说明', name: 'instruction', width: 100 },
                { label: '发送通道', name: 'name', width: 60},
                { label: '是否有效', name: 'opt', width: 60, formatter: function (cellvalue, options, cell) {
                    var stateStr = "发送成功";
                    if (cell.enable == 0) {
                        stateStr = "有效";
                    } else {
                        stateStr = "无效";
                    }
                    return stateStr;
                }}
        ],
            pager: pager_selector,
            rowNum: rowNum,
            rowList: [10, 30, 45, 100], //可调整每页显示的记录数
            viewrecords: true,//是否显示行数
            altRows: true,  //设置表格 zebra-striped 值
            gridview: true, //加速显示
            multiselect: true,//是否支持多选
            multiselectWidth: 40, //设置多选列宽度
            multiboxonly: true,
            shrinkToFit: true, //此属性用来说明当初始化列宽度时候的计算类型，如果为ture，则按比例初始化列宽度。如果为false，则列宽度使用colModel指定的宽度
            forceFit: true, //当为ture时，调整列宽度不会改变表格的宽度。当shrinkToFit为false时，此属性会被忽略
            autowidth: true,
            loadComplete: function () {
                var table = this;
                setTimeout(function () {
                    updatePagerIcons(table);
                }, 0);
            },
            gridComplete: function () {
                // 防止水平方向上出现滚动条
                removeHorizontalScrollBar();
            },
            jsonReader: {//jsonReader来跟服务器端返回的数据做对应
                root: "rows",   //包含实际数据的数组
                total: "total", //总页数
                records: "records", //查询出的总记录数
                repeatitems: false //指明每行的数据是可以重复的，如果设为false，则会从返回的数据中按名字来搜索元素，这个名字就是colModel中的名字
            },
            emptyrecords: '没有记录!',
            loadtext: '正在查询服务器数据...'
        });

        //设置分页按钮组
        $(grid_selector).jqGrid('navGrid', pager_selector,
            {
                edit: false,
                // edittitle:'修改',
                // edittext:'修改',
                // editicon : 'icon-pencil blue',
                // editfunc :editUser,
                add: false,
                // addtitle:'新增',
                // addtext:'新增',
                // addicon : 'icon-plus-sign purple',
                // addfunc :addUser,
                del: false,
                // deltitle:'删除',
                // deltext:'删除',
                // delicon : 'icon-trash red',
                // delfunc:delUser,
                refresh: true,
                refreshicon: 'icon-refresh green',
                beforeRefresh: refreshData,
                search: false,
                view: false,
                alertcap: "警告",
                alerttext: "请选择需要操作的用户!"
            }
        );
    //新增标题，弹出新增窗口
    $("#addSmstemplateBtn").click(function () {
        $.ajax({
            url: "smstemp/adds",
            cache: false,
            type: "post",
            data: {},
            success: function (result) {
                console.log(result);
                if (result) {
                    var str="";
                    for (var i = 0; i < result.length; i++) {
                        str += "<li class='ss'>"+result[i].touch+"</li>"
                    }
                    console.log(str);
                    $("#touchs").html(str);
                }
            }
        });
        task = "add";
        initData();
        $('#myModalLabel').text('新增短信模版');
        $("#addModal").modal({
            keyboard : false,
            show : true,
            backdrop : "static"
        });

    });
        $("#touchs").mouseleave(function () {
            $(".oopv").css("display","none");
        })
        $("#touch").click(function(){
            $(".oopv").css("display","block");
        })
        $("#touchs").delegate('li','click',function() {
            var de = $(this).text();
            document.getElementById("touch").value = de;
            $(".oopv").css("display","none");
        });
    //编辑对话框取消点击事件
    $('#cancelSave').click(function(){
        $("#addModal").modal('hide');
    });

    //保存标题
    $('#saveLearnBtn').click(function(){
        saveSmsTemp();
    });

    //修改标题，弹出修改窗
    $("#modifySmstemplateBtn").click(function () {
        var rows=$(grid_selector).getGridParam('selarrrow');
        if(rows==0){
            // $.messager.alert("温馨提示","请选择一行记录！");
            layer.msg('请选择一行记录！', {icon: 7,time: 2000}); //2秒关闭（如果不配置，默认是3秒）
            return;
        }else if(rows.length>1){
            // $.messager.alert("温馨提示","不能同时修改多条记录！");
            layer.msg('不能同时修改多条记录！', {icon: 7,time: 2000}); //2秒关闭（如果不配置，默认是3秒）
            return;
        }else{
            var data = $(grid_selector).jqGrid('getRowData', rows[0]);
            task = "update";
            initData();
            $("#id").val(data.id);
            $("#type12").val(data.templatetype);
            $("#touch").val(data.touch);
            $("#content").val(data.content);
            //$("#enable12").val(data.enable);
            $("#instruction").val(data.instruction);
            $("#name12").val(data.name);
            $('#myModalLabel').text('修改短信模版');
            $("#addModal").modal({
                keyboard : false,
                show : true,
                backdrop : "static"
            });
        }
    });

    //删除短信模板方法 选择多个的话，行id用逗号隔开比如 3,4
    $("#deleteSmstemplateBtn").click(function () {
        var ids = "";
        var rows=$(grid_selector).getGridParam('selarrrow');
        rows.forEach(function (item, index) {
            ids += $(grid_selector).jqGrid('getRowData', rows[index]).id + ",";
        });
        if(rows.length>0){
            $.messager.confirm("温馨提示", "是否确定删除所选记录？", function() {
                $.ajax({
                    url:"smstemp/delete",
                    cache: false,
                    type:"post",
                    data:{"ids": ids},
                    beforeSend : function(){
                        loading=layer.load("正在删除中...");
                    },
                    success:function(result){
                        $.messager.alert(result.message);
                        refreshData();
                    },error:function(){
                        $.messager.alert("温馨提示","请求错误!");
                    },
                    complete : function(){
                        layer.close(loading);
                    }
                });
            });
        }else{
            //两种风格的提示,layer或者messager自己选择一种用即可。
            // $.messager.alert("温馨提示","至少选择一行记录！");
            layer.msg('至少选中一行记录！', {icon: 7,time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        }
    })

});

function removeHorizontalScrollBar() {
    $("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width", parseInt($("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width")) + 1 + "px");
    $(grid_selector).closest(".ui-jqgrid-bdiv").css("width", parseInt($(grid_selector).closest(".ui-jqgrid-bdiv").css("width")) + 1 + "px");
}


//初始化数据
function initData() {
    $('#id').val("");
    $('#templatetype').val("");
    $('#touch').val("");
    $('#content').val("");
    $('#instruction').val("");
    $('#name').val("");
    $('#enable').val("");
}

/**
 * 保存标题（新增或修改）
 */
function saveSmsTemp(){
    var id = $('#id').val();
    var templatetype = $('#type12').val();
    var touch = $('#touch').val();
    var content = $('#content').val();
    var instruction = $('#instruction').val();
    var name = $('#name12').val();
    var enable = $('#enable12').val();
    $.ajax({
        url: "smstemp/"+task,
        cache: false,
        dataType:'json',
        data : {
            "id":id,
            "templatetype":templatetype,
            "touch":touch,
            "content": content,
            "instruction": instruction,
            "name": name,
            "enable": enable
        },
        type : 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveLearnBtn').attr({ disabled: "disabled"});
        },
        success: function(result){
            if(result.flag == true){
                $.messager.alert('温馨提示',result.message);
                $("#addModal").modal('hide');
                refreshData();
            }else{
                $.messager.alert('温馨提示',result.message);
            }
        },
        complete: function () {
            $('#saveLearnBtn').removeAttr("disabled");
        },
        error: function (data) {
            console.info("error: " + data.responseText);
        }
    });
}

function refreshData() {
    $(grid_selector).jqGrid('setGridParam', {
        postData: {author: null, title: null},
        page: 1
    }).trigger("reloadGrid");
}


//这个是分页图标，必须添加
function updatePagerIcons(table) {
    var replacement =
    {
        'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
        'ui-icon-seek-prev': 'icon-angle-left bigger-140',
        'ui-icon-seek-next': 'icon-angle-right bigger-140',
        'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
        console.info($class);
        if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
    });
}
