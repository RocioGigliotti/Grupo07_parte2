package cln;

public class Estado {
    private String output;
    private String estadoViaje;

    public Estado(String output,String estado){
        this.output=output;
        this.estadoViaje=estado;
    }
    public Estado(){
        this.output=null;
        this.estadoViaje=null;
    }
    public String getEstadoViaje(){
        return this.estadoViaje;
    }
    public void setEstadoViaje(String estadoViaje){
        this.estadoViaje=estadoViaje;
    }
    public void setOutput(String output){
        this.output=output;
    }
    public String getOutput(){
        return this.output;
    }
}
