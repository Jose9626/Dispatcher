/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocios;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Luna Llena
 */
public class Cola {

    public Queue<Proceso> lista = new LinkedList<Proceso>();
    public int cantMax;

    public Cola(LinkedList list, int num){
        lista = list;
        cantMax = num;
    }
    
    public void enqueue(Proceso item) {
        lista.add(item);
    }

    public Proceso dequeue() {
        return lista.poll();
    }
    
    public boolean eliminar(Proceso proceso){
    	
        return lista.remove(proceso);
    }

    public boolean hasItems() {
        return !lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }
}
