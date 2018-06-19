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
public class ProcesoC extends Proceso {

    public ProcesoC() {
        super(50, new Date(), Estado.READY);
    }

    @Override
    public void run() {
        int contador = 0;
        while (true) {
            while (!run) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            contador++;
            System.out.println(PID + ": " + contador);
        }
        //No se puede poner el estado en exit porque nunca sale del ciclo
    }

}
