/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocios;

import java.util.ArrayList;

/**
 *
 * @author Luna Llena
 */
public class Semaforo {

    private ArrayList<ProcesoB> listaEspera;
    private int seminit = 0;

    public void semwait(ProcesoB proceso) {
        if (seminit == 2) {
            listaEspera.add(proceso);
        } else {
            seminit++;
        }
    }

    public void semsignal(ProcesoB proceso) {
        if (seminit > 0) {
            seminit--;
            if (listaEspera.size() != 0) {
                ProcesoB nuevoproceso = listaEspera.get(0);
                listaEspera.remove(nuevoproceso);
                semwait(nuevoproceso);
            }
        }
    }

}
