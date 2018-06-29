package com.shoumipay.service.admin;

import com.shoumipay.domain.CertificationFile;

public interface CertificationFileService {
    int addCertification(CertificationFile certificationFile);
    CertificationFile queryByMemberId(long memberid);
    int updateCertification(CertificationFile certificationFile);
}
