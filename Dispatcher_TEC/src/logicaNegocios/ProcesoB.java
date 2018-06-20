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
    
    public ProcesoB() {
        super(100, new Date(), 100000);
        recursos = false;
        Dispatcher.semaforo.semwait(this);
    }

    @Override
    public void run() {
        while (contador < contadorFinal) {
            while (!run && !recursos) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            contador += 1;
            System.out.println(PID + ": " + contador);
        }
        System.out.println("\nEl proceso ha dejado de utilizar los recursos");
        Dispatcher.semaforo.semsignal(this);
    }

}
