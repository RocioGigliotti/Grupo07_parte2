package cln;

import java.io.Serializable;
/**
 * La clase abstracta Vehiculo es una clase que define el comportamiento y las caracteristicas comunes a todos los vehiculos del sistema
 */
public abstract class Vehiculo implements Serializable {
	
	protected String tipo;
	protected int cantPasajeros;
	protected boolean petFriendly;
	protected boolean tieneBaul;
	
	public abstract String getTipo();
	
	public int getCantPasajeros() {
		return cantPasajeros;
	}

	public boolean isPetFriendly() {
		return petFriendly;
	}
	
	public boolean isTieneBaul() {
		return tieneBaul;
	}

	/**
	 * Verifica si la cantidad de pasajeros requerida por el cliente es apta para el tipo de vehiculo dado.
	 * Es un metodo abstracto, cada vehiculo lo va a implementar segun sus caracteristicas.
	 * @param pedido Pedido dado por un cliente.
	 * @return Si el vehiculo es apto o no para esta cantidad de pasajeros.
	 */
	public abstract boolean verificaCantPasajeros(Pedido pedido);
	/**
	 * Verifica si el vehiculo dado dispone de baul o no en caso de que el pedido lo requiera.
	 * Es un metodo abstracto, cada vehiculo lo va a implementar segun sus caracteristicas.
	 * @param pedido Pedido dado por un cliente.
	 * @return Si el vehiculo incluye baul y es requerido por el pedido, o si no lo incluye y no es requerido.
	 */ 
	public abstract boolean verificaUsoDeBaul(Pedido pedido);
	/**
	 * Verifica si el vehiculo es apto para mascotas en caso de que el pedido lo requiera.
	 * Es un metodo abstracto, cada vehiculo lo va a implementar segun sus caracteristicas.
	 * @param pedido Pedido dado por un cliente.
	 * @return Si el vehiculo es apto para mascotas y es requerido por el pedido, o si no es apto y no es requerido.
	 */
	public abstract boolean verificaMascota(Pedido pedido);
	/**
	 * Obtiene la cantidad de puntos para el calculo de prioridad segun el tipo de vehiculo.
	 * Es un metodo abstracto que se debe implementar para cada tipo de vehiculo.
	 * @param pedido Pedido dado por un cliente.
	 * @return La cantidad de puntos correspondiente a este tipo de vehiculo.
	 */
	public abstract Integer getPuntos(Pedido pedido);
	/**
	 * Obtiene el indice de prioridad del vehiculo para un pedido dado.
	 * @param pedido Pedido dado por un cliente.
	 * @return Si el vehiculo es apto para el viaje, su indice de prioridad. Si no es apto, retorna null.
	 */
	public Integer getPrioridad(Pedido pedido) {
		boolean verificaCant = verificaCantPasajeros(pedido);
		boolean verificaBaul = verificaUsoDeBaul(pedido);
		boolean verificaMascota = verificaMascota(pedido); 
		if (verificaCant && verificaBaul && verificaMascota){
			return getPuntos(pedido);		
		} else {
			return null;
		}
	}
}
