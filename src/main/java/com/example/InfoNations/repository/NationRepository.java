package com.example.InfoNations.repository;

import com.example.InfoNations.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepository extends JpaRepository<Nation,Long> {
    Nation findNationById(Long id);
}
