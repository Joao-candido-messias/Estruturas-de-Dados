package Desafios.DadosClimaticos;

import java.io.IOException;
import java.util.ArrayList;
import Desafios.DadosClimaticos.MinhaBiblioteca.RegistroClimatico;

public class Principal {
    public static void main(String[] args) {
        try {
            ArrayList<RegistroClimatico> registros = RegistroClimatico.lerCSV("./Desafios/DadosClimaticos/dadosClimaticos.csv");

            System.out.println("\n--- RESULTADOS ---");

            //Chamada da função que retorna a estação mais e menos chuvosa presente nos dados analisados
            RegistroClimatico.precipitacaoPorEstacao(registros);
            
            //Chamada da função que retorna a estamção mais e menos quente presente nos dados analisados
            RegistroClimatico.temperaturaPorEstacao(registros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}