#include <iostream>
#include <cstdlib>
#include <vector> //para a lista
#include <ctime>

using namespace std;

/**
 * @brief metodo que popula uma lista com numeros inteiros aleatorios dentro de uma faixa
 * 
 * @param lista contem os numeros aleatorios gerados
 * @param quantidadeNumeros contem quantos numeros se deseja inseriri na lista
 * @param faixaInicial contem o numero inicial da lista
 * @param faixaFinal contem o numero final da lista
 */
void popularListaAleatoria(vector<int> &listaNumeros, int quantidadeNumeros, int faixaInicial, int faixaFinal){
    srand(time(NULL));
    int numeroSorteado;
    for(int i=0; i<quantidadeNumeros; i++){
        numeroSorteado = faixaInicial + (rand() % faixaFinal);
        listaNumeros.push_back(numeroSorteado);
    }
}


/**
 /* @brief metodo que exiber o conteudo de uma lista de inteiros, elemento abaixo de elemento
 * 
 * @param lista lista contem os numeros inteiros
 */
void exibirLista(vector<int> lista){
    for(int i = 0; i<lista.size(); i++){
        cout << lista[i] << "\n";
    }
    cout << "----------\n";
    cout << "Total de elementos: " << lista.size() << "\n";

}

/**
 * @brief metodo que copia os numeros da lista origem para lista destino, exceto os repetidos
 * 
 * @param listaOrigem contem os numeros originais da lista
 * @param listaDestino contem os numeros copiados da lista original sem ser repetidos
 */
void copiarListaSemReplicados(vector<int> listaOrigem, vector<int> &listaDestino){
   for (int i = 0; i < listaOrigem.size(); i++) {

        int j;

        for (j = 0; j < listaDestino.size(); j++) {
            if (listaOrigem[i] == listaDestino[j]) {
                break;
            }
        }

        // Se percorreu toda a listaDestino e não encontrou
        if (j == listaDestino.size()) {
            listaDestino.push_back(listaOrigem[i]);
        }
    }
    
}
