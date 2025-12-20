package com.example.FinalJava.repostory;

import com.example.FinalJava.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepostory extends JpaRepository<StudentEntity,Integer> {
}
