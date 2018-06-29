package com.shoumipay.service.impl;

import com.github.pagehelper.PageHelper;
import com.shoumipay.dao.ContractMapper;
import com.shoumipay.domain.Contract;
import com.shoumipay.domain.ContractExample;
import com.shoumipay.service.admin.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractMapper contractMapper;

    @Override
    public Contract queryById(Long id) {
        return contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Contract> queryByIdTime(String id, Map<String, String> params) {
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startTime = null;
        Date endTime = null;
        try {
            if (params.get("startTime")!=""&&params.get("endTime")!=""&&params.get("startTime")!=null&&params.get("endTime")!=null){
                startTime = bartDateFormat.parse(params.get("startTime"));
                endTime = bartDateFormat.parse(params.get("endTime"));
            }
            ContractExample contractExample = new ContractExample();
            ContractExample.Criteria criteria = contractExample.createCriteria();
            if(id!=null&&id!=""){
                criteria.andIdCardEqualTo(id);
            }
            if (startTime != null && endTime != null) {
                criteria.andCreatetimeBetween(startTime, endTime);
            }
            PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
            return contractMapper.selectByExample(contractExample);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertContract(Contract contract) {
        return contractMapper.insertSelective(contract);
    }
}
