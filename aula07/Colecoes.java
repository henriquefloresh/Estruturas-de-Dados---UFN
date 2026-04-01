import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Colecoes{
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(45);
        lista.add(15);
        lista.add(100);
        lista.sort(null);
        System.out.println(lista);
        lista.remove((Integer)100);
        System.out.println(lista.contains(100));

        // TRES FORMAS DE PERCORRER UMA COLEÇÃO //

        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }

        for(Integer i : lista){
            System.out.println(i);
        }

        Iterator i = lista.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        

        /*Stack<Integer> pilha = new Stack<>();
        pilha.push(15);
        pilha.push(5);
        pilha.push(100);
        pilha.push(45);
        System.out.println(pilha);
        pilha.pop();
        System.out.println(pilha.contains(45));
        System.out.println("Topo é: " + pilha.peek());*/

        /*Queue<Integer> fila = new LinkedList<>(); 
        fila.add(15); //em vez de usar add pode usar offer
        fila.offer(5);
        fila.add(100);
        fila.add(45);

        System.out.println(fila);

        fila.poll();//poll mesma função do remove

        System.out.println(fila.contains(15));
        System.out.println(fila.peek());*/

        
    }
}
