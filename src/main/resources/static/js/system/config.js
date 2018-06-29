function update(key, value, desc) {
    var data = {
        "key": key,
        "value": value
    };
    if (desc) data.desc = desc;
    $.ajax({
        url:'updateConfig',
        data:data,
        method:"POST",
        success:function (msg) {
            if (1 == msg.flag) {
                alert('保存成功');
                window.location.reload();
            } else {
                alert('保存失败');
            }
        }
    });
}
$(function () {

    $('#applyOrderStart').click(function () {
        if (confirm('确定允许申请?')) update('SYSTEM_CONFIG_APPLY_ORDER', 'true');
    });
    $('#applyOrderStop').click(function () {
        if (confirm('确定拒绝申请?')) update('SYSTEM_CONFIG_APPLY_ORDER', 'false');
    });
    $('#doLoanStart').click(function () {
        if (confirm('确定允许放款?')) update('SYSTEM_CONFIG_DO_LOAN', 'true');
    });
    $('#doLoanStop').click(function () {
        if (confirm('确定拒绝拒绝?')) update('SYSTEM_CONFIG_DO_LOAN', 'false');
    });
    $('#saveIdentifyTime').click(function () {
        var time = parseInt($('#identifyTime').val());
        if (0 < time) {
            update('SYSTEM_CONFIG_IDENTIFYING_CODE_TIME', time);
        } else {
            alert("参数有误");
        }
    });
    $('#saveLoanTimes').click(function () {
        var time = parseInt($('#loanTimes').val());
        if (0 < time) {
            update('SYSTEM_CONFIG_LOAN_TIMES_LIMIT', time);
        } else {
            alert("参数有误");
        }
    });
    $('#saveApplyTimes').click(function () {
        var time = parseInt($('#applyTimes').val());
        if (0 < time) {
            update('SYSTEM_CONFIG_APPLY_TIMES_LIMIT', time);
        } else {
            alert("参数有误");
        }
    });
    $('#saveLoanMoney').click(function () {
        var time = parseInt($('#loanMoney').val());
        if (0 < time) {
            update('SYSTEM_CONFIG_LOAN_MONEY_LIMIT', time);
        } else {
            alert("参数有误");
        }
    });
});

