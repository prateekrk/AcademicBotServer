package com.academicbot.pojo;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdmissionDetail {
    private LocalDate dateOfAdmission;
    private String department;
    private LocalDate dateOfFinish;
}
