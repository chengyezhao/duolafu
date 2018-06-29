/**
 * Created by Zenghw on 2017/10/16.
 */
var grid_selector = "#jqGrid";
var pager_selector = "#jqGridPager";
var rowNum = 10; 			//每页显示记录数
var task = null;			//任务（新增或编辑）
var loading;
function reply(id){
    $('#myModalLabel8').text('新增系统消息');
    $("#addModal3").modal({
        keyboard : false,
        show : true,
        backdrop : "static"
    });
    $('#acceptor').val(id);
}
function saveSmsTemp2(){
    var id = $('#id8').val();
    var type = $('#type14').val();
    var title = $('#title').val();
    var content = $('#content8').val();
    var acceptor = $('#acceptor').val();
    $.ajax({
        url: "/message/add",
        cache: false,
        dataType:'json',
        data : {
            "id":id,
            "type":type,
            "title":title,
            "content": content,
            "acceptor":acceptor,
        },
        type : 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveLearnBtn').attr({ disabled: "disabled"});
        },
        success: function(result){
            if(result.flag == true){
                $.messager.alert('温馨提示',result.message);
                $("#addModal3").modal('hide');
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
//编辑对话框取消点击事件
$('#cancelSave8').click(function(){
    $("#addModal3").modal('hide');
});

//保存标题
$('#saveLearnBtn2').click(function(){
    saveSmsTemp2();
});

$(function () {
    $(window).resize(function () {
        $(grid_selector).setGridWidth($(window).width() * 0.95);
    });

    var state ="";
    if ($("#uppBacklist").length > 0) {
         state = $("#uppBacklist").val();
    }
    var phone ="";
    if ($("#phoneNumber").length > 0) {
         phone = $("#phoneNumber").val();
    }
    $(grid_selector).jqGrid({
        url: "member/queryMemberList",
        postData:{status:state,phoneNumber:phone},
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            {label: 'uid', name: 'uid', width: 40, hidden: true},
            {label: '姓名', name: 'fullname', width: 40},
            /*{label: '昵称', name: 'name', width: 100},
            {label: '用户账号', name: 'username', width: 100},*/
            {label: '手机号', name: 'phoneNumber', width: 60},
            {label: '身份证号', name: 'idCard', width: 80},
            {label: '风险等级', name: 'levelOfRisk', width: 40},
            {label: '最大可提现额', name: 'maxAmount', width: 50},
            {label: '已出账金额', name: 'billsTrueAmount', width: 50},
            {label: '未出账金额', name: 'billsFalseAmount', width: 50},
            {label: '可用金额', name: 'useAmount', width: 50 },
            {label: '提前还款', name: 'prepaymentAmount', width: 50 },
            {label: '注册时间', name: 'addtime', width: 80},
            {
                label: '实名认证', name: 'authenticationStatus', width: 50, formatter: function (cellvalue, options, cell) {
                if (cell.authenticationStatus == 2) {
                    return "已认证";
                } else if (cell.authenticationStatus == 1) {
                    return "银行卡未认证";
                } else {
                    return "未认证";
                }
            }
            },
            {
                label: '状态', name: 'status', width: 40, formatter: function (cellvalue, options, cell) {
                if (cell.status == 2) {
                    return "黑名单";
                } else {
                    return "正常";
                }
            }
            },
            {
                label: '操作', name: 'opt', width: 100, formatter: function (cellvalue, options, cell) {
                return '<button class="btn btn-info btn-sm radius" onclick=\"send('+cell.phoneNumber+')\">\n' +
                    '                                                        <i class="icon-group"></i>发送短信\n' +
                    '                                                    </button>  ' +
                    '<button class="btn btn-info btn-sm radius" onclick=\"reply('+cell.uid+')\">\n' +
                    '                                                        <i class="icon-group"></i>系统消息\n' +
                    '                                                    </button>';
            }
            },
            /*{
                label: '会员基本信息', name: 'opt', width: 150, formatter: function (cellvalue, options, cell) {
                return '<button  onclick="userinfo(' + cell.uid + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查看或修改基础信息</button>';
            }
            },
            {
                label: '银行卡信息', name: 'opt', width: 150, formatter: function (cellvalue, options, cell) {
                return '<button  onclick="bankcard(' + cell.uid + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查看或修改银行卡</button>';
            }
            },
            {
                label: '联系人信息', name: 'opt', width: 150, formatter: function (cellvalue, options, cell) {
                return '<button  onclick="linkman(' + cell.uid + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查看或修改联系人</button>';
            }
            },
            {
                label: '职业信息', name: 'opt', width: 150, formatter: function (cellvalue, options, cell) {
                return '<button  onclick="job(' + cell.uid + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查看或修改职业</button>';
            }
            },
            {
                label: '设备信息', name: 'opt', width: 150, formatter: function (cellvalue, options, cell) {
                return '<button  onclick="devices(' + cell.uid + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查看或修改设备</button>';
            }
            },*/
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
        forceFit: false, //当为ture时，调整列宽度不会改变表格的宽度。当shrinkToFit为false时，此属性会被忽略
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
    //查询点击事件
    $("#queryBtn").click(function () {
        var phone = $("#phone").val();
        var fullname = $("#fullname").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var authenticationStatus = $("#authenticationStatus").val();
        var orderStatusPay = $("#orderStatusPay").val();
        var orderNum = $("#orderNum").val();
        if (startTime > endTime) {
            $("#startTime").val(endTime);
            $("#endTime").val(startTime);
            var i = startTime;
            startTime = endTime;
            endTime = i;
        }
        $(grid_selector).jqGrid('setGridParam', {
            postData: {phoneNumber: phone, fullname: fullname, startTime: startTime, endTime: endTime,authenticationStatus:authenticationStatus,
                orderStatusPay:orderStatusPay,orderNum:orderNum},
            //search: true,
            page: 1
        }).trigger("reloadGrid");
    });


    //新增标题，弹出新增窗口
    $("#addUserBtn").click(function () {
        task = "add";
        initData();
        $('#myModalLabel').text('新增账号');
        $("#addModal").modal({
            keyboard: false,
            show: true,
            backdrop: "static"
        });
        $("#username").blur(function () {
            $.post("member/checkUserName", {username: $("#username").val()},
                function (data) {
                    if (data.flag) {
                        $('#saveUserBtn').attr({disabled: "disabled"});
                        $("#errorTip").text("登录账号已存在!");
                        $("#errorTip").show();
                    } else {
                        $('#saveUserBtn').removeAttr("disabled");
                        $("#errorTip").text("");
                        $("#errorTip").hide();
                    }
                }, "json");
        })
    });

    //编辑对话框取消点击事件
    $('#cancelSave').click(function () {
        $("#addModal").modal('hide');
    });
    $('#cancelDetailSave').click(function () {
        $("#memberDetailModal").modal('hide');
    });
    $('#cancelLinkmanSave').click(function () {
        $("#linkmanModal").modal('hide');
    });
    $('#cancelJobSave').click(function () {
        $("#jobModal").modal('hide');
    });
    $('#cancelDevicesSave').click(function () {
        $("#devicesModal").modal('hide');
    });
    //保存账号
    $('#saveUserBtn').click(function () {
        saveUser();
    });
    //保存详情
    $("#saveDetailBtn").click(function () {
        saveDetail();
    });
    //保存详情
    $("#saveLinkmanBtn").click(function () {
        saveLinkman();
    });
    $("#saveJobBtn").click(function () {
        saveJob();
    });
    $("#saveDevicesBtn").click(function () {
        saveDevices();
    });
    //修改账号，弹出修改窗
    $("#modifyUserBtn").click(function () {
        $('#saveUserBtn').removeAttr("disabled");
        $("#errorTip").text("");
        $("#errorTip").hide();
        var rows = $(grid_selector).getGridParam('selarrrow');
        if (rows == 0) {
            // $.messager.alert("温馨提示","请选择一行记录！");
            layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
            return;
        } else if (rows.length > 1) {
            // $.messager.alert("温馨提示","不能同时修改多条记录！");
            layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
            return;
        } else {
            var data = $(grid_selector).jqGrid('getRowData', rows[0]);
            task = "update";
            initData();
            $("#uid").val(data.uid);
            $("#name").val(data.name);
            $("#username").val(data.username);
            $("#password").val(data.password);
            $('#username').attr({readonly: true});
            $('#oldpasswordStr').html("<div class=\"form-group\">\n" +
                "                        <label class=\"col-sm-2 control-label\">旧密码</label>\n" +
                "                        <div class=\"col-sm-8\">\n" +
                "                            <input id=\"oldpassword\" type=\"text\" class=\"form-control\" placeholder=\"输入旧密码\"/>\n" +
                "                        </div>\n" +
                "                    </div>");
            $('#myModalLabel').text('修改账号');
            $('#newusername').text('新密码');
            $("#addModal").modal({
                keyboard: false,
                show: true,
                backdrop: "static"
            });
        }
    });


});

function removeHorizontalScrollBar() {
    $("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width", parseInt($("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width")) + 1 + "px");
    $(grid_selector).closest(".ui-jqgrid-bdiv").css("width", parseInt($(grid_selector).closest(".ui-jqgrid-bdiv").css("width")) + 1 + "px");
}


//初始化数据
function initData() {
    $('#name').val("");
    $('#username').val("");
    $('#password').val("");
    $('#oldpasswordStr').html("");
    $('#username').attr({readonly: false});
}

//todo 未合并
function saveDetail() {
    $.ajax({
        url: "member/" + task,
        cache: false,
        data: $('#detailForm').serialize(),
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveDetailBtn').attr({disabled: "disabled"});
        },
        success: function (result) {
            if (result.flag == true) {
                $.messager.alert('温馨提示', result.message);
                $("#memberDetailModal").modal('hide');
                refreshData();
            } else {
                $.messager.alert('温馨提示', result.message);
            }
        },
        complete: function () {
            $('#saveDetailBtn').removeAttr("disabled");
        },
        error: function (data) {
            console.info("error: " + data.responseText);
        }
    })
}

function saveLinkman() {
    $.ajax({
        url: "member/" + task,
        cache: false,
        data: $('#linkmanForm').serialize(),
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveLinkmanBtn').attr({disabled: "disabled"});
        },
        success: function (result) {
            if (result.flag == true) {
                $.messager.alert('温馨提示', result.message);
                $("#linkmanModal").modal('hide');
                refreshData();
            } else {
                $.messager.alert('温馨提示', result.message);
            }
        },
        complete: function () {
            $('#saveLinkmanBtn').removeAttr("disabled");
        },
        error: function (data) {
            console.info("error: " + data.responseText);
        }
    })
}

function saveJob() {
    $.ajax({
        url: "member/" + task,
        cache: false,
        data: $('#jobForm').serialize(),
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveJobBtn').attr({disabled: "disabled"});
        },
        success: function (result) {
            if (result.flag == true) {
                $.messager.alert('温馨提示', result.message);
                $("#jobModal").modal('hide');
                refreshData();
            } else {
                $.messager.alert('温馨提示', result.message);
            }
        },
        complete: function () {
            $('#saveJobBtn').removeAttr("disabled");
        },
        error: function (data) {
            console.info("error: " + data.responseText);
        }
    })
}

function saveDevices() {
    $.ajax({
        url: "member/" + task,
        cache: false,
        data: $('#devicesForm').serialize(),
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveDevicesBtn').attr({disabled: "disabled"});
        },
        success: function (result) {
            if (result.flag == true) {
                $.messager.alert('温馨提示', result.message);
                $("#devicesModal").modal('hide');
                refreshData();
            } else {
                $.messager.alert('温馨提示', result.message);
            }
        },
        complete: function () {
            $('#saveDevicesBtn').removeAttr("disabled");
        },
        error: function (data) {
            console.info("error: " + data.responseText);
        }
    })
}

/**
 * 保存账号（新增或修改）
 */
function saveUser() {
    var uid = $('#uid').val();
    var name = $('#name').val();
    var username = $('#username').val();
    var password = $('#password').val();
    var oldpassword = $('#oldpassword').val();
    $.ajax({
        url: "member/" + task,
        cache: false,
        dataType: 'json',
        data: {
            "uid": uid,
            "name": name,
            "username": username,
            "password": password,
            "oldpassword": oldpassword
        },
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveUserBtn').attr({disabled: "disabled"});
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
            $('#saveUserBtn').removeAttr("disabled");
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

$("#addressBook").click(function () {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        addressBook(data.uid);
    }
});
var grid_selector2 = "#grid-table";
var pager_selector2 = "#grid-pager";

function addressBook(id) {
    $("#bankcardDiv").html("<table id=\"grid-table\"></table>\n" +
        "<div id=\"grid-pager\"></div>\n");
    var rowNum = 10; 			//每页显示记录数
    $(grid_selector2).jqGrid({
        url: "member/addressBook?id=" + id,
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            {label: 'id', name: 'id', width: 75, hidden: true},
            {label: '姓名', name: 'name', width: 80},
            {label: '电话号码', name: 'number', width: 180},
            {label: '添加时间', name: 'upptime', width: 180},
        ],
        pager: pager_selector2,
        rowNum: rowNum,
        rowList: [10, 30, 45, 100], //可调整每页显示的记录数
        viewrecords: true,//是否显示行数
        altRows: true,  //设置表格 zebra-striped 值
        gridview: true, //加速显示
        multiselect: true,//是否支持多选
        multiselectWidth: 40, //设置多选列宽度
        multiboxonly: true,
        shrinkToFit: false, //此属性用来说明当初始化列宽度时候的计算类型，如果为ture，则按比例初始化列宽度。如果为false，则列宽度使用colModel指定的宽度
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
    $(grid_selector2).jqGrid('navGrid', pager_selector2,
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
    $("#bank").attr("style", "width:550px");
    $("#sendSMS").html("<div class=\"panel-body\" ><button class=\"btn btn-success btn-sm radius\" onclick=\"sendSMS()\">\n" +
        "                <i class=\"fa  fa-plus\"></i> 发送短信\n" +
        "            </button></div>");
    $('#myModalBankcardLabel').text('通讯录');
    $("#bankcardModal").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });


}
function send(phone) {
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
    $('#myModalLabel2').text('新增短信');
    $("#addModal2").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });
    $("#phone2").val(phone);
    $("#numbers").mouseleave(function () {
        $(".oopv").css("display","none");
    })
    $("#content").click(function(){
        $(".oopv").css("display","block");
    })
    $("#numbers").delegate('li','click',function() {
        var de = $(this).text();
        document.getElementById("content").value = de;
        $(".oopv").css("display","none");
    });
}
function sendSMS() {
    var rows = $(grid_selector2).getGridParam('selarrrow');
    var numbers="";
   for(var i = 0;i<rows.length;i++){
       var rowData = $(grid_selector2).jqGrid('getRowData',rows[i]);
       numbers+=rowData.number+",";
   }
    if (rows.length <= 0) {
        //layer.msg('至少选中一行记录！', {icon: 7, time: 2000});
        $.messager.alert("温馨提示", "至少选中一行记录!");
        return;
    }
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
        $('#myModalLabel2').text('新增短信');
        $("#addModal2").modal({
            keyboard: false,
            show: true,
            backdrop: "static"
        });
    $("#phone2").val(numbers);
    $("#numbers").mouseleave(function () {
        $(".oopv").css("display","none");
    })
    $("#content").click(function(){
        $(".oopv").css("display","block");
    })
    $("#numbers").delegate('li','click',function() {
        var de = $(this).text();
        document.getElementById("content").value = de;
        $(".oopv").css("display","none");
    });

   /* $.messager.confirm("温馨提示", "是否发送短信？", function () {
        $.ajax({
            url: "member/sendSms",
            cache: false,
            type: "post",
            data: {"ids": rows.join(",")},
            beforeSend: function () {
                //loading = layer.load("正在修改中...");
                // $('#refuseBtn').attr({ disabled: "disabled"});
            },
            success: function (result) {
                $.messager.alert(result);
            }, error: function () {
                $.messager.alert("温馨提示", "请求错误!");
            }, complete: function () {
            }
        });
    });*/
}
function sendSms(){
    var phone = $('#phone2').val();
    var content = $('#content').val();
    var name = $('#use12').val();
    $.messager.confirm("温馨提示", "是否发送短信？", function () {
        $.ajax({
            url: "sms/add",
            cache: false,
            type: "post",
            data: {
                "phone": phone,
                "content": content,
                "name": name
            },
            beforeSend: function () {
                //loading = layer.load("正在修改中...");
                // $('#refuseBtn').attr({ disabled: "disabled"});
            },
            success: function (result) {
                $.messager.alert('温馨提示', result.message);
                $("#addModal").modal('hide');
                refreshData();
            }, error: function () {
                $.messager.alert("温馨提示", "请求错误!");
            }, complete: function () {
            }
        });
    })
}
$('#cancelSave2').click(function () {
    $("#addModal2").modal('hide');
});

//保存标题
$('#saveLearnBtn').click(function () {
    sendSms();
});
function memberOrder() {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return false;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return false;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        $("#fastMenuDiv>button").val("/order?memberId=" + data.uid);
        $("#fastMenuDiv>button").attr("id", data.uid);
        $("#fullnameIn").text(data.fullname);

    }
    return true;
}

$("#userinfo").click(function () {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        userinfo(data.uid);
    }
});

$("#linkman").click(function () {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        linkman(data.uid);
    }
});

$("#job").click(function () {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        job(data.uid);
    }
});
$("#checkRisk").click(function () {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        $.post("member/alizhima", {"id": data.uid},
            function (data) {
                if (data.sesameScore == null) {
                    $.messager.alert("温馨提示", "芝麻分为:");
                } else {
                    $.messager.alert("温馨提示", "芝麻分为:" + data.sesameScore);
                }
            }, "json");
    }
});
$("#devices").click(function () {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        devices(data.uid);
    }
});

$("#bankcard").click(function () {
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else {
        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
        bankcard(data.uid);
    }
});

