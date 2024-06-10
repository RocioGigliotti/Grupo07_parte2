package persistencia;

public class CombiDTO extends VehiculoDTO {
	public CombiDTO(){
    	this.cantPasajeros = 10;
		this.petFriendly = false;
		this.tieneBaul = true;
		this.tipo = "Combi";
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
