import random
from util import popular_lista_arquivo

letras = 'abcdefghijklmnopqrstuvwxyz '

lista = []

n = int(input('Quantos nomes quer gerar?'))

tamanho_palavra = int(input('Qual o tamanho da palavra a ser sorteada?'))

while len(lista) < n:
    palavra = ''
    for i in range(tamanho_palavra):
        posicao_letras = random.randint(0, len(letras)-1)
        palavra += letras[posicao_letras]
    
    if(palavra not in lista):
        lista.append(palavra)
        i+=1

lista.sort()

popular_lista_arquivo(lista, "nomes.txt")