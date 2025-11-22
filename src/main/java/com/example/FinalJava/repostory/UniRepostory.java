package com.example.FinalJava.repostory;

import com.example.FinalJava.entity.UniEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UniRepostory extends JpaRepository<UniEntity, Integer> {
    Optional<UniEntity> findById(int id);
}
