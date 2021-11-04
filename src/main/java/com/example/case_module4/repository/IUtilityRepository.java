package com.example.case_module4.repository;

import com.example.case_module4.model.Utility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUtilityRepository extends JpaRepository<Utility,Long> {
}