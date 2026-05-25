#include <iostream>

using namespace std;

typedef struct no {
    int valor;
    struct no *esq;
    struct no *dir;
}Arvore;

void red(Arvore *raiz){
    if(raiz){
        cout << raiz->valor<<"\t";
        red(raiz->esq);
        red(raiz->dir);
    }
}

void erd(Arvore *raiz){
    if(raiz){
        red(raiz->esq);
        cout << raiz->valor<<"\t";
        red(raiz->dir);
    }
}

void edr(Arvore *raiz){
    if(raiz){
        red(raiz->esq);
        red(raiz->dir);
        cout << raiz->valor<<"\t";
    }
}

void exibir(int nivel, Arvore * raiz){
    if(raiz){
        exibir(nivel+1, raiz->dir);

        for(int i = 0; i<nivel; i++){
            cout << "\t";
        }
        cout << raiz->valor <<"(" <<nivel<<")\n";
        exibir(nivel+1, raiz->esq);
    }
}



//Metodo inserir ordenado recursivo em arvore binaria de peaquisa = ORDENADO
Arvore *inserir(int valor,Arvore *raiz){
    if(raiz){
        if(valor < raiz->valor){
            raiz->esq = inserir(valor, raiz->esq);
        }else{
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;
    }else{
        Arvore *novo;
        novo = (Arvore*)malloc(sizeof(Arvore));
        novo-> valor = valor;
        novo->esq = NULL;
        novo->dir = NULL;
        return novo;
    }
}

int main(){
    Arvore * raiz = NULL;

    srand(time(NULL));
    for(int i = 0; i<20; i++){
        raiz = inserir(rand() % 30, raiz);
    }

    raiz = inserir(100, raiz);
    raiz = inserir(50, raiz);
    raiz = inserir(150, raiz);
    raiz = inserir(60, raiz);
    raiz = inserir(80, raiz);

    // red(raiz);//Raiz esquerda direita
    // cout << "\n";
    // erd(raiz);//Esquerda raiz direita
    // cout << "\n";
    // edr(raiz);//Esquerda direira raiz

    exibir(0, raiz);

    return  0;
}