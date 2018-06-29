package com.shoumipay.tools;

import com.shoumipay.domain.GoodsOrder;
import com.shoumipay.domain.Member;
import com.shoumipay.service.admin.ExamineService;

import java.util.List;

/**
 * Created by Tang on 2017/10/26.
 */
public class ExamineScore {

    private Member member;
    private List<ExamineService> rules;
    private int initScore;
    private int line;

    public ExamineScore(Member member, List<ExamineService> rules, int initScore, int line) {
        this.member = member;
        this.rules = rules;
        this.initScore = initScore;
        this.line = line;
    }

    public ExamineService pass() {
        for (ExamineService rule : rules) {
            initScore += rule.examine(member);
            if (initScore < line) return rule;
        }
        return null;
    }

}
