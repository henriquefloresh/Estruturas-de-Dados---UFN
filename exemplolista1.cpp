#include <cstdlib>
#include <iostream>
#include <string>
#define T 10

using namespace std;

#include "utilidades.h"

int main(){
    string vetorNomes[T];
    inicializar(vetorNomes);
    int totalNomesinseridos = 0;


    totalNomesinseridos = inserir("Davi", vetorNomes, totalNomesinseridos);
    totalNomesinseridos = inserir("Henrique", vetorNomes, totalNomesinseridos);
    totalNomesinseridos = inserir("Wilson", vetorNomes, totalNomesinseridos);

    if(totalNomesinseridos > 0){
        exibir(vetorNomes);
    } else {
        cout << "Vetor de nomes esta vazio\n";
    }

    string nome;
    cout << "Digite um nome: ";
    getline(cin,nome);

    int posicao;
    posicao = ondeEsta(nome, vetorNomes);

    if (posicao != -1){
        vetorNomes[posicao] = "#";
        totalNomesinseridos--;
        cout << "Nome encontrado e apagado na posicao: " << posicao << "\n";
    } else {
        cout << "Nome não encontrado!\n"
    }


    
    return 1;
}
