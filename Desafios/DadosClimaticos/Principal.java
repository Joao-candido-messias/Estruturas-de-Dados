package Desafios.DadosClimaticos;

import java.io.IOException;
import java.util.ArrayList;
import Desafios.DadosClimaticos.MinhaBiblioteca.RegistroClimatico;

public class Principal {
    public static void main(String[] args) {
        try {
            ArrayList<RegistroClimatico> registros = RegistroClimatico.lerCSV("./Desafios/DadosClimaticos/dadosClimaticos.csv");

            // Exemplo: imprimir cada registro
            for (RegistroClimatico r : registros) {
                System.out.println(r);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}