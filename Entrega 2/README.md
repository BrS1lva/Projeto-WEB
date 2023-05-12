
## Execução do Exercicio 2

Crie uma aplicação Spring Boot com as rotas básicas para um CRUD de professores, alunos e turmas, com uma das duas lógicas de mapeamento: 

Um professor dá aula em várias turmas, e um aluno está em várias turmas.
OU
*Um professor dá aula em várias turmas, e um aluno está em uma única turma.*

Um aluno tem nome, matrícula e e-mail (estes dois últimos devem ser únicos no banco). Um professor tem nome, formação, matrícula e e-mail (estes dois últimos devem ser únicos no banco). Uma turma deve ter nome (da disciplina) e sala.

Para isso, sua aplicação precisa ter as seguintes rotas: 

~~~
GET /alunos
POST /alunos
GET /alunos/{id}
PUT /alunos/{id}
DELETE /alunos/{id}

GET /professores
POST /professores
GET /professores/{id}
PUT /professores/{id}
DELETE /professores/{id}

GET /turmas
POST /turmas
GET /turmas/{id}
PUT /turmas/{id}
DELETE /turmas/{id}
~~~

Crie também uma rota para vincular um aluno a um professor. Um possível design sugerido pode ser:

PATCH turmas/{turmaId}/matriculas/{alunoId}