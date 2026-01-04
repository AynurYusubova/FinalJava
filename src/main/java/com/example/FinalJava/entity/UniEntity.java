package com.example.FinalJava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Universitetin adı boş ola bilməz")
    @Size(max = 100, message = "Universitetin adı maksimum 100 simvol ola bilər")
    @Column(name="name",nullable = false,length = 100)
    private String name;

    @NotBlank(message = "Fakültə adı boş ola bilməz")
    @Size(max = 100, message = "Fakültə adı maksimum 100 simvol ola bilər")
    @Column(name="faculty",nullable = false,length = 100)
    private String faculty;

    @OneToMany(mappedBy = "uni", cascade = CascadeType.ALL)
    private List<StudentEntity> students;
}
