/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatcher;

import java.util.ArrayList;
import java.util.Date;
import logicaNegocios.Proceso;
import logicaNegocios.ProcesoA;
import logicaNegocios.ProcesoB;
import logicaNegocios.ProcesoC;

/**
 *
 * @author gabri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int fin = 20000;
        int progreso = 2;
        System.out.println((progreso*100)/fin);
        
    }

}
