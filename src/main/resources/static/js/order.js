
/**
 * Created by Zenghw on 2017/10/16.
 */
var grid_selector = "#jqGrid";
var pager_selector = "#jqGridPager";
var rowNum = 10; 			//每页显示记录数
var task = null;			//任务（新增或编辑）
var loading;

$(function () {
    $(window).resize(function () {
        $(grid_selector).setGridWidth($(window).width() * 0.95);
    });
    var status = $("#orderStatus").val();
    var memberId = $("#memberId").val();
    $(grid_selector).jqGrid({
        url: "order/list?orderStatus=" + status + "&memberId=" + memberId,
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            {label: 'id', name: 'id', width: 75, hidden: true},
            {label: '申请编号', name: 'orderNumber', width: 100},
            {label: '申请时间', name: 'orderCreateTime', width: 100},
            {label: '借款金额', name: 'orderAmount', width: 100},
            {label: '可用额度', name: 'useAmount', width: 100},
            {
                label: '申请人', name: 'username', width: 100, formatter: function (cellvalue, options, cell) {
               // return '<a value="/member?phoneNumber=' + cell.username + '" id="' + cell.memberId + '" class="phone" name="' + cell.username + '"style="cursor: pointer">' + cell.username + '</a>';
                return '<a onclick="queryMemberList('+cell.id+')">' + cell.username + '</a>';
                }
            },
            {label: '产品id', name: 'goodsId', width: 100},
            {label: '产品码', name: 'orderCode', width: 100},
            {
                label: '订单状态', name: 'orderStatus', width: 100, formatter: function (cellvalue, options, cell) {
                var str = "";
                switch (cell.orderStatus) {
                    case 0:
                        str = "未提交";
                        break;
                    case 1:
                        str = "已提交待审批";
                        break;
                    case 2:
                        str = "审批通过";
                        break;
                    case 3:
                        str = "审批拒绝";
                        break;
                    case 4:
                        str = "订单关闭";
                        break;
                    case 5:
                        str = "待放款";
                        break;
                    case 6:
                        str = "放款中";
                        break;
                    case 7:
                        str = "已放款";
                        break;
                    case 8:
                        str = "放款失败";
                        break;
                    case 9:
                        str = "订单中止";
                        break;
                    case 10:
                        str = "已结清";
                        break;
                }
                if (cell.orderTypes == 2) {
                    str += "<span style='color:red'> 用户隐藏</span>"
                } else if (cell.orderTypes == 1) {
                    str = "已逾期"
                }
                return str;
            }
            },
            {label: '审核人', name: 'orderAuditor', width: 100},
            {label: '审核时间', name: 'orderUpptime', width: 100},
            {label: '审核金额', name: 'orderVerifyAmount', width: 100},
            {label: '申请失败原因', id: 'orderAuditFailMsg', name: 'orderAuditFailMsg', width: 100, hidden: true},
            {
                label: '操作', name: 'opt', width: 500, title:false,formatter: function (cellvalue, options, cell) {
                if (cell.orderTypes == 0 || cell.orderTypes == 2) {
                    if (cell.orderStatus == 2 || cell.orderStatus == 3) {
                        var str = cell.orderStatus == 2 ? "拒绝" : "通过";
                        var classStr = cell.orderStatus == 2 ? "btn-danger" : "btn-primary";
                        var istr = cell.orderStatus == 2 ? "fa-trash-o fa-lg" : "fa-pencil-square-o";
                        return "<button class=\"btn " + classStr + " btn-sm radius\"  onclick=\"refuseBtn(" + cell.id + "," + status + ")\">\n" +
                            "                                            <i class=\"fa " + istr + "\"></i>" + str + "\n" +
                            "                                        </button>";
                    }
                    if (cell.orderStatus == 6) {
                        return "<button class=\"btn btn-primary btn-sm radius\" onclick=\"checkOrderStatus(" + cell.id + "," + status + ")\">\n" +
                            "                                            <i class=\"fa fa-pencil-square-o\"></i> 检查订单状态\n" +
                            "                                        </button>";
                    }
                    if (cell.orderStatus == 7 || cell.orderStatus == 10) {
                        var str = '<button  onclick="repaymentPlan(' + cell.id + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>计划</button> ' +
                            '<button class="btn btn-primary" onclick="repayment(' + cell.id + ')"><i class="icon-beaker align-top bigger-125"></i>详情</button>&nbsp;';
                        if (cell.orderStatus == 7) {
                            str += '&nbsp;<button class="btn btn-info btn-sm radius" onclick="$.messager.alert(\'施工中\');">\n' +
                                '                                                        <i class="icon-group"></i>减免\n' +
                                '                                                    </button>&nbsp;' +
                                '<button class="btn btn-info btn-sm radius" onclick=\"send('+cell.username+')\">\n' +
                                '                                                        <i class="icon-group"></i>短信\n' +
                                '                                                    </button>';
                        }
                        return str;

                    }
                    if (cell.orderStatus == 8) {
                        return "<button class=\"btn btn-primary btn-sm radius\" onclick=\"loan(" + cell.id + ")\">\n" +
                            "                                            <i class=\"fa fa-pencil-square-o\"></i> 重新放款\n" +
                            "                                        </button>";
                    }
                    if (cell.orderStatus == 5) {
                        return '<button  onclick="loan(' + cell.id + ');" class="btn btn-info btn-sm btn-label-left radius" ><i class="glyphicon glyphicon-yen" aria-hidden="true"></i>放款</button>' +
                            "  <button class=\"btn btn-danger btn-sm radius\"  onclick=\"refuseBtn(" + cell.id + ",2)\">\n" +
                            "                                            <i class=\"fa fa-trash-o fa-lg\"></i> 拒绝\n" +
                            "                                        </button>"+
                            "  <button class=\"btn btn-primary dropdown-toggle radius\"  onclick=\"copyLink(" + cell.id + ")\">\n" +
                            "                                            <i class=\"fa fa-trash-o fa-lg\"></i> 京东代付链接\n" +
                            "                                        </button>"+
                            "  <button class=\"btn btn-primary btn-sm radius\"  onclick=\"businessContract(" + cell.memberId + ")\">\n" +
                            "                                            <i class=\"fa fa-pencil-square-o\"></i> 业务往来\n" +
                            "                                        </button>";
                    }
                } else if (cell.orderTypes == 1) {
                    return "<button class=\"btn btn-warning btn-sm radius\" onclick=\"collection(" + cell.id + "," + cell.orderTypes + ")\">\n" +
                        "                                            <i class=\"icon-group\"></i> 催收\n" +
                        "                                        </button>&nbsp;" + '&nbsp;<button  onclick="repaymentPlan(' + cell.id + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>计划</button> ' +
                        '<button class="btn btn-primary" onclick="repayment(' + cell.id + ')" ><i class="icon-beaker align-top bigger-125"></i>详情</button> ' +
                        '<button class="btn btn-info btn-sm radius" onclick="$.messager.alert(\'施工中\');">\n' +
                        '                                                        <i class="icon-group"></i>减免\n' +
                        '                                                    </button> ' +
                        '<button class="btn btn-info btn-sm radius" onclick=\"send('+cell.username+')\">\n' +
                        '                                                        <i class="icon-group"></i>短信\n' +
                        '                                                    </button> ' +
                        '<button class="btn btn-warning btn-sm radius"\n' +
                        '         onclick="controller(' + cell.id + ');">\n' +
                        '           <i class="icon-group"></i>入催\n' +
                        '            </button>';
                }
                return " ";
            }
            },
            /*  {label: '注释', name: 'orderAnnotate', width: 100},
              {label: '是否显示给用户', name: 'orderIsShow', width: 100},*/
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
    if (status == 3) {
        $(grid_selector).jqGrid("showCol", "orderAuditFailMsg");
    }
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
        var username = $("#username").val();
        var minApplyForTime = $("#minApplyForTime").val();
        var maxApplyForTime = $("#maxApplyForTime").val();
        var minApplyForAmount = $("#minApplyForAmount").val();
        var maxApplyForAmount = $("#maxApplyForAmount").val();
        var goodsId = $("#goodsId").val();
        var minAuditTime = $("#minAuditTime").val();
        var maxAuditTime = $("#maxAuditTime").val();
        var minAuditAmount = $("#minAuditAmount").val();
        var maxAuditAmount = $("#maxAuditAmount").val();
        if (minApplyForTime > maxApplyForTime) {
            $("#minApplyForTime").val(maxApplyForTime);
            $("#maxApplyForTime").val(minApplyForTime);
            var i = minApplyForTime;
            minApplyForTime = maxApplyForTime;
            maxApplyForTime = i;
        }
        if (minAuditTime > maxAuditTime) {
            $("#minAuditTime").val(maxAuditTime);
            $("#maxAuditTime").val(minAuditTime);
            var i = minAuditTime;
            minAuditTime = maxAuditTime;
            maxAuditTime = i;
        }
        $(grid_selector).jqGrid('setGridParam', {
            postData: {
                username: username, goodsId: goodsId, minApplyForTime: minApplyForTime, maxApplyForTime: maxApplyForTime
                , minApplyForAmount: minApplyForAmount, maxApplyForAmount: maxApplyForAmount
                , minAuditTime: minAuditTime, maxAuditTime: maxAuditTime
                , minAuditAmount: minAuditAmount, maxAuditAmount: maxAuditAmount
            },
            //search: true,
            page: 1
        }).trigger("reloadGrid");
    });


    function removeHorizontalScrollBar() {
        $("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width", parseInt($("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width")) + 1 + "px");
        $(grid_selector).closest(".ui-jqgrid-bdiv").css("width", parseInt($(grid_selector).closest(".ui-jqgrid-bdiv").css("width")) + 1 + "px");
    }


//初始化数据
    function initData() {
        $("#username").val("");
        $("#minApplyForTime").val("");
        $("#maxApplyForTime").val("");
        $("#minApplyForAmount").val("");
        $("#maxApplyForAmount").val("");
        $("#goodsId").val("");
        $("#minAuditTime").val("");
        $("#maxAuditTime").val("");
        $("#minAuditAmount").val("");
        $("#maxAuditAmount").val("");
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

});
function queryMemberList(id){
    $.ajax({
        url: "member/queryMemberList",
        cache: false,
        type: "post",
        data: {"orderId":id},
        success: function (result) {
            var rows = result.rows;
            $("#uid").val(rows[0].uid);
            $("#fullname").val(rows[0].fullname);
            $("#phoneNumber2").val(rows[0].phoneNumber);
            $("#idCard").val(rows[0].idCard);
            $("#levelOfRisk").val(rows[0].levelOfRisk);
            $("#maxAmount").val(rows[0].maxAmount);
            $("#useAmount").val(rows[0].useAmount);
            $("#billsTrueAmount").val(rows[0].billsTrueAmount);
            $("#billsFalseAmount").val(rows[0].billsFalseAmount);
            $("#addtime").val(rows[0].addtime);
            var authenticationStatus = "";
            if(rows[0].authenticationStatus==2){
                authenticationStatus = "已认证";
            } else {
                authenticationStatus = "未认证";
            }
            $("#authenticationStatus").val(authenticationStatus);
            var status = "";
            if(rows[0].status==2){
                status = "黑名单";
            } else {
                status = "正常";
            }
            $("#status2").val(status);
        }
    });
    $('#myModalMemberDetailLabel').text('用户详情');
    $("#memberDetailModal").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    })
}
var grid_selector2 = "#grid-table";
var pager_selector2 = "#grid-pager";

function businessContract(memberId) {
    $("#jdGoodsDiv").html("<table id=\"grid-table\"></table>\n" +
        "<div id=\"grid-pager\"></div>\n");
    var rowNum = 10; 			//每页显示记录数
    $(grid_selector2).jqGrid({
        url: "order/queryGoodsOrder?memberId=" + memberId,
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            {label: '订单Id', name: 'id', width: 75},
            {label: '订单状态', name: 'orderStatus', width: 80,formatter: function (cellvalue, options, cell) {
                var str = "";
                switch (cell.orderStatus) {
                    case 0:
                        str = "未提交";
                        break;
                    case 1:
                        str = "已提交待审批";
                        break;
                    case 2:
                        str = "审批通过";
                        break;
                    case 3:
                        str = "审批拒绝";
                        break;
                    case 4:
                        str = "订单关闭";
                        break;
                    case 5:
                        str = "待放款";
                        break;
                    case 6:
                        str = "放款中";
                        break;
                    case 7:
                        str = "已放款";
                        break;
                    case 8:
                        str = "放款失败";
                        break;
                    case 9:
                        str = "订单中止";
                        break;
                    case 10:
                        str = "已结清";
                        break;
                }
                if (cell.orderTypes == 2) {
                    str += "<span style='color:red'> 用户隐藏</span>"
                } else if (cell.orderTypes == 1) {
                    str = "已逾期"
                }
                return str;
            }
            },
            {label: '订单金额', name: 'orderVerifyAmount', width: 80},
            {label: '订单申请时间', name: 'orderCreateTime', width: 180},
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
               // updatePagerIcons(table);
            }, 0);
        },
       /* gridComplete: function () {
            // 防止水平方向上出现滚动条
            removeHorizontalScrollBar();
        },*/
        jsonReader: {//jsonReader来跟服务器端返回的数据做对应
            root: "rows",   //包含实际数据的数组
            total: "total", //总页数
            records: "records", //查询出的总记录数
            repeatitems: false //指明每行的数据是可以重复的，如果设为false，则会从返回的数据中按名字来搜索元素，这个名字就是colModel中的名字
        },
        emptyrecords: '没有记录!',
     //   loadtext: '正在查询服务器数据...'
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
    $('#myjdGoodsLabel').text('历史订单');
    $("#jdGoodsModal").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });
}


function sends() {
    var rows = $(grid_selector).getGridParam('selarrrow');
    var numbers = "";
    for (var i = 0; i < rows.length; i++) {
        var rowData = $(grid_selector).jqGrid('getRowData', rows[i]);
        console.log(rowData);
        numbers += rowData.username;
     //   Regex re = new Regex("<a[^>]*>|</a>$");
        var reStripTagA = /<\/?a.*?>/g;
        numbers = numbers.replace(reStripTagA,"")+",";
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
                var str = "";
                for (var i = 0; i < result.length; i++) {
                    str += "<li class='ss'>" + result[i].content + "</li>"
                }
                $("#numbers").html(str);
            }
        }
    });
    $('#myModalLabel3').text('新增短信');
    $("#addModal3").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });
    $("#phone2").val(numbers);
    $("#numbers").mouseleave(function () {
        $(".oopv").css("display", "none");
    })
    $("#content").click(function () {
        $(".oopv").css("display", "block");
    })
    $("#numbers").delegate('li', 'click', function () {
        var de = $(this).text();
        document.getElementById("content").value = de;
        $(".oopv").css("display", "none");
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
    $('#myModalLabel3').text('新增短信');
    $("#addModal3").modal({
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
    $("#addModal3").modal('hide');
});

//保存标题
$('#saveLearnBtn').click(function () {
    sendSms();
});
function refreshData() {
    $(grid_selector).jqGrid('setGridParam', {
        postData: {
            username: null, goodsId: null, minApplyForTime: null, maxApplyForTime: null
            , minApplyForAmount: null, maxApplyForAmount: null
            , minAuditTime: null, maxAuditTime: null
            , minAuditAmount: null, maxAuditAmount: null
        },
        page: 1
    }).trigger("reloadGrid");
}

//选择多个的话，行id用逗号隔开比如 3,4
//通过或者拒绝按钮
function updateStatus(orderId, status) {
    var rows = orderId;
    if (orderId == null || orderId == '') {
        rows = $(grid_selector).getGridParam('selarrrow');
        if (rows.length <= 0) {
            layer.msg('至少选中一行记录！', {icon: 7, time: 2000});
            return;
        }
        rows = rows.join(",");
    }
    $.messager.confirm("温馨提示", "是否改变该订单状态？", function () {
        $.ajax({
            url: "order/upp",
            cache: false,
            type: "post",
            data: {"orderId": rows, "status": status}, /*{"orderId": orderId, "status": status},*/
            beforeSend: function () {
                //loading = layer.load("正在修改中...");
                // $('#refuseBtn').attr({ disabled: "disabled"});
            },
            success: function (result) {
                $.messager.alert(result.message);
                refreshData();
            }, error: function () {
                $.messager.alert("温馨提示", "请求错误!");
            }, complete: function () {
                //$('#refuseBtn').removeAttr("disabled");
                //layer.close(loading);
            }
        });
    });
}

//打款
function loanBatch(orderId) {
    var rows = orderId;
    if (orderId == null || orderId == '') {
        rows = $(grid_selector).getGridParam('selarrrow');
        if (rows.length <= 0) {
            layer.msg('至少选中一行记录！', {icon: 7, time: 2000});
            return;
        }
        rows = rows.join(",");
    }
    $.messager.confirm("温馨提示", "是否为选中放款？", function () {
        $.ajax({
            url: "/loaning/doLoan",
            data: {"orderId": rows},
            cache: false,
            type: "post",
            beforeSend: function () {
                //loading = layer.load("正在修改中...");
                // $('#refuseBtn').attr({ disabled: "disabled"});
            },
            success: function (msg) {
                console.log(msg);
                var msg_str = "";
                if (1 == msg.flag) {
                    msg_str = "放款成功"
                } else {
                    msg_str = "放款失败"
                }
                if (msg.msg != null) {
                    msg_str += "," + msg.msg;
                }
                $.messager.alert(msg_str);
                refreshData();
            }, error: function () {
                $.messager.alert("温馨提示", "请求错误!");
            }, complete: function () {
                //$('#refuseBtn').removeAttr("disabled");
                //layer.close(loading);
            }
        });
    });
}
function controller(id) {
    $("#repayDiv").html('<form class="form-horizontal"  onsubmit="return false;"><div class="form-group"><label class="col-sm-2 control-label" style="margin-top: 15px;">金额: </label><div class="col-sm-8"><input id="amount" class="form-control" placeholder="输入金额"/></div></div></form>');
    $("#buttonShow").html('<div class="modal-footer" ><button data-bb-handler="confirm" type="button" id="saveUserBtn" class="btn btn-success radius"><span><i class="icon-ok"></i></span> &nbsp;保&nbsp;&nbsp;存</button><button data-bb-handler="cancel" type="button" id="cancelSave" class="btn btn-danger radius">取消</button></div>');
    $("#repay").attr("style", "width:500px;height:300px;");
    $('#myModalRepayLabel').text('入催');
    $("#repayModal").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });
    $('#cancelSave').click(function () {
        $("#repayModal").modal('hide');
    });
    $('#saveUserBtn').click(function () {
        save(id);
    });
}

function save(id) {
    var amount = $('#amount').val();
    amount = amount.replace(/[^\d\.]/g, '');
    if (isNaN(amount)) {
        $.messager.alert('温馨提示', "输入有误");
        return;
    }
    $.ajax({
        url: "order/collection/upp",
        cache: false,
        dataType: 'json',
        data: {
            "amount": amount,
            "orderId": id
        },
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#saveUserBtn').attr({disabled: "disabled"});
        },
        success: function (result) {
            if (result.flag == true) {
                $.messager.alert('温馨提示', result.message);
                $("#repayModal").modal('hide');
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
function repaymentPlanList(id) {
    var grid_data = "";
    $.post("order/getRepaymentPlanByOrderId", {"orderId": id},
        function (data) {
            $("#repayDiv").html("<table id=\"grid-table\"></table>\n" +
                "<div id=\"grid-pager\"></div>\n" +
                "<script type=\"text/javascript\">\n" +
                "var $path_base = \"/\";" +
                " <\/script> ");
            grid_data = data;
            jQuery(function ($) {
                var grid_selector = "#grid-table";
                var pager_selector = "#grid-pager";
                jQuery(grid_selector).jqGrid({
                    data: grid_data,
                    datatype: "local",
                    height: 400,
                    colNames: ['期次', '应还金额', '应还本金', '应还利息', '结清时间'],
                    colModel: [
                        {name: 'repaymentPlanTimes', index: 'repaymentPlanTimes', width: 80},
                        {name: 'repaymentPlanAmount', index: 'repaymentPlanAmount', width: 80},
                        {name: 'repaymentPlanCapital', index: 'repaymentPlanCapital', width: 80},
                        {name: 'repaymentPlanInterest', index: 'repaymentPlanInterest', width: 80},
                        {name: 'repaymentPlanEndTime', index: 'repaymentPlanEndTime', width: 140}
                    ],
                    viewrecords: true,
                    rowNum: 10,
                    rowList: [10, 20, 30, 100],
                    multiselect: false,
                    multiboxonly: false,
                    autowidth: true

                });
                //navButtons
                jQuery(grid_selector).jqGrid('navGrid', pager_selector,
                    { 	//navbar options
                        edit: true,
                        editicon: 'icon-pencil blue',
                        add: true,
                        addicon: 'icon-plus-sign purple',
                        del: true,
                        delicon: 'icon-trash red',
                        search: true,
                        searchicon: 'icon-search orange',
                        refresh: true,
                        refreshicon: 'icon-refresh green',
                        view: true,
                        viewicon: 'icon-zoom-in grey',
                    },
                    {
                        //edit record form
                        //closeAfterEdit: true,
                        recreateForm: true,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                            style_edit_form(form);
                        }
                    },
                    {
                        //new record form
                        closeAfterAdd: true,
                        recreateForm: true,
                        viewPagerButtons: false,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                            style_edit_form(form);
                        }
                    },
                    {
                        //delete record form
                        recreateForm: true,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            if (form.data('styled')) return false;

                            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                            style_delete_form(form);

                            form.data('styled', true);
                        },
                        onClick: function (e) {
                            alert(1);
                        }
                    },
                    {
                        //search form
                        recreateForm: true,
                        afterShowSearch: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                            style_search_form(form);
                        },
                        afterRedraw: function () {
                            style_search_filters($(this));
                        }
                        ,
                        multipleSearch: true,
                        /**
                         multipleGroup:true,
                         showQuery: true
                         */
                    },
                    {
                        //view record form
                        recreateForm: true,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                        }
                    }
                )

                function style_edit_form(form) {
                    //enable datepicker on "sdate" field and switches for "stock" field
                    form.find('input[name=sdate]').datepicker({format: 'yyyy-mm-dd', autoclose: true})
                        .end().find('input[name=stock]')
                        .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
                    //update buttons classes
                    var buttons = form.next().find('.EditButton .fm-button');
                    buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
                    buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
                    buttons.eq(1).prepend('<i class="icon-remove"></i>')

                    buttons = form.next().find('.navButton a');
                    buttons.find('.ui-icon').remove();
                    buttons.eq(0).append('<i class="icon-chevron-left"></i>');
                    buttons.eq(1).append('<i class="icon-chevron-right"></i>');
                }

                function style_delete_form(form) {
                    var buttons = form.next().find('.EditButton .fm-button');
                    buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
                    buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
                    buttons.eq(1).prepend('<i class="icon-remove"></i>')
                }

                function style_search_filters(form) {
                    form.find('.delete-rule').val('X');
                    form.find('.add-rule').addClass('btn btn-xs btn-primary');
                    form.find('.add-group').addClass('btn btn-xs btn-success');
                    form.find('.delete-group').addClass('btn btn-xs btn-danger');
                }

                function style_search_form(form) {
                    var dialog = form.closest('.ui-jqdialog');
                    var buttons = dialog.find('.EditTable')
                    buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
                    buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
                    buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
                }
            });
        }, "json");
    $("#buttonShow").html("");
    $("#repay").attr("style", "width:500px");
    $('#myModalRepayLabel').text('计划');
    $("#repayModal").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });
}

function repaymentList(id) {
    var grid_data = "";
    $.post("order/queryPrepayment", {"orderId": id},
        function (data) {
            $("#repayDiv").html("<table id=\"grid-table\"></table>\n" +
                "<div id=\"grid-pager\"></div>\n" +
                "<script type=\"text/javascript\">\n" +
                "var $path_base = \"/\";" +
                " <\/script> ");
            grid_data = data;
            jQuery(function ($) {
                var grid_selector = "#grid-table";
                var pager_selector = "#grid-pager";
                jQuery(grid_selector).jqGrid({
                    data: grid_data,
                    datatype: "local",
                    height: 400,
                    colModel: [
                        {label: 'id', name: 'id', width: 75, hidden: true},
                        {label: '期次', name: 'repaymentTimes', width: 80},
                        {label: '实际还金额', name: 'realAmount', width: 100},
                        {
                            label: '状态',
                            name: 'repaymentStatus',
                            width: 100,
                            formatter: function (cellvalue, options, cell) {
                                if (cell.repaymentStatus == 0) return "正常还款";
                                if (cell.repaymentStatus == 1) return "提前还款";
                                if (cell.repaymentStatus == 2) return "逾期还款";
                            }
                        },
                        {
                            label: '还款动作',
                            name: 'repaymentType',
                            width: 100,
                            formatter: function (cellvalue, options, cell) {
                                if (cell.repaymentType == 0) return "主动还款";
                                if (cell.repaymentType == 1) return "代扣";
                                if (cell.repaymentType == 2) return "催收还款";
                            }
                        },
                        {label: '还款银行卡号', name: 'repaymentCardid', width: 180},
                        {label: '还款时间', name: 'repaymentTime', width: 180},
                        {label: '还款流水号', name: 'repaymentNumber', width: 100},
                        {
                            label: '银行状态', name: 'active', width: 130, formatter: function (cellvalue, options, cell) {
                            if (cell.active == 0) return "银行回调成功";
                            if (cell.active == 1) return "调用银行";
                            if (cell.active == 2) return "银行回调失败";
                            if (cell.active == 3) return "自动扣款关闭";
                            if (cell.active == 4) return "重复扣款";
                        }
                        },
                    ],
                    viewrecords: true,
                    rowNum: 10,
                    rowList: [10, 20, 30, 100],
                    multiselect: false,
                    multiboxonly: false,
                    autowidth: true

                });
                //navButtons
                jQuery(grid_selector).jqGrid('navGrid', pager_selector,
                    { 	//navbar options
                        edit: true,
                        editicon: 'icon-pencil blue',
                        add: true,
                        addicon: 'icon-plus-sign purple',
                        del: true,
                        delicon: 'icon-trash red',
                        search: true,
                        searchicon: 'icon-search orange',
                        refresh: true,
                        refreshicon: 'icon-refresh green',
                        view: true,
                        viewicon: 'icon-zoom-in grey',
                    },
                    {
                        //edit record form
                        //closeAfterEdit: true,
                        recreateForm: true,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                            style_edit_form(form);
                        }
                    },
                    {
                        //new record form
                        closeAfterAdd: true,
                        recreateForm: true,
                        viewPagerButtons: false,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                            style_edit_form(form);
                        }
                    },
                    {
                        //delete record form
                        recreateForm: true,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            if (form.data('styled')) return false;

                            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                            style_delete_form(form);

                            form.data('styled', true);
                        },
                        onClick: function (e) {
                            alert(1);
                        }
                    },
                    {
                        //search form
                        recreateForm: true,
                        afterShowSearch: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                            style_search_form(form);
                        },
                        afterRedraw: function () {
                            style_search_filters($(this));
                        }
                        ,
                        multipleSearch: true,
                        /**
                         multipleGroup:true,
                         showQuery: true
                         */
                    },
                    {
                        //view record form
                        recreateForm: true,
                        beforeShowForm: function (e) {
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                        }
                    }
                )

                function style_edit_form(form) {
                    //enable datepicker on "sdate" field and switches for "stock" field
                    form.find('input[name=sdate]').datepicker({format: 'yyyy-mm-dd', autoclose: true})
                        .end().find('input[name=stock]')
                        .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
                    //update buttons classes
                    var buttons = form.next().find('.EditButton .fm-button');
                    buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
                    buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
                    buttons.eq(1).prepend('<i class="icon-remove"></i>')

                    buttons = form.next().find('.navButton a');
                    buttons.find('.ui-icon').remove();
                    buttons.eq(0).append('<i class="icon-chevron-left"></i>');
                    buttons.eq(1).append('<i class="icon-chevron-right"></i>');
                }

                function style_delete_form(form) {
                    var buttons = form.next().find('.EditButton .fm-button');
                    buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
                    buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
                    buttons.eq(1).prepend('<i class="icon-remove"></i>')
                }

                function style_search_filters(form) {
                    form.find('.delete-rule').val('X');
                    form.find('.add-rule').addClass('btn btn-xs btn-primary');
                    form.find('.add-group').addClass('btn btn-xs btn-success');
                    form.find('.delete-group').addClass('btn btn-xs btn-danger');
                }

                function style_search_form(form) {
                    var dialog = form.closest('.ui-jqdialog');
                    var buttons = dialog.find('.EditTable')
                    buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
                    buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
                    buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
                }
            });
        }, "json");
    $("#buttonShow").html("");
    $("#repay").attr("style", "width:1000px");
    $('#myModalRepayLabel').text('还款信息');
    $("#repayModal").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });

}

