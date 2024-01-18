package com.example.InfoNations.repository;

import com.example.InfoNations.entity.Nation;
import com.example.InfoNations.entity.Reple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RepleRepository extends JpaRepository<Reple,Long> {
    Reple findRepleById(Long id);

    List<Reple> findReplesByNationId(Long id);
}

