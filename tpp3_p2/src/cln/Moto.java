package cln;

/**
 * La clase Moto representa un tipo de vehículo que extiende la clase Vehiculo 
 * e implementa métodos específicos para definir sus características y calcular puntos.
 */
public class Moto extends Vehiculo{
	
    /**
     * Constructor de la clase Moto.
     * Establece las características específicas de una moto.
     */
	public Moto(){
        this.tipo="Moto";
		this.cantPasajeros = 1;
		this.petFriendly = false;
		this.tieneBaul = false;
	}	

    public boolean verificaMascota(Pedido pedido) { // la moto no acepta mascotas
		if (!pedido.isMascota())
			return true;
		else
			return false;	
	}

	public boolean verificaUsoDeBaul(Pedido pedido) {
		if (!pedido.isUsaBaul())
			return true;
		else
			return false;	
	}
    /**
	 * Verifica si la cantidad de pasajeros requerida por el cliente es apta para el tipo de vehiculo dado.
	 * @param pedido Pedido dado por un cliente.
	 * @return Si el vehiculo es apto o no para esta cantidad de pasajeros.
	 */
	public boolean verificaCantPasajeros(Pedido pedido) {
		if (pedido.getCantPasajeros() <= this.cantPasajeros)
			return true;
		else
			return false;
	}
 /**
     * Método para obtener los puntos asociados a una entrega con una moto.
     *
     * @param pedido El pedido asociado a la entrega.
	 * <b>Pre:</b> Pedido valido
     * @return Los puntos asignados para la entrega con una moto.
     */

	public Integer getPuntos(Pedido pedido) {
		return 1000;
	}
    public String getTipo(){
        return this.tipo;
    }
}