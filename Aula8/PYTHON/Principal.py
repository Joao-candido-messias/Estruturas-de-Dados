from Dado import Dado
from Matriz import Matriz

dimensao = 10
matriz = [[0 for _ in range(dimensao)] for _ in range(dimensao)]

Matriz.inicializarMatriz(matriz, dimensao, dimensao)


matriz[0][3] = 1
matriz[2][5] = 1
matriz[5][7] = 1
matriz[6][8] = 1

Matriz.exibirMatriz(matriz, dimensao, dimensao)

lista = []

Matriz.converterMatrizLista(matriz, dimensao, dimensao, lista)
Matriz.exibirLista(lista)


