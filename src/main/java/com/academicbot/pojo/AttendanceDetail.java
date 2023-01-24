package com.academicbot.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class AttendanceDetail {
    private AttendanceModel attendance;
    private String usn;
}
