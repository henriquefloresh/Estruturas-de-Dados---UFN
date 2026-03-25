import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Estruturas {
    public static void gerarProcesso(ArrayList<Processo> lista){
        int id;
        String descricao;
        Scanner teclado = new Scanner(System.in);
        Random gerador = new Random();
        Processo tmp;

        //Laço de repetição para colocar quantos objetos que quiser na lista
        while(true){
            id = gerador.nextInt(500);
            System.out.print("Descricao do processo: ");
            descricao = teclado.nextLine().toUpperCase();
            if(descricao.equals("SAIR")) {
                break;
            }
            tmp = new Processo(id, descricao);
            if(!lista.contains(tmp)){
                lista.add(tmp);
            }

        }
    }

    public static void exibirProcesso(ArrayList<Processo> lista){
        System.out.println("Quantidade de processos: "+ lista.size());

        //variável usada para ordenação: descricao
        lista.sort((p1, p2) -> p1.descricao.compareTo(p2.descricao));

        for(Processo p : lista){
            System.out.println(p);
        }
    }

    public static void localizarProcesso(ArrayList<Processo> lista){
        Scanner teclado = new Scanner(System.in);
        String descricao;

        //rotina para pesquisar parte da descricao na lista de processos
        System.out.print("Digite a palavra ou expressao que deseja localizar: ");
        descricao = teclado.nextLine().toUpperCase();

        for(Processo p : lista){
            if(p.descricao.contains(descricao)){
                System.out.println(p);
            }
        }
    }

    public static void removerProcessos(ArrayList<Processo> lista){
        Scanner teclado = new Scanner(System.in);
        String descricao;
        
        System.out.print("Digite a palavra ou expressao que deseja remover: ");
        descricao = teclado.nextLine().toUpperCase();//lê as palavras ou expressões e transforma para maiúculo

        for(int i = 0; i < lista.size(); i++){ //percorre via indice
            if(lista.get(i).descricao.contains(descricao)){
                lista.remove(i);
                i--; // importante para não pular elementos
            }
        }

        System.out.println("Processos removidos com sucesso!");
        System.out.println("\nLista atualizada:");
        //percorre via objeto
        for(Processo p : lista){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        ArrayList<Processo> lista = new ArrayList<>(); //O que esta dentro do < > corresponde ao tipo de objeto que a lista armazena

        Estruturas.gerarProcesso(lista);
        Estruturas.exibirProcesso(lista);
        Estruturas.localizarProcesso(lista);
        Estruturas.removerProcessos(lista);



    }
}
