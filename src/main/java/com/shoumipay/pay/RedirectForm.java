package com.shoumipay.pay;


import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class RedirectForm {
    static public String autoPost(String uri, String key, String value) {
        String html = "<form id='llpaysubmit' name='llpaysubmit' action='"+uri+"' method='post'>\n";
        html += "<input type='hidden' name='"+key+"' value='"+value+"'/>\n";
        html += "<input type='submit' value='提交'></form>\n";
        html += "<script>document.forms['llpaysubmit'].submit();</script>";
        return html;
    }

    static public String autoPost(String uri, List<String> keys, List<String> values) {
        String html = "<form id='llpaysubmit' name='llpaysubmit' action='"+uri+"' method='post'>\n";
        for (int i = 0; i<keys.size() && i < values.size(); i++ ) {
            html += "<input type='hidden' name='" + keys.get(i) + "' value='" + values.get(i) + "'/>\n";
        }
        html += "<input type='submit' value='提交'></form>\n";
        html += "<script>document.forms['llpaysubmit'].submit();</script>";
        return html;
    }
}
