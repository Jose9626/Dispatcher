package proyectoinfra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Proceso {
    
    int PID;
    int espacio;
    Date fechaInicial;

    public  Proceso(int PID, int espacio){
        this.PID=PID;
        this.espacio=espacio;
    }
    
    //Método compara dos fechas 
    public int restarFechas(String fecha1, String fecha2) throws ParseException{
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
 
	fechaInicial = formatoFecha.parse(fecha1);
	Date fechaFinal = formatoFecha.parse(fecha2);
 
	int dias = (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
 
	System.out.println(""+dias+" dias de diferencia");
        return 0;        
    }

    public int getPID() {
       return PID;
    }

    public int getEspacio() {
       return espacio;
    }
    
    public void setFechaInicial(Date pFechaInicial){
        this.fechaInicial = pFechaInicial;
    }
    
    public void setFecha2(Date pFechaFinal){
        this.fechaFinal = pFechaFinal;
    }
}
