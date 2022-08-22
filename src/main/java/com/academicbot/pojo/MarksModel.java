package com.academicbot.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MarksModel {
    private String courseId;
    private String usn;
    private double marks;
}
