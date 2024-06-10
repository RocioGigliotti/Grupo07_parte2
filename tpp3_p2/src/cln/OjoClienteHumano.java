package cln;

import java.util.Observable;
import java.util.Observer;
import cp.Vista;

public class OjoClienteHumano implements Observer {
	private Viaje observado;
	private Vista vista;
	
	public OjoClienteHumano(Vista vista){
		this.observado = null;
		this.vista = vista;
	}

	public OjoClienteHumano(Viaje viaje, Vista vista){
		this.observado = viaje;
		this.observado.addObserver(this);
		this.vista=vista;
	}

	@Override
	public void update(Observable viaje, Object estadoObs) {
        if (observado != viaje){
            throw new IllegalArgumentException();
        }
		else {
			String estado = (String)estadoObs;
			this.vista.escribeLogUser("Estado de su viaje actual: "+estado+"\n");
		}
	}
	
	public Viaje getObservado(){
		return this.observado;
	}
	
	public void setObservado(Viaje viaje) {
		this.observado = viaje;
		viaje.addObserver(this);
	}
}