package com.example.FinalJava.repostory;

import com.example.FinalJava.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TeacherRepostory extends JpaRepository<TeacherEntity,Integer> {

}
