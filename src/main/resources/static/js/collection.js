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
        url: "/order/collection/list",
        datatype: "json",
        mtype: 'POST',
        height: window.screen.height - 550,
        colModel: [
            {label: 'id', name: 'id', width: 75, hidden: true},
            {label: '订单号', name: 'orderNumber', width: 130},
            {label: '手机号', name: 'username', width: 130},
            {label: '期次', name: 'repaymentCollectionTimeLimit', width: 80},
            {label: '应还金额', name: 'repaymentCollectionAmount', width: 100},
            {label: '应还本金', name: 'repaymentCollectionCapital', width: 100},
            {label: '应还利息', name: 'repaymentCollectionInterest', width: 100},
            {label: '入催金额', name: 'repaymentCollectionIncome', width: 100},
            {label: '催收人', name: 'repaymentCollectionAuditor', width: 100},
            {label: '催收机构代码', name: 'repaymentCollectionInstitutionCode', width: 100},
            {label: '时间', name: 'repaymentCollectionAddTime', width: 100},
            {label: '状态', name: 'repaymentCollectionStatus', width: 100, formatter: function (cellvalue, options, cell) {
                if (cell.repaymentCollectionStatus == 0) return "失败";
                if (cell.repaymentCollectionStatus == 1) return "成功";
                if (cell.repaymentCollectionStatus == 2) return "催收中";
            }},
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
        var orderNumber = $("#orderNumber").val();
        /*var repaymentCardid = $("#repaymentCardid").val();*/
        var minRepayTime = $("#minRepayTime").val();
        var maxRepayTime = $("#maxRepayTime").val();
       /* var minRepayAmount = $("#minRepayAmount").val();
        var maxRepayAmount = $("#maxRepayAmount").val();*/
        if (minRepayTime > maxRepayTime) {
            $("#minRepayTime").val(maxRepayTime);
            $("#maxRepayAmount").val(minRepayTime);
            var i = minRepayTime;
            minRepayTime = maxRepayTime;
            maxRepayTime = i;
        }
        $(grid_selector).jqGrid('setGridParam', {
            postData: {
                orderNumber: orderNumber,minRepayTime: minRepayTime, maxRepayTime: maxRepayTime
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
        $("#orderNumber").val("");
        /*$("#repaymentCardid").val("");*/
        $("#minRepayTime").val("");
        $("#maxRepayTime").val("");
      /*  $("#minRepayAmount").val("");
        $("#maxRepayAmount").val("");*/
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

function refreshData() {
    $(grid_selector).jqGrid('setGridParam', {
        postData: {
            orderNumber: null, repaymentCardid: null, minRepayTime: null, maxRepayTime: null
            , minRepayAmount: null, maxRepayAmount: null
        },
        page: 1
    }).trigger("reloadGrid");
}
