package com.example.FinalJava.dto.req;

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
public class UniPutRequest {
    @NotBlank(message = "Universitetin adı boş ola bilməz")
    @Size(max = 100, message = "Universitetin adı maksimum 100 simvol ola bilər")
    String name;

    @NotBlank(message = "Fakültə adı boş ola bilməz")
    @Size(max = 100, message = "Fakültə adı maksimum 100 simvol ola bilər")
    String faculty;
}
