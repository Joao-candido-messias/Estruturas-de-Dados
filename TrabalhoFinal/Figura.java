public class Figura{
    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean eRara;

    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean eRara){
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.eRara = eRara;
    }

    //Getter de nomeSelecao
    public String getNomeSelecao(){
        return this.nomeSelecao;
    }
    //Setter de nomeSelecao
    public void SetNomeSelecao(String nomeSelecao){
        this.nomeSelecao = nomeSelecao;
    }

    //Getter de numeroFigura
    public int getNumeroFigura(){
        return this.numeroFigura;
    }
    //Setter de numeroFigura
    public void setNumeroFigura(int numeroFigura){
        this.numeroFigura = numeroFigura;
    }

    //Getter de descricao
    public String getDescricao(){
        return this.descricao
    }
    //Setter de descricao
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    //Getter de eRara
    public boolean getErara(){
        return this.eRara;
    }
    //Setter de eRara
    public void setERara(boolean eRara){
        this.eRara = eRara;
    }

    /**
     * Metodo toString para classe Figura
     * @return: Nome da seleção, numeral e raridade da Figura
     */
    @Override
    public String toString(){
        return"Figura:{"+
        "Selecao: "+this.nomeSelecao+
        "- Numeral: "+this.numeroFigura+
        "- Raridade: "+this.eRara+
        "}";
    }

    /**
     * Metodo que garante que uma figura com mesma selação e numeral seja instanciada
     * @param Object: Figura a ser comprada
     * @return: True se forem iguais ; False caso contrário
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj == null || obj.getClass() != this.getClass()) return false;

        Figura figura = (Figura) obj;

        return this.nomeSelecao.equals(figura.nomeSelecao) && this.getNumeroFigura() == figura.numeroFigura;
    }
}