package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.DataMACMapper;
import com.shoumipay.dao.FinancialMACMapper;
import com.shoumipay.dao.NetrafficMapper;
import com.shoumipay.domain.*;
import com.shoumipay.service.admin.FinanceService;
import com.shoumipay.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhw on 2017/11/20.
 */
@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private DataMACMapper dataMACMapper;
    @Autowired
    private NetrafficMapper netrafficMapper;
    @Autowired
    private FinancialMACMapper financialMACMapper;

    @Override
    public List<DataMAC> queryDataMAC(DataMAC dataMAC, Integer page, Integer rows, Date startTime, Date endTime) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        DataMACExample example = new DataMACExample();
        DataMACExample.Criteria criteria = example.createCriteria();
        if (dataMAC!=null){
            if (!StringUtil.isNull(dataMAC.getChannel())){
                criteria.andChannelLike("%"+dataMAC.getChannel()+"%");
            }
            if (dataMAC.getGoodsId()!=null){
                criteria.andGoodsIdEqualTo(dataMAC.getGoodsId());
            }
        }
        if (startTime != null && endTime != null) {
            criteria.andTimeBetween(startTime, endTime);
        }
        example.setOrderByClause(" time DESC");
        return dataMACMapper.selectByExample(example);
    }

    @Override
    public List<Netraffic> queryNetraffic(Netraffic netraffic, Integer page, Integer rows, Date startTime, Date endTime) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        NetrafficExample example = new NetrafficExample();
        NetrafficExample.Criteria criteria = example.createCriteria();
        if (netraffic!=null){
            if (!StringUtil.isNull(netraffic.getChannel())){
                criteria.andChannelLike("%"+netraffic.getChannel()+"%");
            }
            if (netraffic.getGoodsId()!=null){
                criteria.andGoodsIdEqualTo(netraffic.getGoodsId());
            }
        }
        if (startTime != null && endTime != null) {
            criteria.andTimeBetween(startTime, endTime);
        }
        example.setOrderByClause(" time DESC");
        return netrafficMapper.selectByExample(example);
    }

    @Override
    public List<FinancialMAC> queryFinancialMAC(FinancialMAC financialMAC, Integer page, Integer rows, Date startTime, Date endTime) {
        if (page != null && rows != null) {
            PageHelper.startPage(page, rows);
        }
        FinancialMACExample example=new FinancialMACExample();
        FinancialMACExample.Criteria criteria=example.createCriteria();
        if (financialMAC!=null){
            if (!StringUtil.isNull(financialMAC.getChannel())){
                criteria.andChannelLike("%"+financialMAC.getChannel()+"%");
            }
            if (financialMAC.getGoodsId()!=null){
                criteria.andGoodsIdEqualTo(financialMAC.getGoodsId());
            }
        }
        if (startTime != null && endTime != null) {
            criteria.andTimeBetween(startTime, endTime);
        }
        example.setOrderByClause(" time DESC");
        return financialMACMapper.selectByExample(example);
    }

    @Override
    public Netraffic queryNetByTime(String startTime, String endTime) {
        if(StringUtil.isNull(startTime)||StringUtil.isNull(endTime)){
            return new Netraffic();
        }
        return netrafficMapper.selectStat(startTime,endTime);
    }

    @Override
    public int addNetraffic(Netraffic netraffic) {
        return netrafficMapper.insertSelective(netraffic);
    }

    @Override
    public FinancialMAC queryFinanceByTime(String startTime, String endTime) {
        if(StringUtil.isNull(startTime)||StringUtil.isNull(endTime)){
            return new FinancialMAC();
        }
        return financialMACMapper.selectStat(startTime,endTime);
    }

    @Override
    public int addFinancialMAC(FinancialMAC financialMAC) {
        return financialMACMapper.insertSelective(financialMAC);
    }

    @Override
    public DataMAC queryDataMACByTime(String startTime, String endTime) {
        if(StringUtil.isNull(startTime)||StringUtil.isNull(endTime)){
            return new DataMAC();
        }
        return dataMACMapper.selectState(startTime,endTime);
    }

    @Override
    public int addDataMAC(DataMAC dataMAC) {
        return dataMACMapper.insertSelective(dataMAC);
    }
}
