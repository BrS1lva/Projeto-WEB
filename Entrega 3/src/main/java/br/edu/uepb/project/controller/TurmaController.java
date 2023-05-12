package br.edu.uepb.project.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.uepb.project.domain.Aluno;
import br.edu.uepb.project.domain.Professor;
import br.edu.uepb.project.domain.Turma;
import br.edu.uepb.project.exception.ResourceNotFoundException;
import br.edu.uepb.project.repository.AlunoRepository;
import br.edu.uepb.project.repository.ProfessorRepository;
import br.edu.uepb.project.repository.TurmaRepository;
import io.swagger.annotations.ApiOperation;;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

  @Autowired
  private TurmaRepository turmaRepository;
  @Autowired
  private AlunoRepository alunoRepository;
  @Autowired
  private ProfessorRepository professorRepository;

  @GetMapping
  public List<Turma> getTurmas() {
    return turmaRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Turma> getTurmaById(@PathVariable Long id) {
    return turmaRepository.findById(id);
  }

  @PostMapping
  public Turma createTurma(@RequestBody Turma turma) {
    return turmaRepository.save(turma);
  }

  @PutMapping("/{id}")
  public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
    return turmaRepository.save(turma);
  }

  @DeleteMapping("/{id}")
  public void deleteTurma(@PathVariable Long id) {
    turmaRepository.delete(turmaRepository.findById(id).get());
  }
  
	@Transactional
  @PatchMapping("/{turmaId}/MatricularAluno/{alunoId}")
	@ApiOperation(value = "Vincula um aluno a uma turma. (MATRICULA)")
  public ResponseEntity<Turma> MatricularAlunoTurma(@PathVariable("turmaId") Long turmaId, @PathVariable("alunoId") Long alunoId) {
    Turma turma = turmaRepository.findById(turmaId)
            .orElseThrow(() -> new ResourceNotFoundException("Turma not found with id: " + turmaId));

    Aluno aluno = alunoRepository.findById(alunoId)
            .orElseThrow(() -> new ResourceNotFoundException("Aluno not found with id: " + alunoId));
    turma.addAluno(aluno);
    aluno.setTurma(turma);
    Turma updatedTurma = turmaRepository.save(turma);
    //Aluno udpateAluno =  alunoRepository.save(aluno);
    return ResponseEntity.ok(updatedTurma);
  }

  @Transactional
  @PatchMapping("/{turmaId}/VincularProfessor/{professorId}")
	@ApiOperation(value = "Vincula um aluno a uma turma. (MATRICULA)")
  public ResponseEntity<Turma> VincularProfessorTurma(@PathVariable("turmaId") Long turmaId, @PathVariable("professorId") Long professorId) {
    Turma turma = turmaRepository.findById(turmaId)
            .orElseThrow(() -> new ResourceNotFoundException("Turma not found with id: " + turmaId));

    Professor professor = professorRepository.findById(professorId)
            .orElseThrow(() -> new ResourceNotFoundException("Aluno not found with id: " + professorId));
    turma.setProfessor(professor);
    professor.addTurma(turma);
    Turma updatedTurma = turmaRepository.save(turma);
    //Aluno udpateAluno =  alunoRepository.save(aluno);
    return ResponseEntity.ok(updatedTurma);
  }

}