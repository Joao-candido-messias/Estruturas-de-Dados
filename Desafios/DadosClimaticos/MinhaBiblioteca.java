package Desafios.DadosClimaticos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MinhaBiblioteca {

    public static class RegistroClimatico {
        public int ano;
        public int mes;
        public double temperatura;
        public double precipitacao;

        public RegistroClimatico(int ano, int mes, double temperatura, double precipitacao) {
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
        public static ArrayList<RegistroClimatico> lerCSV(String caminho){
            try(BufferedReader br = new BufferedReader(new FileReader(caminho))){

                //Pula o cabeçalho do meu arquivo .csv
                br.readLine();

                String linha;

                while ((linha = br.readLine()) != null){
                    String[] dados = linha.split(",");

                    //Conversão de valores
                    int ano = Integer.parseInt(dados[0]); 
                    int mes = Integer.parseInt(dados[1]); 
                    String temperatura = dados[2]; 
                    String precipitacao = dados[2];
                }

            }
        }

        /**
         * Determina a estação do ano com base no mês.
         *
         * @param mes Mês da medição climática
         * @return Estação do ano (1-Primavera, 2-Verão, 3-Outono, 4-Inverno)
         */
        public static int descobrirEstacao(int mes) {
            // implementação aqui
        }

        public static void acumularDadosPorEstacao() {
            // implementação aqui
        }

        public static void imprimirResultados() {
            // implementação aqui
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
            return this.ano == registro.ano && this.mes == registro.mes;
        }
    }
}