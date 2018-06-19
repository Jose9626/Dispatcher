package logicaNegocios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Dispatcher {

	private Cola ready = new Cola(new LinkedList(),10);
	private Cola blocked = new Cola(new LinkedList(),10);

	
	public void agregarProceso(Proceso proceso) throws ParseException {
		if (determinarMemoriaUsada() >= 2000) {
			while (determinarMemoriaUsada() >= 2000) {
				Proceso eliminar = LRU();
				if (ready.eliminar(eliminar));
				else blocked.eliminar(eliminar);
			}
		}
		encolarProceso(proceso);
	}
	
	public void encolarProceso(Proceso proceso) {
		if (ready.size()<10)
			ready.enqueue(proceso);
		else 
			blocked.enqueue(proceso);
	}
	
	
	public Proceso LRU() throws ParseException {
		LinkedList<Proceso> procesos = unirColas();
		while(procesos.size() < 1) {
			if (restarFechas(procesos.get(0).getFechaInicial(),procesos.get(1).getFechaInicial())>0) 
				procesos.remove(1);
			else 
				procesos.remove(0);
		}
		return procesos.get(0);	
	}
	
	public int determinarMemoriaUsada() {
		LinkedList<Proceso> lista = unirColas();
		int total = 0;
		for (Proceso proceso: lista) {
			total += proceso.getEspacio();
		}
		return total;
	}
	
	public LinkedList<Proceso> unirColas(){
		LinkedList<Proceso> lista_ready  = (LinkedList<Proceso>)ready.lista;
		LinkedList<Proceso> lista_blocked  = (LinkedList<Proceso>)blocked.lista;
		lista_ready.addAll(lista_blocked);
		return lista_ready;
	}
	
    //Metodo compara dos fechas 
    public int restarFechas(Date fecha1, Date fecha2) throws ParseException {

        int dias = (int) ((fecha1.getTime() - fecha2.getTime()) / 86400000);

        System.out.println("" + dias + " dias de diferencia");
        return dias;
    }
    
    public void dispatch() {
    	Proceso proceso = ready.dequeue();
    	if (proceso.getState().toString() == "NEW") proceso.start();
    	
    	try {
			proceso.alert();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			proceso.halt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if (proceso.getState().toString() != "TERMINATED") {
    		ready.enqueue(proceso);
    	}
    }
    
}
