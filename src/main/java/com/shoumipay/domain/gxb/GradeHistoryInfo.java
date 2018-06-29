package com.shoumipay.domain.gxb;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaojun on 2017/9/27.
 */
public class GradeHistoryInfo implements Serializable {
    private static final long serialVersionUID = 702797648043308087L;
    private Date changeDate;
    private String changeToGrade;

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeToGrade() {
        return changeToGrade;
    }

    public void setChangeToGrade(String changeToGrade) {
        this.changeToGrade = changeToGrade;
    }
}
