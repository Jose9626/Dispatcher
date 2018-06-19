/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Luna Llena
 */
public class Proceso extends Thread {

    protected int PID;
    protected int espacio;
    protected Date fechaInicial;
    protected String estado;
    public boolean run = false;


    public Proceso(int PID, int espacio, Date fecha, String estado) {
        this.PID = PID;
        this.espacio = espacio;
        this.fechaInicial = fecha;
        this.estado = estado;
    }

    //Método compara dos fechas 
    public int restarFechas(String fecha1, String fecha2) throws ParseException {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        fechaInicial = formatoFecha.parse(fecha1);
        Date fechaFinal = formatoFecha.parse(fecha2);

        int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);

        System.out.println("" + dias + " dias de diferencia");
        return 0;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
	public void halt() throws InterruptedException {
		run = false; 
	}


	public void alert() throws InterruptedException {
		run = true;
	}

}
