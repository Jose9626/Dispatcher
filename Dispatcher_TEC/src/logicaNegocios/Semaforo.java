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

    private ArrayList<Proceso> listaEspera = new ArrayList<Proceso>();
    private int seminit = 0;

    
    
    public int getSeminit() {
		return seminit;
	}

	public void setSeminit(int seminit) {
		seminit = seminit;
	}

	public void semwait(Proceso proceso) {
        if (seminit == 2) {
            listaEspera.add(proceso);
            proceso.setRecursos(false);

        } else if(proceso.isRecursos()) {
        	
        }
        else {
            seminit++;
            proceso.setRecursos(true);
        }
    }

    public void semsignal(Proceso proceso) {
        System.out.println("SEMAFORO  ANTES: "+ seminit);

            seminit--;
            System.out.println("SEMAFORO : "+ seminit);

            if (listaEspera.size() > 0) {
                Proceso nuevoproceso = listaEspera.get(0);
                listaEspera.remove(0);

                System.out.println("PID : "+ nuevoproceso.getPID());
                System.out.println("SIZE : "+ listaEspera.size());

                
                semwait(nuevoproceso);
            }
    }

}
