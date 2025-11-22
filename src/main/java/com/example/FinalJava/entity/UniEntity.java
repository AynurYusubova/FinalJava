package com.example.FinalJava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@Table(name="uni")
@Builder
public class UniEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="name",nullable = false,length = 100)
    private String name;


    @Column(name="faculty",nullable = false,length = 100)
    private String faculty;

    @OneToMany(mappedBy = "uni", cascade = CascadeType.ALL)
    private List<StudentEntity> students;
}
