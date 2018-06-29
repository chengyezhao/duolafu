package com.shoumipay.pay;

/**
 * Created by Administrator on 2017/10/24.
 */
public interface PayParamter {
    /**
     * 分期付
     */
    String TRADER_MD5_KEY_INSTALL = "201608101001022519_test_20160810"; //MD5KEY
    String OID_PARTNER_INSTALL = "201711010001092244"; //商户号
    String PRIVATEKEY_INSTALL = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM+/3LJq/M5rwXcGMDD0qYG+0v9uoss6iIpAVeVAxkFkC7o/BVKvkBx+PTKSyF9RYc+UANSi+mrqOsRXRqK6qdFzXusGgdZbhCx/2/8c+jibGcSqPaSMRN5T/L9ssr99QV2wHTBkYCIEUjmZ1m+vbVP6frnI3mw3FcTWPQfdLKBJAgMBAAECgYAvV+LcigMYq3fIPxHGZksmtSzyZu0UcT9ieizY9Lz5c+o0RF5bLIUj6STbHJYrGqm2m1zhGE8HBF/mFJmVRgKivo6YXhOzmmeZYCJrzBpu6IKSuLfLnM8NhBqoKTbqJQLVdt2z64GpdHKOS/aUlOA1ly3PCb2LLhpJtBkDQ1y0zQJBAOqyc50Obd107ZdrAf3+xdeC7AVdkxxyyHnAqb5M5FVq5vu6tmohbiCRsfU46RFMfrSdEGihRUB+fKntlm6v4qcCQQDimz24m0QvouJrhYq7AyT2VdgFoIVeJ3ES6rZLSaLMJrWd9iHaMtMeW1WH+ZSdMGf+KCz96JAhBh5cFkWYhHOPAkB0SHx96YNHwUJiznMLPKsbj1OPiQB1jO2FXY78qa5MIA5X1PfCd9PPsUBB5rObjZINvPA/VwAv5zuvGfd52g1rAkEAq458G9bwuF/Iqz5e2VZ4FUbIVPpB/hY+NOQdPsJwzb5AoWZGGrt/uevLxTXenWKYWIJyDYiUFWxcb7ss1VrxYQJAa6ZYFuTyC70iHTg1/rc/c6KqbK+HDYcRJI+7xZu5YwSfqDjfYCvi4hU9y5Xen5bQOxi1RBFtVfVq7N78i1/6zw=="; //RSA私钥
    String PUBLICKEY_INSTALL = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";

    String NO_ORDER_INSTALL = "2016021100002"; //商户唯一标识
    String SMS_PARAM_INSTALL = "{\"contract_type\":\"玖易贷\",\"contact_way\":\"400-600-5200\"}";

    /**
     * 实时付款
     *
     */
    String TRADER_MD5_KEY_WAP = "201408071000001543test_20140812";
    String OID_PARTNER_WAP = "201711010001092244";
    String PRIVATEKEY_WAP = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM+/3LJq/M5rwXcGMDD0qYG+0v9uoss6iIpAVeVAxkFkC7o/BVKvkBx+PTKSyF9RYc+UANSi+mrqOsRXRqK6qdFzXusGgdZbhCx/2/8c+jibGcSqPaSMRN5T/L9ssr99QV2wHTBkYCIEUjmZ1m+vbVP6frnI3mw3FcTWPQfdLKBJAgMBAAECgYAvV+LcigMYq3fIPxHGZksmtSzyZu0UcT9ieizY9Lz5c+o0RF5bLIUj6STbHJYrGqm2m1zhGE8HBF/mFJmVRgKivo6YXhOzmmeZYCJrzBpu6IKSuLfLnM8NhBqoKTbqJQLVdt2z64GpdHKOS/aUlOA1ly3PCb2LLhpJtBkDQ1y0zQJBAOqyc50Obd107ZdrAf3+xdeC7AVdkxxyyHnAqb5M5FVq5vu6tmohbiCRsfU46RFMfrSdEGihRUB+fKntlm6v4qcCQQDimz24m0QvouJrhYq7AyT2VdgFoIVeJ3ES6rZLSaLMJrWd9iHaMtMeW1WH+ZSdMGf+KCz96JAhBh5cFkWYhHOPAkB0SHx96YNHwUJiznMLPKsbj1OPiQB1jO2FXY78qa5MIA5X1PfCd9PPsUBB5rObjZINvPA/VwAv5zuvGfd52g1rAkEAq458G9bwuF/Iqz5e2VZ4FUbIVPpB/hY+NOQdPsJwzb5AoWZGGrt/uevLxTXenWKYWIJyDYiUFWxcb7ss1VrxYQJAa6ZYFuTyC70iHTg1/rc/c6KqbK+HDYcRJI+7xZu5YwSfqDjfYCvi4hU9y5Xen5bQOxi1RBFtVfVq7N78i1/6zw==";
    String PUBLICKEY_WAP = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPv9yyavzOa8F3BjAw9KmBvtL/bqLLOoiKQFXlQMZBZAu6PwVSr5Acfj0ykshfUWHPlADUovpq6jrEV0aiuqnRc17rBoHWW4Qsf9v/HPo4mxnEqj2kjETeU/y/bLK/fUFdsB0wZGAiBFI5mdZvr21T+n65yN5sNxXE1j0H3SygSQIDAQAB";

    String PUBLICKEY_TEST = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";
    String PUBLICKEY_ORG = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPv9yyavzOa8F3BjAw9KmBvtL/bqLLOoiKQFXlQMZBZAu6PwVSr5Acfj0ykshfUWHPlADUovpq6jrEV0aiuqnRc17rBoHWW4Qsf9v/HPo4mxnEqj2kjETeU/y/bLK/fUFdsB0wZGAiBFI5mdZvr21T+n65yN5sNxXE1j0H3SygSQIDAQAB";
    String YT_PUB_KEY    = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";
    //String OID_PARTNER_WAP = "201408071000001543";
    //String PRIVATEKEY_WAP = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOilN4tR7HpNYvSBra/DzebemoAiGtGeaxa+qebx/O2YAdUFPI+xTKTX2ETyqSzGfbxXpmSax7tXOdoa3uyaFnhKRGRvLdq1kTSTu7q5s6gTryxVH2m62Py8Pw0sKcuuV0CxtxkrxUzGQN+QSxf+TyNAv5rYi/ayvsDgWdB3cRqbAgMBAAECgYEAj02d/jqTcO6UQspSY484GLsL7luTq4Vqr5L4cyKiSvQ0RLQ6DsUG0g+Gz0muPb9ymf5fp17UIyjioN+ma5WquncHGm6ElIuRv2jYbGOnl9q2cMyNsAZCiSWfR++op+6UZbzpoNDiYzeKbNUz6L1fJjzCt52w/RbkDncJd2mVDRkCQQD/Uz3QnrWfCeWmBbsAZVoM57n01k7hyLWmDMYoKh8vnzKjrWScDkaQ6qGTbPVL3x0EBoxgb/smnT6/A5XyB9bvAkEA6UKhP1KLi/ImaLFUgLvEvmbUrpzY2I1+jgdsoj9Bm4a8K+KROsnNAIvRsKNgJPWd64uuQntUFPKkcyfBV1MXFQJBAJGs3Mf6xYVIEE75VgiTyx0x2VdoLvmDmqBzCVxBLCnvmuToOU8QlhJ4zFdhA1OWqOdzFQSw34rYjMRPN24wKuECQEqpYhVzpWkA9BxUjli6QUo0feT6HUqLV7O8WqBAIQ7X/IkLdzLa/vwqxM6GLLMHzylixz9OXGZsGAkn83GxDdUCQA9+pQOitY0WranUHeZFKWAHZszSjtbe6wDAdiKdXCfig0/rOdxAODCbQrQs7PYy1ed8DuVQlHPwRGtokVGHATU=";
    //String PUBLICKEY_WAP = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSS/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";

    String NOTIFY_URL_WAP = "www.baidu.com";
    String SMS_PARAM_WAP = "{\"contract_type\":\"测试\",\"contact_way\":\"400-600-5200\"}";
}