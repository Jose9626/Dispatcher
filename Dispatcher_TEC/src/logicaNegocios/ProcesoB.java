/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocios;

import java.util.Date;

/**
 *
 * @author Luna Llena
 */
public class ProcesoB extends Proceso {

    public ProcesoB(int PID, int espacio, Date fecha, String estado) {
        super(PID, espacio, fecha, estado);
    }

    @Override
    public void run() {
        int contador = 1;
        while (contador < 30000) {
            while (!run) {
                try {
    				Thread.sleep(1);
    				} 
                catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
            contador += 1;
            System.out.println(PID + ": " + contador);
        }
        this.estado = "Exit";
        System.out.println("\nEl proceso ha dejado de utilizar los recursos");
    }
    
}
