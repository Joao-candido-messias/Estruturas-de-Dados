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
    def calcular_media(lista):
        soma =  0
        for item in lista:
            soma += float(item.valor)
        
        return round(soma/len(lista), 2)