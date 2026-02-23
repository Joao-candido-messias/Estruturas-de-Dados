import random

lista =[]

n = int(input('Quntos números interiros devem ser gerados?'))


while len(lista) < n:
        numero_sorteado = random.randint(0, 1000)
        if numero_sorteado not in lista:
            lista.append(numero_sorteado)
            
lista.sort() #Ordenado de maneira crescente
#lista.sort(reverse = true) Ordenado de maneira decrescente
print(lista)
