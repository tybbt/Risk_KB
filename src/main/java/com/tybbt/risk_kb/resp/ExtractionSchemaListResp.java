package com.tybbt.risk_kb.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;

public class ExtractionSchemaListResp {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long relateKnowledge;

    private String creator;

    private Date expireTime;

    private String schema;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelateKnowledge() {
        return relateKnowledge;
    }

    public void setRelateKnowledge(Long relateKnowledge) {
        this.relateKnowledge = relateKnowledge;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
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
        sb.append(", relateKnowledge=").append(relateKnowledge);
        sb.append(", creator=").append(creator);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", schema=").append(schema);
        sb.append("]");
        return sb.toString();
    }
}