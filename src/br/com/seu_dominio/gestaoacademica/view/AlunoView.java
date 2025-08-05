package br.com.seu_dominio.gestaoacademica.view;

import br.com.seu_dominio.gestaoacademica.controller.AlunoController;
import br.com.seu_dominio.gestaoacademica.controller.AlunoController;
import br.com.seu_dominio.gestaoacademica.model.Aluno;
import java.util.List;

public class AlunoView {
    private AlunoController controller;

    public AlunoView(AlunoController controller) {
        this.controller = controller;
    }

    // Responsabilidade: Exibir todos os alunos para o usuário.
    public void exibirAlunos() {
        List<Aluno> alunos = controller.listarAlunos();
        System.out.println("\n--- Lista de Alunos Cadastrados ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
        System.out.println("------------------------------------");
    }
}