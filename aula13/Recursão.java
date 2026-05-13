/*Recursão é um recurso computacional de programação que substitui as instruções de repetição(for-while)
Toda a repetição obedece 3 pontos:
    A - inicialização da variável de controle
    B - teste de parada com variável de controle
    C - transformação de variável de controle
*/

import java.util.ArrayList;
import java.util.Random;

class Recursao {
    public static void popular(ArrayList<Integer> lista, int quantidade) {
        Random gerador = new Random();
        int numero;
        for (int i = 0; i < quantidade; i++) {
            numero = gerador.nextInt(100);
            lista.add(numero);
        }
    }

    public static void exibir(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public static void exibirR(ArrayList<Integer> lista, int n) {
        if (n > 0) {
            exibirR(lista, n - 1);
            System.out.println(lista.get(n - 1));
        }
    }

    public static void somarR(ArrayList<Integer> lista, int n, int soma) {
        if (n > 0) {
            soma = soma + lista.get(n - 1);
            somarR(lista, n - 1, soma);
        } else {
            System.out.println("A soma dos elementos da lista é: " + soma);
        }
    }

    public static void contarParesR(ArrayList<Integer> lista, int n, int contador) {
        if (n > 0) {
            if (lista.get(n - 1) % 2 == 0) {
                contador = contador + 1;
            }
            contarParesR(lista, n - 1, contador);
        } else {
            System.out.println("A quantidade de pares na lista é: " + contador);
        }
    }

    // 1 - Conta quantas vezes um valor aparece na lista
    public static int contarOcorrencias(int[] lista, int tamanho, int valorPesquisa) {
        int contador = 0;
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] == valorPesquisa) {
                contador++;
            }
        }
        return contador;
    }

    // 2 - Substitui o valor de pesquisa pelo valor de substituição na lista
    public static void substituirValor(int[] lista, int tamanho, int valorPesquisa, int valorSubstituicao) {
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] == valorPesquisa) {
                lista[i] = valorSubstituicao;
            }
        }
    }

    // 3 - Verifica se a lista está ordenada
    public static boolean listaOrdenada(int[] lista, int tamanho) {
        for (int i = 1; i < tamanho; i++) {
            if (lista[i] < lista[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // 4 - Exibe todos os números múltiplos de 4
    public static void exibirMultiplosDe4(int[] lista, int tamanho) {
        System.out.print("Múltiplos de 4: ");
        for (int i = 0; i < tamanho; i++) {
            if (lista[i] % 4 == 0) {
                System.out.print(lista[i] + " ");
            }
        }
        System.out.println();
    }

    // Função utilitária para converter ArrayList<Integer> para int[]
    public static int[] toIntArray(ArrayList<Integer> lista) {
        int[] arr = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arr[i] = lista.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int quantidade = 5;
        popular(lista, quantidade);

        System.out.println("--- Elementos da Lista ---");
        exibirR(lista, lista.size());
        System.out.println("--------------------------");

        somarR(lista, lista.size(), 0);
        contarParesR(lista, lista.size(), 0);

        // Converter para int[] para usar as funções que trabalham com arrays
        int[] arr = toIntArray(lista);

        int ocorrencias = contarOcorrencias(arr, quantidade, arr[0]); // exemplo: procura pelo primeiro elemento
        System.out.println("Ocorrências do valor " + arr[0] + ": " + ocorrencias);

        substituirValor(arr, quantidade, arr[0], 99);
        System.out.println("Após substituição:");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        boolean ordenada = listaOrdenada(arr, quantidade);
        System.out.println("A lista está ordenada? " + ordenada);

        exibirMultiplosDe4(arr, quantidade);
    }
}

/*
Exercícios de fixação sobre o codigo base gerado. Faça métodos recursivos que:
1) receba uma lista, seu tamanho, valor de pesquisa. Caso o valor de pesquisa ocorre na lista,
 retornar quantas vezes ele aparece

2) recebe uma lista, seu tamanho, valor de pesquisa, valor de substituição. Caso o valor ocorra
 na lista, substituir o valor de pesquisa pelo valor de substituição

3) receba uma lista, seu tamanho e retorne TRUE se a lista ordenada, FALSE se a lista desordenada

4) receba uma lista e seu tamanho. O método deve exibir todos os números múltiplos de 4
 
*/
