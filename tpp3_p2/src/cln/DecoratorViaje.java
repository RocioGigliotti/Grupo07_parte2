package cln;
import java.util.GregorianCalendar;
/**
 * La clase abstracta DecoratorViaje es una clase base para implementar el patrón Decorator y extiende de la clase abstracta Viaje
 * Los decoradores de viaje se utilizan para calcular el costo de un Viaje
 */
public abstract class DecoratorViaje extends Viaje {
	Viaje viaje;

    public Viaje getViaje() {
		return viaje;
	}
	
	public void setViaje(Viaje viaje) {
		this.viaje=viaje;
	}

    public double getDistancia() {
		return getViaje().getDistancia();
	}
	public double getCostoBase() {
		return getViaje().getCostoBase();
	}
    public Chofer getChofer(){
		return getViaje().getChofer();
	}
	
	public Vehiculo getVehiculo(){
		return getViaje().getVehiculo();
	}

	public GregorianCalendar getFecha(){
		return getViaje().getFecha();
	}
	
	public Pedido getPedido() {
		return getViaje().getPedido();
	}
}