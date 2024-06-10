package cln;

import java.util.Observable;
import java.util.Observer;
import cp.Vista;

public class OjoClienteRobot implements Observer {
    private Vista vista;
    private ClienteThread cliente; 

    public OjoClienteRobot(ClienteThread cliente,Vista vista){
        super();
        this.cliente=cliente;
        this.cliente.addObserver(this);
        this.vista=vista;
    }
    
    public void update(Observable observable,Object obj){
        if (this.cliente==observable){
            String output=(String) obj;
            this.vista.escribeLogCliente(output);
        }
        else
            throw new IllegalArgumentException();
    }
}
