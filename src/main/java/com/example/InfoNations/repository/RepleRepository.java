package com.example.InfoNations.repository;

import com.example.InfoNations.entity.Reple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepleRepository extends JpaRepository<Reple,Long> {
    Reple findRepleById(Long id);
}
