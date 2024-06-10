package cln;

import java.util.Observable;
import java.util.Observer;
import cp.Vista;

public class OjoChoferRobot implements Observer{
    private Vista vista;
    private ChoferThread observado;

    public OjoChoferRobot (ChoferThread observado,Vista vista){
        this.observado = observado;
        this.observado.addObserver(this);
        this.vista=vista;
    }

    public void update(Observable chofer, Object obj){
        if (observado != chofer){
            throw new IllegalArgumentException();
        }
        String output = (String) obj;
        this.vista.escribeLogChofer(output);
    }
    
}
