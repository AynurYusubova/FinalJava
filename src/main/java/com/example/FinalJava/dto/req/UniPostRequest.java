package com.example.FinalJava.dto.req;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniPostRequest {
    String name;
    String faculty;
}
