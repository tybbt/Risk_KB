package com.tybbt.risk_kb.req;

public class TaxReportSaveReq {
    private Long id;

    private String gName;

    private Long taxId;

    private String relationParams;

    private String relationValues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
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
        sb.append(", gName=").append(gName);
        sb.append(", taxId=").append(taxId);
        sb.append(", relationParams=").append(relationParams);
        sb.append(", relationValues=").append(relationValues);
        sb.append("]");
        return sb.toString();
    }
}