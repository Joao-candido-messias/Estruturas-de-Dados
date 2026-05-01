import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

public class Aluno{
    private String nome;
    private String curso;
    private String sexo; 
    private int anoIngresso;

    public Aluno(String nome, String curso, String sexo, int anoIngresso){
        this.nome = nome;
        this.curso = curso;
        this.sexo = sexo;
        this.anoIngresso = anoIngresso;
    }

    //Geter de nome
    public String GetNome(){
        return nome;
    }

    //Geter de curso
    public String GetCurso(){
        return curso;
    }

    //Setter de curso
    public void Setcurso(String curso){
        this.curso = curso;
    }

    //Getter de sexo
    public String GetSexo(){
        return sexo;
    }

    //Getter de anoIngresso
    public int GetAnoIngresso(){
        return anoIngresso;
    }


    /**
    * Função que lê um arquivo .csv e retorna uma lista de alunos
    *@param caminho: Caminho do arquivo .csv
    *@return: Lista de Alunos
    *@throws IOException Se ocorrer erro na leitura do arquivo
    */
    public static ArrayList<Aluno> lerCsv(String caminho) throws IOException{
        ArrayList<Aluno> alunos = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){

            //Ignora o cabeçalho
            br.readLine();

            String linha;

            while((linha = br.readLine())  != null){
                //Ignora linhas vazias
                if(linha.trim().isEmpty()){
                    continue;
                }

                String[] dados = linha.split(",");

                //Garante que todos os dados tenham as 4 informações necessarias
                if(dados.length < 4){
                    continue;
                }

                String nome = dados[0];
                String curso = dados[1];
                String sexo = dados[2];
                int anoIngresso = Integer.parseInt(dados[3]);

                alunos.add(new Aluno(nome, curso, sexo, anoIngresso));
            }
        }
        return alunos;
    }

    @Override
    public String toString(){
        return"Aluno: {"+
        "Nome: " +nome+ "," +
        "Curso " +curso+ "," +
        "Sexo: " +sexo+ "," +
        "Ano de ingresso: " +anoIngresso+
        ".}";
    }

    @Override
    public boolean equals(Object obj){
        
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        Aluno aluno = (Aluno) obj;

        return this.nome.equals(aluno.nome) && this.anoIngresso == aluno.anoIngresso;
    }

}