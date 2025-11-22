package com.example.FinalJava.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name="name",nullable=false,length=100)
    private String name;

    @Column(name="credits",nullable=false,length=100)
    private int credits;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private TeacherEntity teacher;
}
