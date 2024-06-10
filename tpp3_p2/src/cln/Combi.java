package cln;

/**
 * La clase Combi es un tipo específico de vehículo que hereda de la clase Vehiculo
 * Puede transportar un máximo de 10 pasajeros 
 * Puede usar baul.
 * No es apta para mascotas.
 */

/**
 * Constructor por defecto de la clase Combi.
 * La cantidad maxima de pasajeros es 10
 * No es Pet Friendly
 * Puede usar baul
 */
public class Combi extends Vehiculo{
	public Combi(){
		this.cantPasajeros = 10;
		this.petFriendly = false;
		this.tieneBaul = true;
		this.tipo = "Combi";
	}

	public boolean verificaMascota(Pedido pedido) {
		if (!pedido.isMascota())
			return true;
		else
			return false;	
	}

	public boolean verificaUsoDeBaul(Pedido pedido) {
			return true;	
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
     * Calcula la prioridad del vehiculo para un pedido
	 * <b>Pre:</b> Pedido valido
     * @param pedido El pedido para el cual se calculan la prioridad
     * @return La prioridad del vehiculo calculada para el pedido.
     */
	public Integer getPuntos(Pedido pedido) {
		if (pedido.isUsaBaul())
			return pedido.getCantPasajeros()*10 + 100;
		else
			return pedido.getCantPasajeros()*10;
	}
	
	public String getTipo(){
		return this.tipo;
	}

}

