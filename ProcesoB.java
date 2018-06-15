package proyectoinfra;


public class ProcesoB extends Thread{
    String PID;
    String estado;
    boolean necesitaRecursos;
    boolean estadoRecurso;
    
    public ProcesoB(int PID, String procesoSeleccionado, int cantRecursos){
        this.PID = "ProcesoB" + PID;
        this.estado = "New";
        this.necesitaRecursos = true;
        if(cantRecursos > 0){
            this.estadoRecurso = true;
        }
        else{
            this.estadoRecurso = false;
        }
    }
    
    @Override
    public void run(){
        int contador=1;
        while (contador<30000){
            contador+=1;
            System.out.println(PID+": "+contador);
        }
        this.estado="Exit";
        System.out.println("\nEl proceso ha dejado de utilizar los recursos");
    }
    
    public String getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = "ProcesoB"+PID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isNecesitaRecursos() {
        return necesitaRecursos;
    }

    public void setNecesitaRecursos(boolean necesitaRecursos) {
        this.necesitaRecursos = necesitaRecursos;
    }

    public boolean isEstadoRecurso() {
        return estadoRecurso;
    }

    public void setEstadoRecurso(boolean estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }
}
