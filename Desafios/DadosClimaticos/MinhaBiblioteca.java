package Desafios.DadosClimaticos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MinhaBiblioteca {

    public static class RegistroClimatico {

        public int ano;
        public String mes;
        public String temperatura;
        public String precipitacao;

        public RegistroClimatico(int ano, String mes, String temperatura, String precipitacao) {
            this.ano = ano;
            this.mes = mes;
            this.temperatura = temperatura;
            this.precipitacao = precipitacao;
        }

        /**
         * Lê um arquivo CSV e retorna uma lista de registros climáticos.
         *
         * @param caminho Caminho do arquivo CSV
         * @return Lista de registros climáticos
         * @throws IOException Se ocorrer erro na leitura do arquivo
         */
        public static ArrayList<RegistroClimatico> lerCSV(String caminho) throws IOException {

            ArrayList<RegistroClimatico> registros = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

                // Pula o cabeçalho
                br.readLine();

                String linha;

                while ((linha = br.readLine()) != null) {

                    // Ignora linhas vazias
                    if (linha.trim().isEmpty()) {
                        continue;
                    }

                    String[] dados = linha.split(",");

                    // Garante que a linha tem todas as colunas
                    if (dados.length < 4) {
                        continue;
                    }

                    int ano = Integer.parseInt(dados[0]);
                    String mes = dados[1];
                    String temperatura = dados[2];
                    String precipitacao = dados[3];

                    registros.add(new RegistroClimatico(ano, mes, temperatura, precipitacao));
                }

                return registros;
            }
        }

        // /**
        //  * Determina a estação do ano com base no mês.
        //  *
        //  * @param mes Mês da medição climática
        //  * @return Estação do ano (1-Primavera, 2-Verão, 3-Outono, 4-Inverno)
        //  */
        // public static int descobrirEstacao(int mes) {
        //     // implementação aqui
        // }

        // public static void acumularDadosPorEstacao() {
        //     // implementação aqui
        // }

        // public static void imprimirResultados() {
        //     // implementação aqui
        // }

        @Override
        public String toString() {
            return "Registro: {Ano: " + ano +
                   ", Mês: " + mes +
                   ", Temperatura: " + temperatura +
                   ", Precipitação: " + precipitacao + "}";
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            RegistroClimatico registro = (RegistroClimatico) obj;

            return this.ano == registro.ano && this.mes.equals(registro.mes);
        }
    }
}