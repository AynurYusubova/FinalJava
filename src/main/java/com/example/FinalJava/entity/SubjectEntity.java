package com.example.FinalJava.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @NotBlank(message = "Subject adı boş ola bilməz")
    @Size(max = 100, message = "Subject adı 100 simvoldan çox ola bilməz")
    @Column(name="name",nullable=false,length=100)
    private String name;



    @Column(name="credits",nullable=false,length=100)
    private int credits;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private TeacherEntity teacher;
}
