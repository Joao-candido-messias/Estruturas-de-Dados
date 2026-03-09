class Glicemia:
    def __init__(self, valor, data, hora):
        """Construtor básico com os 3 atributos da classe
        
        Args:
            data (str): Data da medição
            hora (str): Hora da medição
            valor (float): Valor da glicemia
        """
        self.valor = valor
        self.data = data
        self.hora = hora

    def __eq__(self, other):
        """Sobrescreve o método de comparação entre objetos da classe Glicemia"""
        if not isinstance(other, Glicemia):
            return False
        return (self.valor, self.data, self.hora) == (other.valor, other.data, other.hora)

    def __str__(self):
        return f'Valor Glicemia : {self.valor}. Data: {self.data}. Hora: {self.hora}'

    @staticmethod
        """Metodo que calcula a média glicêmica a partir de uma lista de objetos Glicemia

            Args:
                lista (list): Lista de objetos Glicemia
        """
    def calcular_media(lista):
        soma =  0
        for item in lista:
            soma += float(item.valor)
        
        return round(soma/len(lista), 2)
    
    @staticmethod

        """Metodo que calcula a mediana a partir de uma lista de objetos Glicemia
            Args:
                lista (list): Lista de objetos Glicemia
        """
    def calcular_mediana(lista):
        
        lista_ordenada = sorted(lista, key=lambda x: x.valor)
        n = len(lista_ordenada)
    
        if n % 2 == 1:  
            return lista_ordenada[n // 2].valor
        else:           
            meio = n // 2
        return (lista_ordenada[meio - 1].valor + lista_ordenada[meio].valor) / 2