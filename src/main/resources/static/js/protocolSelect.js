/**
 * Created by zhw on 2017/8/1.
 */
var grid_selector = "#jqGrid";
var pager_selector = "#jqGridPager";
var rowNum = 10; 			//每页显示记录数
var task = null;			//任务（新增或编辑）
var loading;
function repeat(id) {
  /*  window.open('/protocol/userProtocol?id='+id);*/
    $.ajax({
        url: "protocol/userProtocol",
        cache: false,
        type: "post",
        data: {"id":id},
        success:function (msg) {
            if (msg!=null){
                msg.replace("\"","\'");
                /*var pattern = "\\n";
                msg = msg.replace(new RegExp(pattern,"g"),"");*/
                var startText = msg.indexOf("<body>");
                var endText = msg.indexOf("</body>");
                var msgNew = msg.substring(startText+6,endText);
                $('#myModalLabel').text('合同详情');
                $("#addModal").modal({
                    keyboard: false,
                    show: true,
                    backdrop: "static"
                });
                $("#div2").html(msgNew);
                var E = window.wangEditor;
                var editor = new E('#div2');
                editor.create();
            }
        }
    })
}
$(function () {
    $(window).resize(function () {
        $(grid_selector).setGridWidth($(window).width() * 0.95);
    });
    $(grid_selector).jqGrid({
        url: "protocol/selectList",
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            { label: 'id', name: 'id', width: 75, hidden: true},
            { label: '姓名', name: 'fullname', width: 100 },
            { label: '创建时间', name: 'createtime', width: 100 },
            { label: '身份证号码', name: 'idCard', width:100 },
            { label: 'ip', name: 'ip', width: 100, },
            { label: '合同详情', width:100 ,formatter: function (cellvalue, options, cell) {
                return '<button  onclick="repeat('+cell.id+')" style="margin-left: 10px" class="btn btn-danger btn-sm btn-label-left radius" >查看</button>'
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
            repeatitems: false //指明每行的数据是可以重复的，如果设为false，s，这个名字就是colModel中的名字
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


    //查询点击事件
    $("#queryBtn").click(function () {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var idCard = $("#idCard").val();
        $(grid_selector).jqGrid('setGridParam', {
            postData: {startTime: startTime, endTime: endTime,idCard:idCard},
            //search: true,
            page: 1
        }).trigger("reloadGrid");
    });

   /* //新增标题，弹出新增窗口
    $("#addSmsBtn").click(function () {
        $.ajax({
            url: "sms/adds",
            cache: false,
            type: "post",
            data: {},
            success: function (result) {
                if (result) {
                    var str="";
                    for (var i = 0; i < result.length; i++) {
                        str += "<li class='ss'>"+result[i].content+"</li>"
                    }
                    $("#numbers").html(str);
                }
            }
        });
        task = "add";
        initData();
        $('#myModalLabel').text('新增短信');
        $("#addModal").modal({
            keyboard: false,
            show: true,
            backdrop: "static"
        });

    });*/
 /* $("#numbers").mouseleave(function () {
      $(".oopv").css("display","none");
  })
    $("#content").click(function(){
        $(".oopv").css("display","block");
    })
    $("#numbers").delegate('li','click',function() {
        var de = $(this).text();
        document.getElementById("content").value = de;
            $(".oopv").css("display","none");
    });*/
   /* //编辑对话框取消点击事件
    $('#cancelSave').click(function () {
        $("#addModal").modal('hide');
    });*/

    /*//保存标题
    $('#saveLearnBtn').click(function () {
        saveSms();
    });*/

    //删除标题方法 选择多个的话，行id用逗号隔开比如 3,4
    /*$("#deleteSmsBtn").click(function () {
        var ids = "";
        console.log(111);
        var rows = $(grid_selector).getGridParam('selarrrow');
        rows.forEach(function (item, index) {
            ids += $(grid_selector).jqGrid('getRowData', rows[index]).sid + ",";
        });
        if (rows.length > 0) {
            $.messager.confirm("温馨提示", "是否确定删除所选记录？", function () {
                $.ajax({
                    url: "sms/delete",
                    cache: false,
                    type: "post",
                    data: {"ids": ids},
                    beforeSend: function () {
                        loading = layer.load("正在删除中...");
                    },
                    success: function (result) {
                        $.messager.alert(result.message);
                        refreshData();
                    }, error: function () {
                        $.messager.alert("温馨提示", "请求错误!");
                    },
                    complete: function () {
                        layer.close(loading);
                    }
                });
            });
        } else {
            //两种风格的提示,layer或者messager自己选择一种用即可。
            // $.messager.alert("温馨提示","至少选择一行记录！");
            layer.msg('至少选中一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        }
    })*/

})

function removeHorizontalScrollBar() {
    $("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width", parseInt($("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width")) + 1 + "px");
    $(grid_selector).closest(".ui-jqgrid-bdiv").css("width", parseInt($(grid_selector).closest(".ui-jqgrid-bdiv").css("width")) + 1 + "px");
}


//初始化数据
function initData() {
    $('#fullname').val("");
    $('#createTime').val("");
    $('#idCard').val("");
    $('#ip').val("");
}

/*/!**
 * 保存标题（新增或修改）
 *!/
function saveSms() {
    var sid = $('#sid').val();
    var phone = $('#phone').val();
    var content = $('#content').val();
    var name = $('#use12').val();
    $.ajax({
        url: "sms/" + task,
        cache: false,
        dataType: 'json',
        data: {
            "sid": sid,
            "phone": phone,
            "content": content,
            "name": name
        },
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveLearnBtn').attr({ disabled: "disabled"});
        },
        success: function (result) {
            if (result.flag == true) {
                $.messager.alert('温馨提示', result.message);
                $("#addModal").modal('hide');
                refreshData();
            } else {
                $.messager.alert('温馨提示', result.message);
            }
        },
        complete: function () {
            $('#saveLearnBtn').removeAttr("disabled");
        },
        error: function (data) {
            console.info("error: " + data.responseText);
        }
    });
}*/

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
