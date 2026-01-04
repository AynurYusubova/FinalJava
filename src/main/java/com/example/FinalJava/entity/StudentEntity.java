package com.example.FinalJava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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


    @NotBlank(message = "Name boş ola bilməz")
    @Size(max = 100, message = "Name 100 simvoldan çox ola bilməz")
    @Column(name="name",nullable=false,length=100)
    private String name;


    @NotBlank(message = "Surname boş ola bilməz")
    @Size(max = 100, message = "Surname 100 simvoldan çox ola bilməz")
    @Column(name="surname",nullable=false,length=100)
    private String surname;


    @Email(message = "Email düzgün formatda olmalıdır")
    @Size(max = 100, message = "Email 100 simvoldan çox ola bilməz")
    @Column(name="email",length=100)
    private String email;

    @NotNull(message = "Birthday boş ola bilməz")
    @Past(message = "Birthday keçmiş tarix olmalıdır")
    @Column(name="birthday",nullable=false,length=100)
    private LocalDate birthday;


    @Min(value = 1, message = "Course ən azı 1 olmalıdır")
    @Column(name="course",nullable=false,length=100)
    private int course;

    @PositiveOrZero(message = "Annual fee 0 və ya müsbət olmalıdır")
    @Column(name="annual_free")
    private double annualFree;


    @ManyToOne
    @JoinColumn(name = "uni_id")
    private UniEntity uni;
}
