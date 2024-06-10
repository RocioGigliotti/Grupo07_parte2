package cln;

import java.util.Observable;
import java.util.Observer;
import cp.Vista;

public class OjoGeneral implements Observer {
    private RecursoCompartido observado;
    private Vista vista;
    public OjoGeneral (RecursoCompartido rc, Vista vista){
        this.observado = rc;
        this.observado.addObserver(this);
        this.vista = vista;
    }

    public void update(Observable rc, Object obj){
        if (observado != rc){
            throw new IllegalArgumentException();
        }
        String output = (String) obj;
        this.vista.escribeLogGeneral(output);
    }
}