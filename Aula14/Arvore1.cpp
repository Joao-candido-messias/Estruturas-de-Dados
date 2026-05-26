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

//Metodo que conta o número de nós de uma Arvore
int contarNos(Arvore *raiz){
    if(raiz){
        return 1 + contarNos(raiz->esq) + contarNos(raiz->dir);
    }
    return 0;
}

//Metodo que conta o numero de folhas de uma arvore
int contarFolhas(Arvore *raiz){
    if(!raiz){
        return 0;
    }
    if(!raiz->esq && !raiz->dir){
        return 1;
    }
    return contarFolhas(raiz->esq) + contarFolhas(raiz->dir);
}

//Metodo que retorno o maior valor de uma Arvore
int maior(Arvore *raiz){
    if(!raiz) return -27;

    Arvore *p;
    for(p = raiz; p->dir; p = p->dir);
    
    return p->valor;
}

//Metodo que retorna o menor valor de uma Arvore
int menor(Arvore *raiz){
    if(!raiz) return -27;

    Arvore *p;
    for(p = raiz; p->esq; p = p->esq);

    return p->valor;
}

//Metodo que encontra um valor em uma Arvore
bool encontrou(int valor, Arvore *raiz){
    if(raiz){
        if(valor == raiz->valor){
            return 1;
        }
        if(valor < raiz->valor){
            return(encontrou(valor, raiz->esq));
        }
        if(valor > raiz->valor){
            return(encontrou(valor, raiz->dir));
        }
    }
    return 0;
}

//Metodo que devolve o nivel de um numero em uma Arvore
int nivel(int valor, Arvore *raiz){
    if(raiz){
        if(valor == raiz->valor) return 0;
        if(valor<raiz->valor){
            int resp = nivel(valor, raiz->esq);
            if(resp == -1) return -1;
            return resp+1;
        }else{
            int resp = nivel(valor, raiz->dir);
            if(resp == -1) return -1;
            return resp+1;
        }
    }
    return -1;
}

//Metodo que exibe uma Arvore
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
        //Controle de replicados
        if(valor == raiz->valor) return raiz;

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

    // raiz = inserir(100, raiz);
    // raiz = inserir(50, raiz);
    // raiz = inserir(150, raiz);
    // raiz = inserir(60, raiz);
    // raiz = inserir(80, raiz)

    // red(raiz);//Raiz esquerda direita
    // cout << "\n";
    // erd(raiz);//Esquerda raiz direita
    // cout << "\n";
    // edr(raiz);//Esquerda direira raiz

    exibir(0, raiz);

    cout << "Quantidade de nós:" << contarNos(raiz) << ".\n";

    cout << "Quantidade de folhas:" << contarFolhas(raiz) << ".\n";

    cout << "Maior número:" << maior(raiz) << ".\n";

    cout << "Menor número:" << menor(raiz) << ".\n";

    int valor = 5;

    cout << "Encontrou " << valor << "?" << encontrou(valor, raiz) << ".\n";

    cout << "O numero " << valor << " esta no nivel " << nivel(valor, raiz) << ".\n";
    return  0; 
}