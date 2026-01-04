package com.example.FinalJava.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @NotBlank(message = "Name boş ola bilməz")
    @Size(max = 100, message = "Name 100 simvoldan çox ola bilməz")
    @Column(name="name",nullable=false,length=100)
    private String name;

    @NotBlank(message = "Surname boş ola bilməz")
    @Size(max = 100, message = "Surname 100 simvoldan çox ola bilməz")
    @Column(name = "surname",nullable=false,length=100)
    private String surname;

    @OneToMany(mappedBy = "teacher",cascade=CascadeType.ALL)
    private List<SubjectEntity> subjects;
}
