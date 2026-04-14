import java.util.ArrayList;

public class Matriz{
    /*
    *Método que inicializa uma matriz de inteiros.
    *@param matriz -> Matriz de numeros inteiros.
    *@param qtdl -> Quantidade de linhas.
    *@param qtdc -> Quantidade de colunas.
    */
    public static void incializarMatriz(int matriz[][], int qtdl, int qtdc){
        for(int i = 0; i< qtdl; i++){
            for(int j = 0; j<qtdc; j++){
                matriz[i][j] = 0;
            }
        }
    }

    /*
    *Método que exibe uma matriz de inteiros.
    *@param matriz -> Matriz de de numeros inteiros.
    *@param qtdl -> Quantidade de linhas.
    *@param qtdc -> Quantidade de colunas.
    */
    public static void exibirMatriz(int matriz[][], int qtdl, int qtdc){
        for(int i = 0; i < qtdl; i++){
            for(int j = 0; j < qtdc; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /*
    *Método que converte uma matriz de inteiros para uma lista.
    *@param matriz -> Matriz de numeros inteiros.
    *@param qtdl -> Quantidade de linhas.
    *@param qtdc -> Quantidade de colunas.
    *@param lista -> Lista de inteiros que recebe os valores convertidos.
    */
    public static void converterMatrizLista(int matriz[][], int qtdl, int qtdc, ArrayList<Dado> lista){
        for(int i = 0; i< qtdl; i++){
            for(int j = 0; j < qtdc; j++){
                if(matriz[i][j] != 0){
                    lista.add(new Dado(matriz[i][j], i, j));
                }
            }
        }
    }


    /*Método que exibe uma lista de objetos Dado.
    *@param lista -> Lista de objetos do tipo Dado.
    *
    */
    public static void exibirLista(ArrayList<Dado> lista){
        for(Dado dado : lista){
            System.out.println(dado);
        }
        System.out.println("-------------------------------");
        System.out.println("Total de elementos nao nulos " + lista.size());
    }


}


    

