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