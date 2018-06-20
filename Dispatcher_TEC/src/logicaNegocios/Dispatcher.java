/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocios;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author gabri
 */
public class Dispatcher implements Runnable {

    private static Cola ready = new Cola(new LinkedList(), 10);
    private static Cola blocked = new Cola(new LinkedList(), 10);
    public static Cola nuevos = new Cola(new LinkedList(), 10);
    public static LinkedList<Proceso> terminados = new LinkedList<Proceso>();
    public static Proceso process;

    public void run() {
        while (true) {
            if (ready.size() > 0) {
                dispatch();
            } else if (ready.size() < 10 && blocked.size() > 0) {
                try {
                    this.agregarProceso(blocked.dequeue());
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            while (nuevos.size() != 0) {
                try {
                    this.agregarProceso(nuevos.dequeue());
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    public Cola getReady() {
        return ready;
    }

    public void setReady(Cola ready) {
        this.ready = ready;
    }

    public Cola getBlocked() {
        return blocked;
    }

    public void setBlocked(Cola blocked) {
        this.blocked = blocked;
    }

    public void agregarProceso(Proceso proceso) throws ParseException {
        if (determinarMemoriaUsada() + proceso.getEspacio() > 2000) {
            while (determinarMemoriaUsada() + proceso.getEspacio() > 2000) {
                Proceso eliminar = LRU();
                if (ready.eliminar(eliminar)); else {
                    blocked.eliminar(eliminar);
                }
            }
        }
        encolarProceso(proceso);
    }

    public void encolarProceso(Proceso proceso) {
        if (ready.size() < 10) {
            ready.enqueue(proceso);
        } else {
            blocked.enqueue(proceso);
        }
    }

    public Proceso LRU() throws ParseException {
        LinkedList<Proceso> procesos = unirColas();
        while (procesos.size() < 1) {
            if (restarFechas(procesos.get(0).getFechaInicial(), procesos.get(1).getFechaInicial()) > 0) {
                procesos.remove(1);
            } else {
                procesos.remove(0);
            }
        }
        return procesos.get(0);
    }

    public int determinarMemoriaUsada() {
        LinkedList<Proceso> lista = unirColas();
        int total = 0;
        for (Proceso proceso : lista) {
            total += proceso.getEspacio();
        }
        return total;
    }

    public static LinkedList<Proceso> unirColas() {
        LinkedList<Proceso> lista_ready = (LinkedList<Proceso>) ready.lista;
        LinkedList<Proceso> lista_blocked = (LinkedList<Proceso>) blocked.lista;
        lista_ready.addAll(lista_blocked);
        return lista_ready;
    }

    //Metodo compara dos fechas 
    public float restarFechas(Date fecha1, Date fecha2) throws ParseException {

        float dias = (int) ((fecha1.getTime() - fecha2.getTime()));

        System.out.println("" + dias + " dias de diferencia");
        return dias;
    }

    public void dispatch() {
        Proceso proceso = ready.dequeue();
        if (proceso.getState().toString() == "NEW") {
            proceso.start();
        }

        try {
            process = proceso;
            proceso.alert();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            Thread.sleep(50);
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
        } else{
            process = null;
            terminados.add(proceso);
        }
    }

}
