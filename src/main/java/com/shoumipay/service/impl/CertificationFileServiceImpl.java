package com.shoumipay.service.impl;

import com.shoumipay.dao.CertificationFileMapper;
import com.shoumipay.domain.CertificationFile;
import com.shoumipay.service.admin.CertificationFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificationFileServiceImpl implements CertificationFileService{
    @Autowired
    private CertificationFileMapper certificationFileMapper;
    @Override
    public int addCertification(CertificationFile certificationFile) {
        return certificationFileMapper.insert(certificationFile);
    }

    @Override
    public CertificationFile queryByMemberId(long memberid) {
        return certificationFileMapper.selectByMemberId(memberid);
    }

    @Override
    public int updateCertification(CertificationFile certificationFile) {
        return certificationFileMapper.updateByPrimaryKeySelective(certificationFile);
    }
}
