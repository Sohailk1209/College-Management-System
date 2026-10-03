package com.sohail.repository;

import com.sohail.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor , Long> {
}
