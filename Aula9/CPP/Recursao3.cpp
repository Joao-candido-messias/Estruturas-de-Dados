#include <iostream>
#include <ctime>
#include <cstdlib>

#define TAM 5

using namespace std;

void popularVetorR(int vetor[], int n) {
    if (n >= 1) {
        vetor[n - 1] = rand() % 100;
        popularVetorR(vetor, n - 1);
    }
}

void exibirVetorR(int vetor[], int n) {
    if (n >= 1) {
        exibirVetorR(vetor, n - 1);
        cout << (n - 1) << ")" << vetor[n - 1] << endl;
    }
}

int main() {
    int vetor[TAM];

    srand(time(NULL)); // só uma vez

    popularVetorR(vetor, TAM);
    exibirVetorR(vetor, TAM);

    return 0;
}