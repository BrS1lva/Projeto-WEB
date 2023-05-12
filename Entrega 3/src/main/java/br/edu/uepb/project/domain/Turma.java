package br.edu.uepb.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Uma turma deve ter nome (da disciplina) e sala.

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "turma")
public class Turma {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "sala")
  private String sala;

  // Varios alunos para 1 turma
  @OneToMany(mappedBy = "turma")
  @JsonIgnore
  private List < Aluno > alunos = new ArrayList<>(); 

  // Varias turmas para 1 professor
  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "ProfessorTurma_id", referencedColumnName = "id")
  private Professor professor;
 
  public void addAluno(Aluno aluno){
    this.alunos.add(aluno);
  }
  /***
  public Turma(String name, String sala) {
    this.name = name;
    this.sala = sala;
  }
 */
}
