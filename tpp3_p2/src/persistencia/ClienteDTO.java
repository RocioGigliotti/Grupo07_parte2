package persistencia;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private String nombre;
    private String contrasenia;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
}
