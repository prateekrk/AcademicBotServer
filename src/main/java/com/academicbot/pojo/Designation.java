package com.academicbot.pojo;

public enum Designation {
    DEAN("Dean"),
    STUDENT("STUDENT"),
    ASSISTANT_PROF("Assistant Professor"),
    PROF("Professor"),
    LAB_INSTRUCTOR("Lab Instructor");

    private final String value;
    Designation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
