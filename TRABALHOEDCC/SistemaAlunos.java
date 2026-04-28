package pkg;
import java.io.*;
import java.util.*;

public class SistemaAlunos {
    private List<Aluno> listaAlunos;

    public SistemaAlunos() {
        listaAlunos = new ArrayList<>();
    }

    // Ler arquivo CSV
    public void carregarDados(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                String nome = dados[0];
                String curso = dados[1];
                String sexo = dados[2];
                int ano = Integer.parseInt(dados[3]);

                Aluno aluno = new Aluno(nome, curso, sexo, ano);
                listaAlunos.add(aluno);
            }

            System.out.println("Dados carregados com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    // Ordenar por nome
    public void ordenarPorNome() {
        Collections.sort(listaAlunos, Comparator.comparing(Aluno::getNome));
    }

    // Ordenar por ano
    public void ordenarPorAno() {
        Collections.sort(listaAlunos, Comparator.comparingInt(Aluno::getAnoIngresso));
    }

    // Buscar aluno por nome exato
    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    // Quantidade de alunos por ano
    public void alunosPorAno() {
        Map<Integer, Integer> contagem = new HashMap<>();

        for (Aluno aluno : listaAlunos) {
            int ano = aluno.getAnoIngresso();
            contagem.put(ano, contagem.getOrDefault(ano, 0) + 1);
        }

        System.out.println("\nQuantidade de alunos por ano:");
        for (Map.Entry<Integer, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " aluno(s)");
        }
    }

    // Exibir lista
    public void exibirAlunos() {
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno);
        }
    }
}
