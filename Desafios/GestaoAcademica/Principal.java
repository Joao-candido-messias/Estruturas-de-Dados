package Desafios.GestaoAcademica;
import java.io.IOException;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        try {
            String caminho = "./Desafios/GestaoAcademica/DadosAlunos.csv";
            ArrayList<Aluno> alunos = Aluno.lerCsv(caminho);
            System.out.println(Aluno.buscaAluno("Karen Duarte", alunos));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }  
}