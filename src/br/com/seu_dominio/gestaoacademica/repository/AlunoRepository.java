package br.com.seu_dominio.gestaoacademica.repository;

import br.com.seu_dominio.gestaoacademica.model.Aluno;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private final String ARQUIVO_DADOS = "alunos.dat";

    // Responsabilidade: Salvar uma lista de alunos no arquivo.
    public void salvar(List<Aluno> alunos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DADOS))) {
            oos.writeObject(alunos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

    // Responsabilidade: Carregar a lista de alunos do arquivo.
    @SuppressWarnings("unchecked")
    public List<Aluno> carregar() {
        List<Aluno> alunos = new ArrayList<>();
        File arquivo = new File(ARQUIVO_DADOS);
        if (arquivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                alunos = (List<Aluno>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao carregar alunos: " + e.getMessage());
            }
        }
        return alunos;
    }
}