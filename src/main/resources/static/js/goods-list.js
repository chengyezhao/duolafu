var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
$(function () {
    $(window).resize(function () {
        $(grid_selector).setGridWidth($(window).width() * 0.95);
    });
    $(grid_selector).jqGrid({
        //direction: "rtl",
        url: "goods/queryGoodsList",
        mtype: 'POST',
        //data: grid_data,
        datatype: "json",
        height: window.screen.height - 550,
        colNames: [' ', 'id', '产品名称', '产品别名', '期限', '还款类型', '新增时间'
            , '更新时间', '更新人', '版本号', '费用名称', '计费方式', '费用值'
            , '产品费率', '综合费率', '逾期利率', '最大额度', '产品基础费用',],
        colModel: [
            {
                name: 'myac', index: '', width: 80, fixed: true, sortable: false, resize: false,
                formatter: 'actions',
                formatoptions: {
                    keys: true,
                    //delOptions:{recreateForm: false, beforeShowForm:beforeDeleteCallback},
                    //editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
                }
            },
            /*{name:'id',index:'id', width:60, sorttype:"int", editable: true},
            {name:'sdate',index:'sdate',width:90, editable:true, sorttype:"date",unformat: pickDate},
            {name:'name',index:'name', width:150,editable: true,editoptions:{size:"20",maxlength:"30"}},
            {name:'stock',index:'stock', width:70, editable: true,edittype:"checkbox",editoptions: {value:"Yes:No"},unformat: aceSwitch},
            {name:'ship',index:'ship', width:90, editable: true,edittype:"select",editoptions:{value:"FE:FedEx;IN:InTime;TN:TNT;AR:ARAMEX"}},
            {name:'note',index:'note', width:150, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}}*/
            {name: 'id', index: 'id', width: 60, sorttype: "int", editable: false, hidden: true},
            {name: 'name', index: 'name', width: 150, editable: true, editoptions: {size: "20", maxlength: "30"}},
            {name: 'alias', index: 'alias', width: 150, editable: true, editoptions: {size: "20", maxlength: "30"}},
            {name: 'timeLimit', index: 'timeLimit', width: 60, sorttype: "int", editable: true},
            {
                name: 'repaymentType',
                index: 'repaymentType',
                width: 90,
                editable: false,
                edittype: "select",
                editoptions: {value: "0:等额本息"},
                formatter: function (cellvalue, options, cell) {
                    if (cell.repaymentType == 0) {
                        return '等额本息'
                    }
                }
            },
            {name: 'addtime', index: 'addtime', width: 150, editable: false, sorttype: "date", unformat: pickDate},
            {name: 'addtime', index: 'addtime', width: 150, editable: false, sorttype: "date", unformat: pickDate},
            {name: 'uppname', index: 'uppname', width: 90, editable: true, editoptions: {size: "20", maxlength: "30"}},
            {name: 'version', index: 'version', width: 90, editable: true, editoptions: {size: "20", maxlength: "30"}},
            {
                name: 'costname',
                index: 'costname',
                width: 90,
                editable: true,
                editoptions: {size: "20", maxlength: "30"}
            },
            {
                name: 'billingMethods',
                index: 'billingMethods',
                width: 90,
                editable: false,
                edittype: "select",
                editoptions: {value: "0:百分比"},
                formatter: function (cellvalue, options, cell) {
                    if (cell.repaymentType == 0) {
                        return '百分比'
                    }
                }
            },
            {name: 'cost', index: 'cost', width: 60, sorttype: "float", editable: true},
            {name: 'productRate', index: 'productRate', width: 60, sorttype: "float", editable: true},
            {name: 'totalRate', index: 'totalRate', width: 60, sorttype: "float", editable: true},
            {name: 'overdueInterest', index: 'overdueInterest', width: 60, sorttype: "float", editable: true},
            {name: 'maxamount', index: 'maxamount', width: 90, sorttype: "float", editable: true},
            {
                name: 'costs', width: 150, formatter: function (cellvalue, options, cell) {
                return '<button  onclick="costs(' + cell.id + ')" class="btn btn-purple btn-sm" ><i class="fa fa-cog  fa-spin" aria-hidden="true"></i>产品基础费用</button>';
            }
            },
        ],

        viewrecords: true,
        rowNum: 10,
        rowList: [10, 20, 30, 100],
        pager: pager_selector,
        altRows: true,
        //toppager: true,
        shrinkToFit: true,
        forceFit: false,
        multiselect: true,
        //multikey: "ctrlKey",
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

        editurl: $path_base + "/addGoods",//nothing is saved
        //caption: "产品表",
        autowidth: true

    });

    //enable search/filter toolbar
    //jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

    //switch element when editing inline
    /* function aceSwitch( cellvalue, options, cell ) {
         setTimeout(function(){
             $(cell) .find('input[type=checkbox]')
                 .wrap('<label class="inline" />')
                 .addClass('ace ace-switch ace-switch-5')
                 .after('<span class="lbl"></span>');
         }, 0);
     }*/

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
    var alias = $("#alias").val();
    $(grid_selector).jqGrid('setGridParam', {
        postData: {alias: alias},
        //search: true,
        page: 1
    }).trigger("reloadGrid");
});