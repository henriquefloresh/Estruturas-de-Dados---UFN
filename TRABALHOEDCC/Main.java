package pkg;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaAlunos sistema = new SistemaAlunos();

        // Carregar CSV
        sistema.carregarDados("alunos.csv");

        // Ordenar por nome
        System.out.println("\n--- Lista ordenada por nome ---");
        sistema.ordenarPorNome();
        sistema.exibirAlunos();

        // Ordenar por ano
        System.out.println("\n--- Lista ordenada por ano ---");
        sistema.ordenarPorAno();
        sistema.exibirAlunos();

        // Buscar aluno
        Scanner teclado = new Scanner(System.in);

        System.out.print("\nDigite o nome do aluno para buscar: ");
        String nomeBusca = teclado.nextLine();

        Aluno resultado = sistema.buscarAluno(nomeBusca);

        if (resultado != null) {
            System.out.println("\nAluno(a) encontrado:");
            System.out.println(resultado);
        } else {
            System.out.println("\nAluno(a) não encontrado.");
        }

        // Relatório por ano
        sistema.alunosPorAno();

        teclado.close();
    }
}
