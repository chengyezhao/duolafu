package com.shoumipay.service.impl;

import com.shoumipay.dao.VerifyParameterMapper;
import com.shoumipay.domain.VerifyParameter;
import com.shoumipay.domain.VerifyParameterExample;
import com.shoumipay.domain.VerifyParameterExample.Criteria;
import com.shoumipay.service.admin.VerifyParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VerifyParameterServiceImpl implements VerifyParameterService {
    @Autowired
    private VerifyParameterMapper verifyParameterMapper;
    @Override
    public int addVerifyParameter(VerifyParameter verifyParameter) {
        return verifyParameterMapper.insert(verifyParameter);
    }

    @Override
    public int updateVerifyParameter(VerifyParameter verifyParameter) {
        return verifyParameterMapper.updateByPrimaryKey(verifyParameter);
    }

    @Override
    public List<VerifyParameter> queryVerifyParameterList(VerifyParameter verifyParameter) {
        VerifyParameterExample verifyParameterExample = new VerifyParameterExample();
        Criteria criteria = verifyParameterExample.createCriteria();
        proSearchParam(verifyParameter,criteria);
        return verifyParameterMapper.selectByExample(verifyParameterExample);
    }
    /**
     * 处理查询条件
     */
    private void proSearchParam(VerifyParameter verifyParameter,Criteria criteria){

        if (verifyParameter.getType()!=null&&verifyParameter.getType().trim().length()>0){
            criteria.andTypeEqualTo(verifyParameter.getType());
        }
        if (verifyParameter.getP1()!=null&&verifyParameter.getP1().trim().length()>0){
            criteria.andP1EqualTo(verifyParameter.getP1());
        }
        if (verifyParameter.getP2()!=null&&verifyParameter.getP2().trim().length()>0){
            criteria.andP2EqualTo(verifyParameter.getP2());
        }
        if (verifyParameter.getP3()!=null&&verifyParameter.getP3().trim().length()>0){
            criteria.andP3EqualTo(verifyParameter.getP3());
        }
        if (verifyParameter.getP4()!=null&&verifyParameter.getP4().trim().length()>0){
            criteria.andP4EqualTo(verifyParameter.getP4());
        }
        if (verifyParameter.getP5()!=null&&verifyParameter.getP5().trim().length()>0){
            criteria.andP5EqualTo(verifyParameter.getP5());
        }
    };
}
