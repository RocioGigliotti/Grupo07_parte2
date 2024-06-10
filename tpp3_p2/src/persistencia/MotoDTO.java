package persistencia;

public class MotoDTO extends VehiculoDTO {
	
    /**
     * Constructor de la clase Moto.
     * Establece las características específicas de una moto.
     */
	public MotoDTO(){
        this.tipo="Moto";
		this.cantPasajeros = 1;
		this.petFriendly = false;
		this.tieneBaul = false;
	}
    	
     public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantPasajeros() {
		return cantPasajeros;
	}
	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}
	public boolean isPetFriendly() {
		return petFriendly;
	}
	public void setPetFriendly(boolean petFriendly) {
		this.petFriendly = petFriendly;
	}
	public boolean isTieneBaul() {
		return tieneBaul;
	}
	public void setTieneBaul(boolean tieneBaul) {
		this.tieneBaul = tieneBaul;
    }
}
