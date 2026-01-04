package com.example.FinalJava.dto.res;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherPutResponse {
    @NotBlank(message = "Name boş ola bilməz")
    @Size(max = 100, message = "Name 100 simvoldan çox ola bilməz")
    String name;

    @NotBlank(message = "Surname boş ola bilməz")
    @Size(max = 100, message = "Surname 100 simvoldan çox ola bilməz")
    String surname;

    String message;

}
