import java.util.TreeSet;

public class Arvore{
    public static void main(String[]args){
        TreeSet<Integer> arvore = new TreeSet<>();
        arvore.add(5);
        arvore.add(10);
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
    }
}