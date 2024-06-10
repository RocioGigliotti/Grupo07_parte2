package cln;

/**
 * La clase Automovil hace referencia a un tipo específico de vehículo que hereda de la clase Vehiculo.
 * Un automóvil puede transportar hasta cuatro pasajeros, puede llevar mascotas y tiene baul.
 */
public class Automovil extends Vehiculo{
	/**
     * Constructor de la clase Automovil.
     * Inicializa el automovil. El constructor No recibe parametros
     */
	public Automovil(){
		this.tipo="Automovil";
		this.cantPasajeros = 4;
		this.petFriendly = true;
		this.tieneBaul = true;
	}

	 public boolean verificaMascota(Pedido pedido) {
		return true;
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
     * Calcula la prioridad que tiene este vehiculo para un pedido.
     * @param pedido El pedido para el cual se calculan la prioridad.
     * @return La prioridad calculados para el pedido.
     */

	public Integer getPuntos(Pedido pedido) {
		if (pedido.isUsaBaul())
			return 40 * pedido.getCantPasajeros();
		else
			return 30 * pedido.getCantPasajeros();
	}
	public String getTipo(){
		return this.tipo;
	}
}
