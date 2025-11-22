package com.example.FinalJava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable=false,length=100)
    private String name;

    @Column(name="surname",nullable=false,length=100)
    private String surname;

    @Column(name="email",length=100)
    private String email;

    @Column(name="birthday",nullable=false,length=100)
    private LocalDate birthday;

    @Column(name="course",nullable=false,length=100)
    private int course;


    @Column(name="annual_free")
    private double annualFree;


    @ManyToOne
    @JoinColumn(name = "uni_id")
    private UniEntity uni;
}
