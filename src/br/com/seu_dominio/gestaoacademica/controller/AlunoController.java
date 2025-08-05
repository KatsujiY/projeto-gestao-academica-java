package br.com.seu_dominio.gestaoacademica.controller;

import br.com.seu_dominio.gestaoacademica.model.Aluno;
import br.com.seu_dominio.gestaoacademica.repository.AlunoRepository;
import java.util.List;

public class AlunoController {
    private AlunoRepository repository;
    private List<Aluno> alunos;

    public AlunoController() {
        this.repository = new AlunoRepository();
        this.alunos = repository.carregar(); // Carrega os dados na inicialização
    }

    // Responsabilidade: Orquestrar a adição de um novo aluno.
    public void adicionarAluno(int matricula, String nome, String curso) {
        Aluno novoAluno = new Aluno(matricula, nome, curso);
        this.alunos.add(novoAluno);
        this.repository.salvar(this.alunos); // Persiste a lista atualizada
    }

    // Responsabilidade: Fornecer a lista de alunos.
    public List<Aluno> listarAlunos() {
        return this.alunos;
    }
}
