#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

void mostrarSequenciaD(int numero){
    for(; numero > 0; numero --){
        cout << numero << endl;
    }
}

void mostrarSequenciaC(int numero){
    for(int i = 1; i <= numero; i++){
        cout << i << endl;
    }
}

void mostrarSequenciaRecursiva(int numero){
    if(numero > 0){
        //Executar codigo no empilhamento
        
        mostrarSequenciaRecursiva(numero -1);//Ponto de recursao com a transformação da variavel de controle
        cout << numero << endl;
        //executar codigo no desempilhamento
    }
}

int main(){
    int numero = 5 ;

    // mostrarSequenciaD(numero);

    // mostrarSequenciaD(numero);

    mostrarSequenciaRecursiva(numero);

    return 0;
}