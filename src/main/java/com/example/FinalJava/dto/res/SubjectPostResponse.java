package com.example.FinalJava.dto.res;

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
public class SubjectPostResponse {
    @NotBlank(message = "Subject adı boş ola bilməz")
    @Size(max = 100, message = "Subject adı 100 simvoldan çox ola bilməz")
    String name;

    @Min(value = 1, message = "Credits ən azı 1 olmalıdır")
    int credits;

    String message;

}
