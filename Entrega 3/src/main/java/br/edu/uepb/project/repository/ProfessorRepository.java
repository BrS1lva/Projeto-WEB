package br.edu.uepb.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.project.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{}