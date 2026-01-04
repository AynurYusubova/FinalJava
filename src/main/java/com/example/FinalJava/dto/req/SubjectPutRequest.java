package com.example.FinalJava.dto.req;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectPutRequest {

    @NotBlank(message = "Subject adı boş ola bilməz")
    @Size(max = 100, message = "Subject adı 100 simvoldan çox ola bilməz")
    String name;


    int credits;
}
