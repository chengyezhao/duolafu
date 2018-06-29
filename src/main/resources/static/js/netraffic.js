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
    var state = $("#uppBacklist").val();
    $(grid_selector).jqGrid({
        url: "/finance/netraffic/list",
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            {label: 'id', name: 'id', width: 75, hidden: true},
            {label: '时间', name: 'time', width: 100},
            {label: '产品id', name: 'goodsId', width: 60},
            {label: '渠道', name: 'channel', width: 60},
            {label: '注册数', name: 'registerNumber', width: 60},
            {label: '申请量', name: 'applyForNumber', width: 60},
            {label: '提交量', name: 'submitNumber', width: 60},
            {label: '通过量', name: 'passNumber', width: 60},
            {label: '审批通过金额', name: 'passAmount', width: 60},
            {label: '提交放款量', name: 'submitAmountNumber', width: 60},
            {label: '提交放款金额', name: 'submitAmount', width: 60},
            {label: '成功放款量', name: 'successAmountNumber', width: 60},
            {label: '成功放款金额', name: 'successAmount', width: 60},
            {label: '通过率', name: 'passRate', width: 60},
            {label: '提交放款率', name: 'submitAmountRate', width: 60},
            {label: '放款成功率', name: 'successAmountRate', width: 60},

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
        var goodsId = $("#goodsId").val();
        var channel = $("#channel").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        if (startTime > endTime) {
            $("#startTime").val(endTime);
            $("#endTime").val(startTime);
            var i = startTime;
            startTime = endTime;
            endTime = i;
        }
        $(grid_selector).jqGrid('setGridParam', {
            postData: {goodsId: goodsId, channel: channel, startTime: startTime, endTime: endTime},
            //search: true,
            page: 1
        }).trigger("reloadGrid");
    });


});

function removeHorizontalScrollBar() {
    $("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width", parseInt($("div.ui-state-default.ui-jqgrid-hdiv.ui-corner-top").css("width")) + 1 + "px");
    $(grid_selector).closest(".ui-jqgrid-bdiv").css("width", parseInt($(grid_selector).closest(".ui-jqgrid-bdiv").css("width")) + 1 + "px");
}


//初始化数据
function initData() {
    $('#goodsId').val("");
    $('#orderId').val("");
    $('#startTime').val("");
    $('#endTime').val("");
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

