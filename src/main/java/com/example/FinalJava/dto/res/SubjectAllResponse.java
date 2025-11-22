package com.example.FinalJava.dto.res;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectAllResponse {
    int id;
    String name;
    int credits;
}
