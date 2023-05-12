package br.edu.uepb.project.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// Um aluno tem nome, matrícula e e-mail  (estes dois últimos devem ser únicos no banco).

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "matricula",unique = true)
  private String matricula;
  @Column(name = "email",unique = true)
  private String email;

  // 1 turma para varios alunos

  @ManyToOne
  @JoinColumn(name = "TurmaAluno_id", referencedColumnName = "id")
  private Turma turma;

  public Aluno(String name, String matricula, String email, Turma turma) {
    this.name = name;
    this.matricula = matricula;
    this.email = email;
    this.turma = turma;
  }
}
