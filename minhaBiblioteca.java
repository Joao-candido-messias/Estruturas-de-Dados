import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class minhaBiblioteca {
   public static class RegistroClimatico
   {
    public int ano;
    public int mes;
    public String temperatura;
    public String preciptacao;

    public RegistroClimatico(int ano, int mes, String temperatura, String preciptacao){
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.preciptacao = preciptacao;
    }
   }

   
}
