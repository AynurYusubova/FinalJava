package com.example.FinalJava.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name="name",nullable=false,length=100)
    private String name;


    @Column(name = "surname",nullable=false,length=100)
    private String surname;

    @OneToMany(mappedBy = "teacher",cascade=CascadeType.ALL)
    private List<SubjectEntity> subjects;
}
