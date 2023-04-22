package com.tybbt.risk_kb.domain;

public class TaxMisreport {
    private Long id;

    private String gName;

    private Long taxId;

    private Long misTaxId;

    private String relationParams;

    private String relationValues;

    private Integer taxRateDifference;

    private String quarantineDifference;

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

    public Long getMisTaxId() {
        return misTaxId;
    }

    public void setMisTaxId(Long misTaxId) {
        this.misTaxId = misTaxId;
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

    public Integer getTaxRateDifference() {
        return taxRateDifference;
    }

    public void setTaxRateDifference(Integer taxRateDifference) {
        this.taxRateDifference = taxRateDifference;
    }

    public String getQuarantineDifference() {
        return quarantineDifference;
    }

    public void setQuarantineDifference(String quarantineDifference) {
        this.quarantineDifference = quarantineDifference;
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
        sb.append(", misTaxId=").append(misTaxId);
        sb.append(", relationParams=").append(relationParams);
        sb.append(", relationValues=").append(relationValues);
        sb.append(", taxRateDifference=").append(taxRateDifference);
        sb.append(", quarantineDifference=").append(quarantineDifference);
        sb.append("]");
        return sb.toString();
    }
}