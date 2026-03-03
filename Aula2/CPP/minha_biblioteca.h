// Operações sobre listas: append, percorrer, remover ou deletar
#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <algorithm>

using namespace std;

//-------------------------------
// Método que recebe uma lista e a popula com números aleatórios.
void popularAleatorio(vector<int>& lista, int quantidade) {
    srand(time(0)); // inicializa a semente para números aleatórios

    for (int i = 0; i < quantidade; i++) {
        lista.push_back(rand() % 101); // números de 0 a 100
    }
}

//-------------------------------
// Popular um vetor de strings a partir de um arquivo
void popularDeArquivo(vector<int>& lista, const string& nomeArquivo) {
    ifstream leitor(nomeArquivo);

    if (!leitor.is_open()) {
        cout << "Erro ao abrir o arquivo!" << endl;
        return;
    }

    int numero;
    while (leitor >> numero) { // lê número por número
        lista.push_back(numero);
    }

    leitor.close();
}

//-------------------------------
// Exibir vetor de inteiros
void exibir(const vector<int>& lista) {
    for (int i = 0; i < lista.size(); i++) {
        cout << lista[i] << endl;
        cout << "----------------" << endl;
    }
    cout << "Total de registros: " << lista.size() << endl;
}


//-------------------------------
// Copiar lista de inteiros sem duplicatas
void copiarListaSemReplicados(const vector<int>& origem, vector<int>& destino) {
    for (int i = 0; i < origem.size(); i++) {
        bool existe = false;
        for (int j = 0; j < destino.size(); j++) {
            if (origem[i] == destino[j]) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            destino.push_back(origem[i]);
        }
    }
}