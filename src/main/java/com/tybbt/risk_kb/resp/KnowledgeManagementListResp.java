package com.tybbt.risk_kb.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

public class KnowledgeManagementListResp {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String name;

    private Integer state;

    private String category;

    private String linkTableName;

    private Date activateTime;

    private Date expireTime;

    private String manager;

    private String reviewer1;

    private String reviewer2;

    private String reviewer3;

    private Integer number;

    private Float useratio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLinkTableName() {
        return linkTableName;
    }

    public void setLinkTableName(String linkTableName) {
        this.linkTableName = linkTableName;
    }

    public Date getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Date activateTime) {
        this.activateTime = activateTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getReviewer1() {
        return reviewer1;
    }

    public void setReviewer1(String reviewer1) {
        this.reviewer1 = reviewer1;
    }

    public String getReviewer2() {
        return reviewer2;
    }

    public void setReviewer2(String reviewer2) {
        this.reviewer2 = reviewer2;
    }

    public String getReviewer3() {
        return reviewer3;
    }

    public void setReviewer3(String reviewer3) {
        this.reviewer3 = reviewer3;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getUseratio() {
        return useratio;
    }

    public void setUseratio(Float useratio) {
        this.useratio = useratio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", state=").append(state);
        sb.append(", category=").append(category);
        sb.append(", linkTableName=").append(linkTableName);
        sb.append(", activateTime=").append(activateTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", manager=").append(manager);
        sb.append(", reviewer1=").append(reviewer1);
        sb.append(", reviewer2=").append(reviewer2);
        sb.append(", reviewer3=").append(reviewer3);
        sb.append(", number=").append(number);
        sb.append(", useratio=").append(useratio);
        sb.append("]");
        return sb.toString();
    }
}