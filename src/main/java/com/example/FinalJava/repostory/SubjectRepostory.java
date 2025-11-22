package com.example.FinalJava.repostory;

import com.example.FinalJava.entity.SubjectEntity;
import com.example.FinalJava.entity.UniEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepostory extends JpaRepository<SubjectEntity,Integer> {
    Optional<SubjectEntity> findById(int id);;
}
