package br.edu.uepb.CadastroEscolar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.CadastroEscolar.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{}