package com.tybbt.risk_kb.req;

public class CategorySearchReq extends PageReq{

    private String name;

    private Long parent;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategorySearchReq{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", description='" + description + '\'' +
                '}';
    }
}