package Desafios.DadosClimaticos;

import java.io.IOException;
import java.util.ArrayList;
import Desafios.DadosClimaticos.MinhaBiblioteca.RegistroClimatico;

public class Principal {
    public static void main(String[] args) {
        try {
            ArrayList<RegistroClimatico> registros = RegistroClimatico.lerCSV("./Desafios/DadosClimaticos/dadosClimaticos.csv");

            System.out.println("\n--- DEBUG (soma por estação/ano) ---");

            // DEBUG: mostra os valores antes do cálculo final
            java.util.HashMap<Integer, int[]> dados = new java.util.HashMap<>();

            for (RegistroClimatico r : registros) {
                int mesNumero = RegistroClimatico.mesParaNumero(r.mes);
                if (mesNumero == 0) continue;

                int estacao = RegistroClimatico.descobrirEstacao(mesNumero);
                int peso = RegistroClimatico.pesoPrecipitacao(r.precipitacao);

                dados.putIfAbsent(r.ano, new int[5]);
                dados.get(r.ano)[estacao] += peso;
            }

            for (Integer ano : dados.keySet()) {
                int[] soma = dados.get(ano);

                System.out.println("Ano: " + ano);
                for (int e = 1; e <= 4; e++) {
                    System.out.println(RegistroClimatico.nomeEstacao(e) + ": " + soma[e]);
                }
            }

            System.out.println("\n--- RESULTADO ---");

            // chamada da função principal
            RegistroClimatico.acumularDadosPorEstacao(registros);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}