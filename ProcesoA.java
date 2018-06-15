package proyectoinfra;

public class ProcesoA extends Thread{
    String PID;
    String estado;
    
    public ProcesoA(int PID){
        this.PID = "ProcesoA" + PID;
        this.estado = "New";
    }
    
    @Override
    public void run(){
        int contador=1;
        int respuesta=1;
        while (contador<20000){
            //respuesta = contador+contador;
            contador+=1;
            System.out.println(PID+": "+contador);
        }
        this.estado="Exit";
    }
    
    public String getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = "ProcesoA"+PID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
