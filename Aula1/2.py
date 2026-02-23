import random

letras = 'abcdefghijklmnopqrstuvwxyz '

lista = []

n = int(input('Quantos nomes quer gerar?'))

tamanho_palavra = int(input('Qual o tamanho da palavra a ser sorteada?'))

while len(lista) < n:
    palavra = ''
    for i in range(tamanho_palavra):
        posicao_letras = random.randint(0, len(letras)-1)
        palavra += letras[posicao_letras]
    
    lista.append(palavra)

print('Palavra sorteada', palavra)

for p in lista:
    print(p)