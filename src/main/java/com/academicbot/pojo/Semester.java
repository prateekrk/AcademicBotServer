package com.academicbot.pojo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Semester {
    private String semester;
    private List<Course> courseList;
}
