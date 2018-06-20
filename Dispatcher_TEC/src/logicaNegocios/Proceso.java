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
public abstract class Proceso extends Thread {

    private static int ID = 0;
    protected int PID;
    protected int espacio;
    protected Date fecha;
    protected int contador = 0;
    public int contadorFinal;
    public boolean run = false;
    protected boolean recursos = true;

    public Proceso(int espacio, Date fecha, int fin) {
        this.PID = ID++;
        this.espacio = espacio;
        this.fecha = fecha;
        this.contadorFinal = fin;
    }
    
    public Proceso(int espacio, Date fecha) {
        this.PID = ID++;
        this.espacio = espacio;
        this.fecha = fecha;
    }
  
    public boolean isRecursos() {
		return recursos;
	}

	public void setRecursos(boolean recursos) {
		this.recursos = recursos;
	}

	//Método compara dos fechas 
    public int restarFechas(String fecha1, String fecha2) throws ParseException {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        fecha = formatoFecha.parse(fecha1);
        Date fechaFinal = formatoFecha.parse(fecha2);

        int dias = (int) ((fechaFinal.getTime() - fecha.getTime()) / 86400000);

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
        return fecha;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fecha = fechaInicial;
    }

    public void halt() throws InterruptedException {
        run = false;
    }

    public void alert() throws InterruptedException {
        run = true;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
