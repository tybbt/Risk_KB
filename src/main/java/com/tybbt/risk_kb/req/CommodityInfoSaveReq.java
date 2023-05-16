package com.tybbt.risk_kb.req;

public class CommodityInfoSaveReq {
    private Long id;

    private Integer informationType;

    private String trigger;

    private String entities;

    private String eValues;

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

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getEntities() {
        return entities;
    }

    public void setEntities(String entities) {
        this.entities = entities;
    }

    public String geteValues() {
        return eValues;
    }

    public void seteValues(String eValues) {
        this.eValues = eValues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", informationType=").append(informationType);
        sb.append(", trigger=").append(trigger);
        sb.append(", entities=").append(entities);
        sb.append(", eValues=").append(eValues);
        sb.append("]");
        return sb.toString();
    }
}