package br.edu.uepb.CadastroEscolar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.uepb.CadastroEscolar.domain.Professor;
import br.edu.uepb.CadastroEscolar.repository.ProfessorRepository;


@RestController
@RequestMapping("/professores")
public class ProfessorController {
  
  @Autowired
  private ProfessorRepository professorRepository;

  @GetMapping
  public List<Professor> getProfessores(){
    return professorRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Professor> getProfessorById(@PathVariable  Long id) {
    return professorRepository.findById(id);
  }

  @PostMapping
  public Professor createProfessor(@RequestBody Professor professor) {
    return professorRepository.save(professor);
  }

  @PutMapping("/{id}")
  public Professor updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professor) {
    return professorRepository.save(professor);
  }

  @DeleteMapping("/{id}")
  public void deleteProfessor(@PathVariable Long id) {
    professorRepository.delete(professorRepository.findById(id).get());
  }  
}