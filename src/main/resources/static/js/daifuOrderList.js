var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
$(function () {
    $(window).resize(function () {
        $(grid_selector).setGridWidth($(window).width() * 0.95);
    });
    $(grid_selector).jqGrid({
        url: "daifuOrder/daifuOrderList",
        mtype: 'POST',
        datatype: "json",
        height: window.screen.height - 550,
        colNames: ['','订单Id', 'codeId', '账单id', '用户id', '订单名称', '订单状态'
                   , '期数', '总本金', '手续费', '实际支付手续费', '每月管理费', '逾期状态'
                   , '创建时间', '更新时间', '操作员id','描述','首付',],

               colModel: [
                        {
                                        name: 'myac', index: '', width: 80, fixed: true, sortable: false, resize: false,
                                        formatter: 'actions',
                                        formatoptions: {
                                               keys: true,
                                        }
                                    },



//                   {name: 'orderId', index: 'orderId', width: 60, sorttype: "int", editable: false, hidden: true},
                   {name: 'orderId', index: 'orderId', width: 60, sorttype: "int", editable: true},
                   {name: 'codeId', index: 'codeId', width: 50, editable: true, editoptions: {size: "20", maxlength: "30"}},
                   {name: 'billId', index: 'billId', width: 50, editable: true, editoptions: {size: "20", maxlength: "30"}},
                   {name: 'memberId', index: 'memberId', width: 60, sorttype: "int", editable: true},
                    {
                         name: 'title',
                         index: 'title',
                         width: 50,
                         editable: true,
                         editoptions: {size: "20", maxlength: "30"}
                    },
                   {name: 'status', index: 'status', width: 50, editable: true},
                   {name: 'totalTerm', index: 'totalTerm', width: 50, editable: true},
                   {name: 'price', index: 'price', width: 70, editable: true, editoptions: {size: "20", maxlength: "30"}},
                   {name: 'commission', index: 'commission', width: 70, editable: true, editoptions: {size: "20", maxlength: "30"}},
                   {
                       name: 'paidCommission',
                       index: 'paidCommission',
                       width: 50,
                       editable: true,
                       editoptions: {size: "20", maxlength: "30"}
                   },
                   {
                       name: 'monthlyFee',
                       index: 'monthlyFee',
                       width: 90,
                       editable: true,
                       editoptions: {size: "20", maxlength: "30"}
                   },
                   {name: 'overdueStatus', index: 'overdueStatus', width: 90, sorttype: "float", editable: true},
                   {name: 'createdDate', index: 'createdDate', width: 60, sorttype: "float", editable: false},
                   {name: 'lastUpdateDate', index: 'lastUpdateDate', width: 60, sorttype: "float", editable: false},
                   {name: 'operatorId', index: 'operatorId', width: 60, sorttype: "float", editable: true},
                   {name: 'comments', index: 'comments', width: 60, sorttype: "float", editable: true},
                   {name: 'downPayment', index: 'downPayment', width: 60, sorttype: "float", editable: true},
               ],



        viewrecords: true,
        rowNum: 10,
        rowList: [10, 20, 30, 100],
        pager: pager_selector,
        altRows: true,
        shrinkToFit: true,
        forceFit: false,
        multiselect: true,
        multiboxonly: true,

        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);

                updateActionIcons(table);
                updatePagerIcons(table);
                enableTooltips(table);
            }, 0);
        },

        editurl: "/daifuOrder/updateDaifuOrder",
        autowidth: true

    });







    //enable datepicker
    function pickDate(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=text]')
                .datepicker({format: 'yyyy-mm-dd', autoclose: true});
        }, 0);
    }


    //navButtons
    jQuery(grid_selector).jqGrid('navGrid', pager_selector,
        { 	//navbar options
            edit: false,
            editicon: 'icon-pencil blue',
            add: false,
            addicon: 'icon-plus-sign purple',
            del: false,
            delicon: 'icon-trash red',
            search: false,
            searchicon: 'icon-search orange',
            refresh: true,
            refreshicon: 'icon-refresh green',
            view: false,
            viewicon: 'icon-zoom-in grey',
        },
        /*{
            //edit record form
            //closeAfterEdit: true,
            recreateForm: true,
            beforeShowForm : function(e) {
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
            beforeShowForm : function(e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //delete record form
            recreateForm: true,
            beforeShowForm : function(e) {
                var form = $(e[0]);
                if(form.data('styled')) return false;

                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_delete_form(form);

                form.data('styled', true);
            },
            onClick : function(e) {
                alert(1);
            }
        },
        {
            //search form
            recreateForm: true,
            afterShowSearch: function(e){
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                style_search_form(form);
            },
            afterRedraw: function(){
                style_search_filters($(this));
            }
            ,
            multipleSearch: true,
            /!**
             multipleGroup:true,
             showQuery: true
             *!/
        },*/
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

    function beforeDeleteCallback(e) {
        var form = $(e[0]);
        if (form.data('styled')) return false;

        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_delete_form(form);

        form.data('styled', true);
    }

    function beforeEditCallback(e) {
        var form = $(e[0]);
        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_edit_form(form);
    }


    //it causes some flicker when reloading or navigating grid
    //it may be possible to have some custom formatter to do this as the grid is being created to prevent this
    //or go back to default browser checkbox styles for the grid
    function styleCheckbox(table) {
        $(table).find('input:checkbox').addClass('ace')
            .wrap('<label />')
            .after('<span class="lbl align-top" />')


        $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
            .find('input.cbox[type=checkbox]').addClass('ace')
            .wrap('<label />').after('<span class="lbl align-top" />');
    }


    //unlike navButtons icons, action icons in rows seem to be hard-coded
    //you can change them like this in here if you want
    function updateActionIcons(table) {
        var replacement =
            {
                'ui-icon-pencil': 'icon-pencil blue',
                'ui-icon-trash': 'icon-trash red',
                'ui-icon-disk': 'icon-ok green',
                'ui-icon-cancel': 'icon-remove red'
            };
        $(table).find('.ui-pg-div span.ui-icon').each(function () {
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
            if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
        })
    }

    //replace icons with FontAwesome icons like above
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

            if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
        })
    }

    function enableTooltips(table) {
        $('.navtable .ui-pg-button').tooltip({container: 'body'});
        $(table).find('.ui-pg-div').tooltip({container: 'body'});
    }

    //var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
});
var task = "";
//新增标题，弹出新增窗口
$("#GoodsBtn").click(function () {
    task = "addGoods";
    $('#myModalLabel').text('新增产品');
    $("#goodsModal").modal({
        keyboard: false,
        show: true,
        backdrop: "static"
    });
});

$(".cancelSave").click(function () {
    $("#goodsModal").modal('hide');
    $("#goodsCostModal").modal('hide');
});

$("#GoodsCostsBtn").click(function () {
    task = "addGoodsCosts";
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
        $("#goodsid").val(data.id);
        $("#goodsCostModal").modal({
            keyboard: false,
            show: true,
            backdrop: "static"
        });
    }
});
$("#addGoodsBtn").click(function () {
    save();
});
$("#addGoodsCostsBtn").click(function () {
    save();
});

function save() {
    $.ajax({
        url: "goods/" + task,
        cache: false,
        data: $('#' + task).serialize(),
        type: 'post',
        beforeSend: function () {
            // 禁用按钮防止重复提交
            $('#' + task + 'Btn').attr({disabled: "disabled"});
        },
        success: function (result) {
            if (result == 'success') {
                $.messager.alert('温馨提示', "操作成功");
                $("#goodsModal").modal('hide');
                $("#goodsCostModal").modal('hide');
                refreshData();
            } else {
                $.messager.alert('温馨提示', "操作失败");
            }
        },
        complete: function () {
            $('#' + task + 'Btn').removeAttr("disabled");
        },
        error: function (data) {
            console.info("error: " + data.responseText);
        }
    })
}

//查询点击事件
$("#queryBtn").click(function () {
    var memberId = $("#memberId").val();
    $(grid_selector).jqGrid('setGridParam', {
        postData: {memberId: memberId},
        //search: true,
        page: 1
    }).trigger("reloadGrid");
});


$("#paycomplete").click(function () {
    task = "addGoodsCosts";
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    }
//    else {
//        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
//        $("#goodsid").val(data.id);
//        $("#goodsCostModal").modal({
//            keyboard: false,
//            show: true,
//            backdrop: "static"
//        });
//    }
});


$("#refundcomplete").click(function () {
    task = "addGoodsCosts";
    var rows = $(grid_selector).getGridParam('selarrrow');
    if (rows == 0) {
        // $.messager.alert("温馨提示","请选择一行记录！");
        layer.msg('请选择一行记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    } else if (rows.length > 1) {
        // $.messager.alert("温馨提示","不能同时修改多条记录！");
        layer.msg('不能同时修改多条记录！', {icon: 7, time: 2000}); //2秒关闭（如果不配置，默认是3秒）
        return;
    }
//    else {
//        var data = $(grid_selector).jqGrid('getRowData', rows[0]);
//        $("#goodsid").val(data.id);
//        $("#goodsCostModal").modal({
//            keyboard: false,
//            show: true,
//            backdrop: "static"
//        });
//    }
});