package com.academicbot.Helpers;

public enum Tables {
    MARKS("MARKS"), ATTENDANCE("ATTENDANCE"), COURSE("COURSE");

    private String name;
    private Tables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
