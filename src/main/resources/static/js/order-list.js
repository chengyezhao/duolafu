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
    $(grid_selector).jqGrid({
        url: "queryOrderList",
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            {label: 'id', name: 'id', width: 75, hidden: true},
            {label: '申请编号', name: 'orderNumber', width: 100},
            {label: '申请时间', name: 'orderCreateTime', width: 100},
            {label: '申请人', name: 'memberId', width: 100},
            {label: '产品id', name: 'goodsId', width: 100},
            {label: '产品码', name: 'orderCode', width: 100},
            {label: '借款金额', name: 'orderAmount', width: 100},
            {
                label: '订单状态', name: 'orderStatus', width: 100, formatter: function (cellvalue, options, cell) {
                var stateStr = "未启用"
                if (cell.orderStatus == 6) {
                    stateStr = '<button  onclick="makeLoans(' + cell.id + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查询放款</button>';
                } else {
                    stateStr = "测试"
                }
                return stateStr;

            }
            },
            {label: '订单类型', name: 'orderTypes', width: 100},
            {label: '审核人', name: 'orderAuditor', width: 100},
            {label: '审核时间', name: 'orderUpptime', width: 100},
            {label: '审批等级', name: 'orderLevel', width: 100},
            {label: '渠道', name: 'orderChannel', width: 100},
            {label: '折扣id', name: 'orderDiscount', width: 100},
            {
                label: '还款计划', name: 'opt', width: 150, formatter: function (cellvalue, options, cell) {
                return '<button  onclick="repaymentPlan(' + cell.id + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查询还款计划</button>';
            }
            }
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
        subGrid: true,  // (1)开启子表格支持
        subGridRowExpanded: function (subgrid_id, row_id) {  //(2)子表格容器的id和需要展开子表格的行id，将传入此事件函数
            var subgrid_table_id;
            subgrid_table_id = subgrid_id + "_t";   //(3)根据subgrid_id定义对应的子表格的table的id
            var subgrid_pager_id;
            subgrid_pager_id = subgrid_id + "_pgr"  //(4)根据subgrid_id定义对应的子表格的pager的id
            // (5)动态添加子报表的table和pager
            $("#" + subgrid_id).html("<table id='" + subgrid_table_id + "'class='scroll'></table><div id='" + subgrid_pager_id + "'class='scroll'></div>");

            // (6)创建jqGrid对象
            $("#" + subgrid_table_id).jqGrid({
                url: "getOrderIdRepaymentPay?orderId=" + row_id,  //(7)子表格数据对应的url，注意传入的contact.id参数
                datatype: "json",
                colNames: ['id', '期次', '应还金额', '应还费用', '应还本金',
                    '应还利息', '应还罚息', '应还管理费', '状态', '还款动作',
                    '还款银行卡号', '还款流水号'
                ],
                colModel: [
                    {name: "id", index: "id", width: 80, key: true},
                    {name: "repaymentTimeLimit", index: "repaymentTimeLimit", width: 130},
                    {name: "repaymentAmount", index: "repaymentAmount", width: 130, align: "right"},
                    {name: "repaymentCost", index: "repaymentCost", width: 130, align: "right"},
                    {name: "repaymentCapital", index: "repaymentCapital", width: 130},
                    {name: "repaymentInterest", index: "repaymentInterest", width: 130, align: "right"},
                    {name: "repaymentDefaultInterest", index: "repaymentDefaultInterest", width: 130, align: "right"},
                    {name: "repaymentManageCost", index: "repaymentManageCost", width: 130, align: "right"},
                    {name: "repaymentStatus", index: "repaymentStatus", width: 130, align: "right"},
                    {name: 'repaymentType',index:"repaymentType", width: 100, formatter: function (cellvalue, options, cell) {
                        var stateStr = "未启用"
                        if (cell.repaymentType == 2) {
                            stateStr = '<button  onclick="collection(' + cell.order + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>查询催收</button>';
                        } else {
                            stateStr = "测试"
                        }
                        return stateStr;
                    }
                    },
                    {name: "repaymentCardid", index: "repaymentCardid", width: 130, align: "right"},
                    {name: "repaymentNumber", index: "repaymentNumber", width: 130, align: "right"}
                ],
                jsonReader: {   // (8)针对子表格的jsonReader设置
                    root: "gridModel",
                    records: "record",
                    repeatitems: false
                },
                prmNames: {search: "search"},
                /* pager: subgrid_pager_id,*/
                viewrecords: true,
                height: "100%"
                /*rowNum: 5*/
            });
        },
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
});

//查询点击事件
$("#queryBtn").click(function () {
    var qryOrderNumber = $("#qryOrderNumber").val();
    $(grid_selector).jqGrid('setGridParam', {
        postData: {orderNumber: qryOrderNumber},
        //search: true,
        page: 1
    }).trigger("reloadGrid");
});

function removeHorizontalScrollBar() {
    $("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width", parseInt($("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width")) + 1 + "px");
    $(grid_selector).closest(".ui-jqgrid-bdiv").css("width", parseInt($(grid_selector).closest(".ui-jqgrid-bdiv").css("width")) + 1 + "px");
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
