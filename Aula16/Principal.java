import java.util.ArrayList;

public class Principal{
    public static void main(String[]args){

        ArrayList<String> listaVertices = new ArrayList<>();

        String arquivoMapa = "./mapa.csv";

        Grafo.descobrirVertices(arquivoMapa, listaVertices);

        Grafo grafo = new Grafo(listaVertices);

        System.out.println("Grafo...");
        
        Grafo.montarGrafo(arquivoMapa, grafo);

        grafo.mostrarGrafo();

        
    }
}