package Desafios.GestaoAcademica;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

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
    public String getNome(){
        return nome;
    }

    //Geter de curso
    public String getCurso(){
        return curso;
    }

    //Setter de curso
    public void setCurso(String curso){
        this.curso = curso;
    }

    //Getter de sexo
    public String getSexo(){
        return sexo;
    }

    //Getter de anoIngresso
    public int getAnoIngresso(){
        return anoIngresso;
    }

    /**
         * Função que ordena uma lista de alunos pelo ano de ingresso
         * @param lista: Lista de alunos a ser tratada
         * @return Lista de alunos ordenada pelo ano de ingresso
         */
        public static ArrayList<Aluno> ordenaPorAno(ArrayList<Aluno> lista){
            lista.sort(Comparator.comparingInt(Aluno::getAnoIngresso));
            return lista;
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
        return ordenaPorAno(alunos);
    }


    /**
     * Função que busca aluno pelo nome exato na lista e retorne seus dados.
     * @param nome: Nome que deve ser buscado na lista de Alunos 
     * @param lista: Lista de Alunos para busca
     * @return: Curso, sexo e ano de ingresso do aluno
     * @throws IOException: Se o aluno pesquisado não estiver na lista de Alunos
     */
    public static String buscaAluno(String nome, ArrayList<Aluno> lista) throws IOException{
        for(Aluno aluno : lista){
            if(aluno.getNome().equals(nome)){
                return aluno.toString();
            }  
        }
        throw new IOException("Aluno não encontrado");
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