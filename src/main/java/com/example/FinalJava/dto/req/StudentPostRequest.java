package com.example.FinalJava.dto.req;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentPostRequest {
    String name;
    String surname;
    String email;
    LocalDate birthday;
    int course;;
    double annualFree;
    int uniId;
}
