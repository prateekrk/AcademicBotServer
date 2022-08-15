package com.academicbot.pojo;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String userName;
    private String usn;
    private LocalDate dateOfBirth;
    private AdmissionDetail admissionDetail;
    private List<String> remarks;
    private NameModel name;
    private Semester semester;
}
