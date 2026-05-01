package Desafios.GestaoAcademica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String caminho = "./Desafios/GestaoAcademica/DadosAlunos.csv";
            ArrayList<Aluno> alunos = Aluno.lerCsv(caminho);
            String nome;
            System.out.println("Insira o nome que você deseja procurar: ");
            nome = scanner.nextLine();
            System.out.println(Aluno.buscaAluno(nome, alunos));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }  
}