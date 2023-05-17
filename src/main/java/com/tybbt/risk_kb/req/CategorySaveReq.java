package com.tybbt.risk_kb.req;

public class CategorySaveReq {

    private Long id;

    private String name;

    private Long parent;

    private String description;

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
        return "CategorySaveReq{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                ", description='" + description + '\'' +
                '}';
    }
}