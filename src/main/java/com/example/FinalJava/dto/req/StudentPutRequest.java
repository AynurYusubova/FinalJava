package com.example.FinalJava.dto.req;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentPutRequest {
    @NotBlank(message = "Name boş ola bilməz")
    @Size(max = 100, message = "Name 100 simvoldan çox ola bilməz")
    String name;

    @NotBlank(message = "Surname boş ola bilməz")
    @Size(max = 100, message = "Surname 100 simvoldan çox ola bilməz")
    String surname;



    @Email(message = "Email düzgün formatda olmalıdır")
    @Size(max = 100, message = "Email 100 simvoldan çox ola bilməz")
    private String email;

    @NotNull(message = "Birthday boş ola bilməz")
    @Past(message = "Birthday keçmiş tarix olmalıdır")
    private LocalDate birthday;


    @Min(value = 1, message = "Course ən azı 1 olmalıdır")
    private int course;

    @PositiveOrZero(message = "Annual fee 0 və ya müsbət olmalıdır")
    private double annualFree;
}
