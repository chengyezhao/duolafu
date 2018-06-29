package com.shoumipay.constants;

/**
 * Created by Zhw on 2017/10/27.
 */
public interface GoodsOrderConstants {
    //0-未提交,
    int APPROVAL_PENDING = 1;// 1-已提交待审批,
    int APPROVAL = 2;// 2-审批通过,
    int APPROVAL_REFUSED = 3;// 3-审批拒绝,
    int APPROVAL_CLOSED = 4;// 4-订单关闭,
    int WAIT_LEND = 5;// 5待放款,
    int LENDING = 6;// 6放款中,
    int LOAN_SUCCESS = 7;// 7放款成功',
    int LOAN_FAILURE = 8;// 8放款失败',
    int LOAN_DISCONTINUE = 9;// 9订单中止',
    int LOAN_COMPLETE = 10;// 10订单结清,
    Integer NORMAL_ORDER = 0;//0为正常订单
    Integer ORDERDUE_ORDER = 1;// 1为逾期,
    String SYSTEM_OPERATION = "SYSTEM";//系统操作
    String ORDER_CHANNEL_APP = "APP";//app渠道
    String ORDER_CHANNEL_WECHAT = "WeChat";//app渠道
    int PREPAYMENT_STATUS = 1;

    int POUNDAGE_PAY_FLAG_Y = 1;//代付手续费 已支付 1
    int POUNDAGE_PAY_FLAG_N = 0;//代付手续费 未支付 0

    int BILLS_FLAG_TRUE = 1; //已出账
    int BILLS_FLAG_FALSE = 0; //未出账
}
