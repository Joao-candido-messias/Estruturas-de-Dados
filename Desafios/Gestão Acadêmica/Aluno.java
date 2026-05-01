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

}