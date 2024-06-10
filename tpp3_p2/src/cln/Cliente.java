package cln;
import java.io.Serializable;
/**
 * La clase Cliente representa a un cliente que interactua con el sistema. 
 * Como unico atributo tiene un nombre asociado.
 */
public class Cliente implements Serializable {
    private String nombre;
    private String contrasenia;
    /** 
     * Constructor de la clase Cliente.
     * @param nombre El nombre del cliente.
     */
    public Cliente(String nombre){
        this.nombre = nombre;
        this.contrasenia = null;
    }
    
     /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getContrasenia(){
        return contrasenia;
    }
    public String getNombre(){
        return nombre;
    }
    public void setContrasenia(String contrasenia){
       this.contrasenia = contrasenia;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
}
