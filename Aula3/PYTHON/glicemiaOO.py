from glicemia import Glicemia

lista_glicemica = []

nome_arquivo = 'glicemia.txt'

with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        valor, data, hora = linha.strip().split(',')
        valor = float(valor)
        objeto_glicemia = Glicemia(valor, data, hora)

        if objeto_glicemia not in lista_glicemica:
            lista_glicemica.append(objeto_glicemia)

for medicao in lista_glicemica:
    print(medicao)

print(f"Número de registros glicêmicos: {len(lista_glicemica)}")

print(f"Média glicêmica da amostra: {Glicemia.calcular_media(lista_glicemica)}")

print(f"Mediana glicêmica da amostra: {Glicemia.calcular_mediana(lista_glicemica)}")