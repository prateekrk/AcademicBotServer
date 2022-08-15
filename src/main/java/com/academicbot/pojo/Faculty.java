package com.academicbot.pojo;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Faculty {
    private String userName;
    private String facultyName;
    private String idNumber;
    private LocalDate dateOfJoining;
    private LocalDate dateOfRelease;
    private DepartmentNames departmentNames;
    private Designation designation;
}
