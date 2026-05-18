import java.util.TreeSet;

public class Arvore{
    public static void main(String[]args){
        TreeSet<Integer> arvore = new TreeSet<>();
        arvore.add(5);
        arvore.add(15);
        arvore.add(7);
        arvore.add(20);
        arvore.add(25);
        arvore.add(3);
        arvore.add(30);

        // System.out.println("Elementos da arvore: "+arvore);

         for(Integer elemento : arvore){
            System.out.println("Elemento:"+elemento);
        }

        if(arvore.contains(10)){
            System.out.println("A arvore contem o elemento 10.");
            arvore.remove(10);
            System.out.println("Elemento 10 removido.");
        }else{
            System.out.println("A arvore não contem o elemento 10.");
            arvore.add(10);
            System.out.println("Elemento 10 inserido.");
        }

       
    }
}