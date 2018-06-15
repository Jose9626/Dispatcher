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
public class ProcesoA extends Proceso{
    
    public ProcesoA(int PID, int espacio, Date fecha, String estado){
        super(PID, espacio, fecha, estado);
    }
    
    @Override
    public void run(){
        int contador=1;
        while (contador<20000){
            contador+=1;
            System.out.println(PID+": "+contador);
        }
        this.estado="Exit";
    }
    
}
