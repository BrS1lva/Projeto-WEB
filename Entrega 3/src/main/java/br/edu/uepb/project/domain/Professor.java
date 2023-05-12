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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Um professor tem nome, formação, matrícula e e-mail (estes dois últimos devem ser únicos no banco).

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "professore")

public class Professor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "formacao")
  private String formacao;

  @Column(name = "matricula", unique = true) //, unique = true
  private String matricula;

  @Column(name = "email", unique = true)
  private String email;

  @OneToMany(mappedBy = "professor")
  @JsonIgnore
  //@JsonIgnore
  private List<Turma> turmas = new ArrayList<>(); 
  
  public Professor(String name, String formacao, String matricula, String email){
    this.name = name;
    this.formacao = formacao;
    this.matricula = matricula;
    this.email = email;
  }
  public void addTurma(Turma turma){
    this.turmas.add(turma);
  }
}
