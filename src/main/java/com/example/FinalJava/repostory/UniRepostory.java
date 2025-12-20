package com.example.FinalJava.repostory;

import com.example.FinalJava.entity.UniEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UniRepostory extends JpaRepository<UniEntity, Integer> {

}
