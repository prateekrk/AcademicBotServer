package com.academicbot.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    private String courseName;
    private String courseId;
    private Faculty lecturer;
    private Course lab;
    private int credits;
    private String semester;
}
