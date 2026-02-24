def popular_lista_arquivo(lista, nome_arquivo):
    with open(nome_arquivo, "w", encoding='utf8') as scritor:
        for i in lista:
            scritor.write(str(i) + "\n") 


def ler_arquivo_lista(nome_arquivo, lista):
    with open(nome_arquivo, "r", encoding='utf8') as leitor:
        for linha in leitor:
            lista.append((linha.strip()))