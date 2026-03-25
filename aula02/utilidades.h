#include <cstdlib>
#include <iostream>
#include <string>
#define T 10


using namespace std;

void inicializar(string vetor []){
    for(int i = 0; i<T; i++){
        vetor[i] = "#";
    }
}

int inserir(string nome, string vetor[], int total){
    if (total == T){
        cout << "Vetor lotado\n";
    } else {
        for(int i = 0; i<T;i++){
            if(vetor[i]=="#"){
                vetor[i] = nome;
                total ++;
                break;
            }
        }
    }
    return total;
}

void exibir(string vetor[]){
    for(int i = 0; i<T; i++){
        if(vetor[i] != "#"){
            cout << vetor[i] << "\n";
        }
    }
}

int ondeEsta(string encontrarNome, string vetor[]){
    for(int i=0; i < T; i++){
        if(encontrarNome == vetor[i]){
            return i;
        }
    }
    return -1;
}
