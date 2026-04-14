class Dado:
    def __init__(self, valor, linha, coluna):
        self.valor = valor
        self.linha = linha
        self.coluna = coluna

    def __eq__(self, other):
        if self is other:
            return True
        if other is None or not isinstance(other, Dado):
            return False
        return self.linha == other.linha and self.coluna == other.coluna
        

    def __str__(self):
        return f"Dado(valor = {self.valor}, linha = {self.linha}, coluna = {self.coluna})\n"