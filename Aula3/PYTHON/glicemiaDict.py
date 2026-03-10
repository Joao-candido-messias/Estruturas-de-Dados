lista_glicemica = []
nome_arquivo = './glicemia.txt'

lista_dicionarios_glicemica = []

def calcular_media(lista):
    soma = 0
    for item in lista:
        soma += float(item["valor"])
    
    return round((soma/len(lista)), 2)

def calcular_mediana(lista):
    lista_ordenada = sorted(lista, key=lambda x: float(x["valor"]))
    n = len(lista_ordenada)
    if n % 2 == 1:  
        return float(lista_ordenada[n // 2]["valor"])
    else:           
        meio = n // 2
        return (float(lista_ordenada[meio - 1]["valor"]) + float(lista_ordenada[meio]["valor"])) / 2

def esta_contido(dicionario, lista_dicionarios):
    for item in lista_dicionarios:
        if item["data"] == dicionario["data"] and item["hora"] == dicionario["hora"]:
            return True
        
    return False

with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        valor, data, hora = linha.strip().split(',')
        dados = {
            "valor": valor,
            "data": data,
            "hora": hora
        }
        if not esta_contido(dados, lista_dicionarios_glicemica):
            lista_dicionarios_glicemica.append(dados)
    

for registro in lista_dicionarios_glicemica:
    print(registro)

print('Quantidade de dados lidos: ', len(lista_dicionarios_glicemica))

print(f"Média glicêmica da amostra: {calcular_media(lista_dicionarios_glicemica)}")
print(f"Mediana glicêmica da amostra: {calcular_mediana(lista_dicionarios_glicemica)}")
