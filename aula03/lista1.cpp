#include <iostream>
#include <cstdlib>
#include <vector> //para a lista

#include "biblioteca.h"

using namespace std;

int main() {
    //declarando uma lista
    vector<int>  listaNumeros;

    int quantidadeNumeros;
    int faixaInicial = 10, faixaFinal = 50;
    vector<int>  listaResultados;

    cout << "Digite quantos numeros quer gerar: ";
    cin >> quantidadeNumeros;

    popularListaAleatoria(listaNumeros, quantidadeNumeros, faixaInicial, faixaFinal);
    exibirLista(listaNumeros);

    copiarListaSemReplicados(listaNumeros, listaResultados);
    exibirLista(listaResultados);
    


return 1;
}
