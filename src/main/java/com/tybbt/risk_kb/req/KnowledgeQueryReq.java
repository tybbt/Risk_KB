package com.tybbt.risk_kb.req;

public class KnowledgeQueryReq extends PageReq {

    private Long kid;

    private String values;

    public Long getKid() {
        return kid;
    }

    public void setKid(Long kid) {
        this.kid = kid;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", kid=").append(kid);
        sb.append(", values=").append(values);
        sb.append("]");
        return sb.toString();
    }
}