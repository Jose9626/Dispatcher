package logicaNegocios;
import java.util.LinkedList;
import java.util.Queue;


public class Cola {
    public Queue lista = new LinkedList();
    public int cantMax;
    
    public Cola(LinkedList list, int num){
        lista = list;
        cantMax = num;
    }
    
    public void enqueue(Object item){
        lista.add(item);
    }
    
    public Object dequeue(){
        return lista.poll();
    }
    
    public boolean hasItems(){
        return !lista.isEmpty();
    }

    public int size(){
        return lista.size();
    }    
}
