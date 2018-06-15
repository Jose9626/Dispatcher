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
public class ProcesoC extends Proceso{

    public ProcesoC(int PID, int espacio, Date fecha, String estado) {
        super(PID, espacio, fecha, estado);
    }
    
    @Override
    public void run(){
        String tag;
        while (true){
            tag="Corriendo..";
            System.out.println(PID+": "+tag);
        }
        //No se puede poner el estado en exit porque nunca sale del ciclo
    }

}