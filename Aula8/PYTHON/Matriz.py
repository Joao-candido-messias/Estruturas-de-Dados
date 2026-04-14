from Dado import Dado
class Matriz:

    """Função que inicializa uma matriz com zeros.
        
    Args:
        matriz (list): A matriz a ser inicializada
        linhas (int): Número de linhas da matriz
        colunas (int): Número de colunas da matriz
    """
    def inicializarMatriz(matriz, linhas, colunas):
        for i in range(linhas):
            for j in range(colunas):
                matriz[i][j] = 0

    """Função que exibe os elementos de uma matriz.
        
    Args:
        matriz (list): A matriz a ser exibida
        linhas (int): Número de linhas da matriz
        colunas (int): Número de colunas da matriz
    """
    def exibirMatriz(matriz, linhas, colunas):
        for i in range(linhas):
            for j in range(colunas):
                print(matriz[i][j], end='  ')
            print()
    
    """Função que converte os elementos de uma matriz em uma lista.
        
    Args:
        matriz (list): A matriz a ser convertida
        linhas (int): Número de linhas da matriz
        colunas (int): Número de colunas da matriz
        lista (list): A lista a ser preenchida
    """
    def converterMatrizLista(matriz, linhas, colunas, lista):
        for i in range(linhas):
            for j in range(colunas):
                if matriz[i][j] != 0:
                    lista.append(Dado(matriz[i][j], i, j))    

    def exibirLista(lista):
        for item in lista:
            print(item, end=' ')
        print()
        print(f"Total de elementos não nulos: {len(lista)}")