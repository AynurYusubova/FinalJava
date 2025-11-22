package com.example.FinalJava.dto.res;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentPostResponse {
    String name;
    String surname;
    String email;
    LocalDate birthday;
    int course;;
    double annualFree;
    String message;
}
