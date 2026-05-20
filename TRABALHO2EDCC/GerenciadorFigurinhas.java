/*Fazer um programa em Java  para gerenciar figurinhas da copa 2026. O programa deve persistir e identificar figurinhas para troca entre duas pessoas.
A classe básica de ver ser:
Figura:
    nomeSelecao
    numeroFigura
    descricao //nome do jogador, brasao, ou bandeira
    quantidade //opcional, usada nas repetidas
    rara (boolean)
 
O menu deve ser:
Menu
1 - Cadastrar figuras repetidas pessoais (persistidas em arquivo csv figuras_repetidas_pessoais.csv e adicionadas na arvore_repetidas_pessoais)
2 - Listar figuras repetidas pessoais (mostrar a arvore respectiva)
3 - Cadastrar figuras desejadas pessoais (persistidas em arquivo csv figuras_desejadas_pessoais.csv e adicionadas na arvore_desejadas_pessoais)
4 - Listar figuras desejadas pessoais (mostrar a arvore respectiva)
5 - Carregar figuras repetidas OUTRO (carregar o arquivo, listar as figuras e mostrar as figuras que dão match com arvore_desejadas_pessoais)
6 - Carregar figuras desejadas OUTRO (carregar o arquivo, listar as figuras e mostrar as figuras que dão match com arvore_repetidas_pessoais)
7 - Sair
Opção:
 
Toda vez que o programa for iniciado, os arquivos csv pessoais devem ser populados em suas listas respectivas.*/

import java.io.*;
import java.util.*;

// Classe Básica Figura
class Figura implements Comparable<Figura> {
    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    // Getters e Setters
    public String getNomeSelecao() { return nomeSelecao; }
    public int getNumeroFigura() { return numeroFigura; }
    public String getDescricao() { return descricao; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public boolean isRara() { return rara; }

    // Ordenação automática pelo número da figurinha na Árvore
    @Override
    public int compareTo(Figura outra) {
        return Integer.compare(this.numeroFigura, outra.numeroFigura);
    }

    // Conversão para linha de arquivo CSV
    public String toCSV() {
        return nomeSelecao + ";" + numeroFigura + ";" + descricao + ";" + quantidade + ";" + rara;
    }

    // Correção aqui: mapeando os índices corretamente do array
    public static Figura fromCSV(String linha) {
        String[] partes = linha.split(";");
        return new Figura(
            partes[0],                        // nomeSelecao
            Integer.parseInt(partes[1]),      // numeroFigura
            partes[2],                        // descricao
            Integer.parseInt(partes[3]),      // quantidade
            Boolean.parseBoolean(partes[4])   // rara
        );
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - %s (Qtd: %d) %s", 
            numeroFigura, nomeSelecao, descricao, quantidade, rara ? "[RARA]" : "");
    }
}

// Classe Principal do Sistema
public class GerenciadorFigurinhas {
    private static final String CSV_REPETIDAS = "figuras_repetidas_pessoais.csv";
    private static final String CSV_DESEJADAS = "figuras_desejadas_pessoais.csv";

    private static TreeSet<Figura> arvoreRepetidasPessoais = new TreeSet<>();
    private static TreeSet<Figura> arvoreDesejadasPessoais = new TreeSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicialização automática dos dados
        carregarCSV(CSV_REPETIDAS, arvoreRepetidasPessoais);
        carregarCSV(CSV_DESEJADAS, arvoreDesejadasPessoais);

        int opcao = 0;
        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
            }
            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine();
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("\n=== GERENCIADOR DE FIGURINHAS COPA 2026 ===");
        System.out.println("1 - Cadastrar figuras repetidas pessoais");
        System.out.println("2 - Listar figuras repetidas pessoais");
        System.out.println("3 - Cadastrar figuras desejadas pessoais");
        System.out.println("4 - Listar figuras desejadas pessoais");
        System.out.println("5 - Carregar figuras repetidas OUTRO (Ver Matches)");
        System.out.println("6 - Carregar figuras desejadas OUTRO (Ver Matches)");
        System.out.println("7 - Sair");
        System.out.print("Opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarFigura(CSV_REPETIDAS, arvoreRepetidasPessoais);
                break;
            case 2:
                listarArvore(arvoreRepetidasPessoais, "REPETIDAS PESSOAIS");
                break;
            case 3:
                cadastrarFigura(CSV_DESEJADAS, arvoreDesejadasPessoais);
                break;
            case 4:
                listarArvore(arvoreDesejadasPessoais, "DESEJADAS PESSOAIS");
                break;
            case 5:
                processarArquivoOutro(true);
                break;
            case 6:
                processarArquivoOutro(false);
                break;
            case 7:
                System.out.println("Saindo do programa. Boa sorte com o álbum!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarFigura(String nomeArquivo, TreeSet<Figura> arvore) {
        System.out.println("\n--- Cadastro de Figura ---");
        System.out.print("Seleção: ");
        String selecao = scanner.nextLine();
        System.out.print("Número da Figura: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição (Jogador/Brasão): ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine());
        System.out.print("É rara? (true/false): ");
        boolean rara = Boolean.parseBoolean(scanner.nextLine());

        Figura nova = new Figura(selecao, numero, descricao, qtd, rara);
        
        if (arvore.contains(nova)) {
            for (Figura f : arvore) {
                if (f.getNumeroFigura() == numero) {
                    f.setQuantidade(f.getQuantidade() + qtd);
                    break;
                }
            }
        } else {
            arvore.add(nova);
        }

        salvarCSV(nomeArquivo, arvore);
        System.out.println("Figura salva com sucesso!");
    }

    // Correção aqui: substituído por um loop tradicional para evitar erros de compilação do System.out::println
    private static void listarArvore(TreeSet<Figura> arvore, String titulo) {
        System.out.println("\n--- LISTA DE FIGURAS " + titulo + " ---");
        if (arvore.isEmpty()) {
            System.out.println("Nenhuma figurinha cadastrada nesta lista.");
            return;
        }
        for (Figura f : arvore) {
            System.out.println(f);
        }
    }

    // Correção aqui: loops internos ajustados para impressão segura
    private static void processarArquivoOutro(boolean isRepetidasOutro) {
        System.out.print("\nDigite o nome do arquivo CSV do outro colecionador (ex: outro.csv): ");
        String nomeArquivo = scanner.nextLine();
        
        TreeSet<Figura> arvoreOutro = new TreeSet<>();
        carregarCSV(nomeArquivo, arvoreOutro);

        if (arvoreOutro.isEmpty()) return;

        if (isRepetidasOutro) {
            System.out.println("\n--- FIGURAS REPETIDAS DO OUTRO ---");
            for (Figura f : arvoreOutro) {
                System.out.println(f);
            }
            
            System.out.println("\n🤝 MATCHES (Ele tem repetida o que você QUER):");
            boolean match = false;
            for (Figura f : arvoreOutro) {
                if (arvoreDesejadasPessoais.contains(f)) {
                    System.out.println("-> " + f);
                    match = true;
                }
            }
            if (!match) System.out.println("Nenhum match encontrado.");
        } else {
            System.out.println("\n--- FIGURAS DESEJADAS DO OUTRO ---");
            for (Figura f : arvoreOutro) {
                System.out.println(f);
            }
            
            System.out.println("\n🤝 MATCHES (Você tem repetida o que ele QUER):");
            boolean match = false;
            for (Figura f : arvoreOutro) {
                if (arvoreRepetidasPessoais.contains(f)) {
                    System.out.println("-> " + f);
                    match = true;
                }
            }
            if (!match) System.out.println("Nenhum match encontrado.");
        }
    }

    private static void salvarCSV(String nomeArquivo, TreeSet<Figura> arvore) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Figura f : arvore) {
                writer.println(f.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo " + nomeArquivo);
        }
    }

    private static void carregarCSV(String nomeArquivo, TreeSet<Figura> arvore) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            arvore.clear();
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    arvore.add(Figura.fromCSV(linha));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo " + nomeArquivo);
        }
    }
}

