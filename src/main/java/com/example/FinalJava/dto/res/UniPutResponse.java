package com.example.FinalJava.dto.res;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniPutResponse {
    String name;
    String faculty;
    String message;
}
