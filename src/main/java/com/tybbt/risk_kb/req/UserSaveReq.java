package com.tybbt.risk_kb.req;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserSaveReq {

    @NotNull(message = "[登录名不能为空]")
    private String name;

    @NotNull(message = "[密码不能为空]")
    @Pattern(regexp = "^(?![0-9]+$)[0-9A-Za-z]{6,32}$", message = "[密码]至少包含数字和英文，长度6-32")
    private String password;

    private Integer age;

    @NotNull(message = "[工号不能为空]")
    private Long employeeid;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Long employeeId) {
        this.employeeid = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;

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

    @Override
    public String toString() {
        return "UserSaveReq{" +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", employeeId=" + employeeid +
                ", department='" + department + '\'' +
                '}';
    }
}