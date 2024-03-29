package br.edu.uepb.CadastroEscolar.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.uepb.CadastroEscolar.domain.Aluno;
import br.edu.uepb.CadastroEscolar.repository.AlunoRepository;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
  
  @Autowired
  private AlunoRepository alunoRepository;

  @GetMapping
  public List<Aluno> getALunos(){
    return alunoRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Aluno> getAlunoById(@PathVariable  Long id) {
    return alunoRepository.findById(id);
  }

  @PostMapping
  public Aluno createAluno(@RequestBody Aluno aluno) {
    return alunoRepository.save(aluno);
  }

  @PutMapping("/{id}")
  public Aluno updateAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
    return alunoRepository.save(aluno);
  }

  @DeleteMapping("/{id}")
  public void deleteAluno(@PathVariable Long id) {
    alunoRepository.delete(alunoRepository.findById(id).get());
  }  
}
