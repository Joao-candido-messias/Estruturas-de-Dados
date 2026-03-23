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

        
        //  * Determina a estação do ano com base no mês.
        //  *
        //  * @param mes Mês da medição climática
        //  * @return Estação do ano (1-Primavera, 2-Verão, 3-Outono, 4-Inverno)
        //  */
        public static int descobrirEstacao(int mes) {
            if (mes >= 3 && mes <= 5) {
                return 3; // Outono
            } else if (mes >= 6 && mes <= 8) {
                return 4; // Inverno
            } else if (mes >= 9 && mes <= 11) {
                return 1; // Primavera
            } else {
                return 2; // Verão (dez, jan, fev)
            }
        }

        /**
         * Função analisa os dados retornando as estações mais e menos chuvosas dentro do recorte analisado
         *
         * @param registros Lista de registros climáticos
         */
        public static void precipitacaoPorEstacao(ArrayList<RegistroClimatico> registros) {

            // [ano][estacao]
            java.util.HashMap<Integer, int[]> dados = new java.util.HashMap<>();

            for (RegistroClimatico r : registros) {

                int mesNumero = mesParaNumero(r.mes);
                if (mesNumero == 0) continue;

                int estacao = descobrirEstacao(mesNumero);
                int peso = pesoPrecipitacao(r.precipitacao);

                dados.putIfAbsent(r.ano, new int[5]);
                dados.get(r.ano)[estacao] += peso;
            }

            int anoMais = 0, estMais = 0, max = Integer.MIN_VALUE;
            int anoMenos = 0, estMenos = 0, min = Integer.MAX_VALUE;

            for (Integer ano : dados.keySet()) {
                int[] soma = dados.get(ano);

                for (int e = 1; e <= 4; e++) {

                    if (soma[e] > max) {
                        max = soma[e];
                        anoMais = ano;
                        estMais = e;
                    }

                    // ignora estações sem dados
                    if (soma[e] > 0 && soma[e] < min) {
                        min = soma[e];
                        anoMenos = ano;
                        estMenos = e;
                    }
                }
            }

            System.out.println("Mais chuvosa: " + nomeEstacao(estMais) + " de " + anoMais);
            System.out.println("Menos chuvosa: " + nomeEstacao(estMenos) + " de " + anoMenos);
        }

         /**
         * Função analisa os dados retornando as estações mais e menos chuvosas dentro do recorte analisado
         *
         * @param registros Lista de registros climáticos
         */
        public static void temperaturaPorEstacao(ArrayList<RegistroClimatico> registros) {

            // [ano][estacao]
            java.util.HashMap<Integer, int[]> dados = new java.util.HashMap<>();

            for (RegistroClimatico r : registros) {

                int mesNumero = mesParaNumero(r.mes);
                if (mesNumero == 0) continue;

                int estacao = descobrirEstacao(mesNumero);
                int peso = pesoTemperatura(r.temperatura);

                dados.putIfAbsent(r.ano, new int[5]);
                dados.get(r.ano)[estacao] += peso;
            }

            int anoMais = 0, estMais = 0, max = Integer.MIN_VALUE;
            int anoMenos = 0, estMenos = 0, min = Integer.MAX_VALUE;

            for (Integer ano : dados.keySet()) {
                int[] soma = dados.get(ano);

                for (int e = 1; e <= 4; e++) {

                    if (soma[e] > max) {
                        max = soma[e];
                        anoMais = ano;
                        estMais = e;
                    }

                    // ignora estações sem dados
                    if (soma[e] > 0 && soma[e] < min) {
                        min = soma[e];
                        anoMenos = ano;
                        estMenos = e;
                    }
                }
            }

            System.out.println("Mais quente: " + nomeEstacao(estMais) + " de " + anoMais);
            System.out.println("Mais fria: " + nomeEstacao(estMenos) + " de " + anoMenos);
        }

        /**
         * Converte o nome de um mês para seu número correspondente.
         *
         * @param mes Nome do mês
         * @return Número do mês (1-12)
         */
        public static int mesParaNumero(String mes) {
            switch (mes.toLowerCase()) {
                case "janeiro": return 1;
                case "fevereiro": return 2;
                case "março": return 3;
                case "abril": return 4;
                case "maio": return 5;
                case "junho": return 6;
                case "julho": return 7;
                case "agosto": return 8;
                case "setembro": return 9;
                case "outubro": return 10;
                case "novembro": return 11;
                case "dezembro": return 12;
                default: return 0;
            }
        }

        /**
         * Função que determina o peso da precipitação com base em sua magnitude.
         *
         * @param p Magnitude da precipitação
         * @return Peso da precipitação (1-3)
         */
        public static int pesoPrecipitacao(String p) {
            switch (p.toLowerCase()) {
                case "muita": return 3;
                case "media": return 2;
                case "pouca": return 1;
                default: return 0;
            }
        }

         /**
         * Função que determina o peso da temperatura com base em sua magnitude.
         *
         * @param p Magnitude da temperatura
         * @return Peso da temperatura (1-3)
         */
        public static int pesoTemperatura(String p) {
            switch (p.toLowerCase()) {
                case "quente": return 3;
                case "ameno": return 2;
                case "frio": return 1;
                default: return 0;
            }
        }

        /**
         * Função que retorna o nome da estação com base em seu número.
         *
         * @param e Número da estação (1-4)
         * @return Nome da estação
         */
        public static String nomeEstacao(int e) {
            switch (e) {
                case 1: return "Primavera";
                case 2: return "Verão";
                case 3: return "Outono";
                case 4: return "Inverno";
                default: return "";
            }
        }

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