package com.shoumipay.domain;

import java.util.Date;

public class MemberInfoChangeRecord {
    private Long id;

    private Long uid;

    private String tableName;

    private String columnName;

    private String preChange;

    private String postChange;

    private Date changeTime;

    public MemberInfoChangeRecord() {
    }

    public MemberInfoChangeRecord(Long uid, String tableName, String columnName, String preChange, String postChange, Date changeTime) {
        this.uid = uid;
        this.tableName = tableName;
        this.columnName = columnName;
        this.preChange = preChange;
        this.postChange = postChange;
        this.changeTime = changeTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getPreChange() {
        return preChange;
    }

    public void setPreChange(String preChange) {
        this.preChange = preChange == null ? null : preChange.trim();
    }

    public String getPostChange() {
        return postChange;
    }

    public void setPostChange(String postChange) {
        this.postChange = postChange == null ? null : postChange.trim();
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    @Override
    public String toString() {
        return "MemberInfoChangeRecord{" +
                "id=" + id +
                ", uid=" + uid +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", preChange='" + preChange + '\'' +
                ", postChange='" + postChange + '\'' +
                ", changeTime=" + changeTime +
                '}';
    }
}