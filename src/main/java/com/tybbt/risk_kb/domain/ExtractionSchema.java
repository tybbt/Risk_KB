package com.tybbt.risk_kb.domain;

import java.util.Date;

public class ExtractionSchema {
    private Long id;

    private Integer informationType;

    private Long creator;

    private Date expireTime;

    private String schema;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInformationType() {
        return informationType;
    }

    public void setInformationType(Integer informationType) {
        this.informationType = informationType;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", informationType=").append(informationType);
        sb.append(", creator=").append(creator);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", schema=").append(schema);
        sb.append("]");
        return sb.toString();
    }
}