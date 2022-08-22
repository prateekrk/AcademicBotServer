package com.academicbot.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class AttendanceDetail {
    private String courseID;
    private int totalClassConducted;
    private int totalClassPresent;
    private String usn;
}
