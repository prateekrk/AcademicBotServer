package com.academicbot.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class AttendanceModel {
    private String courseID;
    private int totalClassConducted;
    private int totalClassPresent;
}
