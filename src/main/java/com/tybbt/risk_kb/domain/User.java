package com.tybbt.risk_kb.domain;

public class User {
    private Long id;

    private String name;

    private String password;

    private Integer age;

    private Long employeeid;

    private String department;

    private Integer authlevel;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAuthlevel() {
        return authlevel;
    }

    public void setAuthlevel(Integer authlevel) {
        this.authlevel = authlevel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", age=").append(age);
        sb.append(", employeeid=").append(employeeid);
        sb.append(", department=").append(department);
        sb.append(", authlevel=").append(authlevel);
        sb.append("]");
        return sb.toString();
    }
}