package proyectoinfra;

/**
 *
 * @author johan
 */
public class ProcesoC extends Thread{
    String PID;
    String estado;
    
    public ProcesoC(int PID){
        this.PID = "ProcesoC"+PID;
        this.estado = "New"; 
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
    
    public String getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = "ProcesoC"+PID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

