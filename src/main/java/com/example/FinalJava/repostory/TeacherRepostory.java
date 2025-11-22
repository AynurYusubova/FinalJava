package com.example.FinalJava.repostory;

import com.example.FinalJava.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepostory extends JpaRepository<TeacherEntity,Integer> {
    Optional<TeacherEntity> findByName(String name);

    Integer id(int id);
}
