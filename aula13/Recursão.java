/*Recursão é um recurso computacional de programação que substitui as instruções de repetição(for-while)
Toda a repetição obedece 3 pontos:
    A - inicialização da variável de controle
    B - teste de parada com variável de controle
    C - transformação de variável de controle
*/

import java.util.ArrayList;
import java.util.Random;

class Recursão{
    public static void popular(ArrayList<Integer> lista, int quantidade){
        Random gerador = new Random();
        int numero;
        for(int i = 0; i < quantidade; i++){
            numero = gerador.nextInt(100);
            lista.add(numero);
        }
    }

    public static void exibir(ArrayList<Integer> lista){
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
    
    public static void exibirR(ArrayList<Integer> lista, int n){
        if (n > 0) {
            //codigo antes do empilhamento
            exibirR(lista, n - 1);
            //codigo depois do empilhamento
        }
    }

     public static void somarR(ArrayList<Integer> lista, int n, int soma) {
        if (n > 0) {
            // Soma o elemento atual ao total acumulado
            soma = soma + lista.get(n - 1);
            // Passa para o próximo elemento
            somarR(lista, n - 1, soma);
        } else {
            // Caso base: quando n chega a 0, a lista acabou e mostramos o resultado
            System.out.println("A soma dos elementos da lista é: " + soma);
        }
    }

    // Passamos o acumulador 'contador' como parâmetro
    public static void contarParesR(ArrayList<Integer> lista, int n, int contador) {
        if (n > 0) {
            // Se o elemento atual for par, incrementa o contador
            if (lista.get(n - 1) % 2 == 0) {
                contador = contador + 1;
            }
            // Passa para o próximo elemento
            contarParesR(lista, n - 1, contador);
        } else {
            // Caso base: quando n chega a 0, mostramos o resultado final
            System.out.println("A quantidade de pares na lista é: " + contador);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int quantidade = 5;
        popular(lista, quantidade);
        
        System.out.println("--- Elementos da Lista ---");
        exibirR(lista, lista.size());
        System.out.println("--------------------------");
        
        // Iniciamos os acumuladores (soma e contador) com 0
        somarR(lista, lista.size(), 0);
        contarParesR(lista, lista.size(), 0);
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
