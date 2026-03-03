#include <iostream>
#include "minha_biblioteca.h"
#include <string>

using namespace std;

int main(){

    //vector<int> listaNumerosA;
    vector<int> listaNumerosB;

    // popularAleatorio(listaNumerosA, 100);
    // exibir(listaNumerosA);

    string nomeDoArquivo = "numeros.txt";
    popularDeArquivo(listaNumerosB, nomeDoArquivo);
    exibir(listaNumerosB);

    vector<int> resultado;

    copiarListaSemReplicados(listaNumerosB, resultado);
    exibir(resultado);
    return 0;
}