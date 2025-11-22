package com.example.FinalJava.repostory;

import com.example.FinalJava.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepostory extends JpaRepository<StudentEntity,Integer> {
    Optional<StudentEntity> findById(Integer id);
}
