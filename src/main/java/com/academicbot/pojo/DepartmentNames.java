package com.academicbot.pojo;

public enum DepartmentNames {
    CSE("Computer Science"),
    EC("Electronics And Communication"),
    IT("Information Technology"),
    EEE("Electrical and Electronics"),
    ME("Mechanical"),
    CE("Civil"),
    AUTO("Automobile"),
    IS("Information science"),
    BT("Bio-Technology");

    private String departmentName;
    DepartmentNames(String name) {
        this.departmentName = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
