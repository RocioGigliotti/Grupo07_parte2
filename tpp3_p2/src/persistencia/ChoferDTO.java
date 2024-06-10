package persistencia;

import java.io.Serializable;

public class ChoferDTO implements Serializable {
    
    protected String dni;
	protected String nombre;
	protected int cantViajesTomados;
	protected String tipo;
	protected int puntaje;
    
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantViajesTomados() {
        return cantViajesTomados;
    }
    public void setCantViajesTomados(int cantViajesTomados) {
        this.cantViajesTomados = cantViajesTomados;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
