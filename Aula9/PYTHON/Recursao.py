import random

def exibir_lista(lista):
    for item in lista:  # Recursao
        print(item)

def exibir_lista_r(lista, n):
    if (n >= 1):
        exibir_lista_r(lista, n - 1)
        print(lista[n - 1])

def popular_lista_r(lista, qtd):
    if(qtd >= 1):
        lista.append(random.randint(0,100))
        print(lista[-1])
        popular_lista_r(lista, qtd-1)

def exibir_pares_r(lista, n):
    if (n >= 1):
        exibir_pares_r(lista, n - 1)
        if(lista[n - 1] % 2 == 0):
            print(lista[n - 1])

lista = [1, 2, 3, 4, 5]


exibir_pares_r(lista, len(lista))