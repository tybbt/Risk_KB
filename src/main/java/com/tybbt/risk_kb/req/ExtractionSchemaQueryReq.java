package com.tybbt.risk_kb.req;

public class ExtractionSchemaQueryReq extends PageReq {
    private Long id;

    private Long relateKnowledge;

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

    @Override
    public String toString() {
        return "ExtractionSchemaQueryReq{" +
                "id=" + id +
                ", relateKnowledge=" + relateKnowledge +
                "} " + super.toString();
    }
}
