package com.tybbt.risk_kb.domain;

import java.util.Date;

public class ExtractionTask {
    private Long id;

    private String name;

    private String category;

    private Date activateTime;

    private Date expireTime;

    private Long manager;

    private Long reviewer1;

    private Long reviewer2;

    private Long reviewer3;

    private String relationParams;

    private String relationValues;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public Long getReviewer1() {
        return reviewer1;
    }

    public void setReviewer1(Long reviewer1) {
        this.reviewer1 = reviewer1;
    }

    public Long getReviewer2() {
        return reviewer2;
    }

    public void setReviewer2(Long reviewer2) {
        this.reviewer2 = reviewer2;
    }

    public Long getReviewer3() {
        return reviewer3;
    }

    public void setReviewer3(Long reviewer3) {
        this.reviewer3 = reviewer3;
    }

    public String getRelationParams() {
        return relationParams;
    }

    public void setRelationParams(String relationParams) {
        this.relationParams = relationParams;
    }

    public String getRelationValues() {
        return relationValues;
    }

    public void setRelationValues(String relationValues) {
        this.relationValues = relationValues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", category=").append(category);
        sb.append(", activateTime=").append(activateTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", manager=").append(manager);
        sb.append(", reviewer1=").append(reviewer1);
        sb.append(", reviewer2=").append(reviewer2);
        sb.append(", reviewer3=").append(reviewer3);
        sb.append(", relationParams=").append(relationParams);
        sb.append(", relationValues=").append(relationValues);
        sb.append("]");
        return sb.toString();
    }
}