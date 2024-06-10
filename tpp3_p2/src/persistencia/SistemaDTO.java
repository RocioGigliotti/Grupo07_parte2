package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import persistencia.VehiculoDTO;
import persistencia.ChoferDTO;
//import persistencia.ViajeDTO;
import persistencia.ClienteDTO;
//import persistencia.PedidoDTO;

public class SistemaDTO implements Serializable{
	private ArrayList <ChoferDTO> Choferes;
	private ArrayList <VehiculoDTO> Vehiculos;
	private ArrayList <ClienteDTO> Clientes;
	private HashMap <String, String> Usuarios;

   // faltan getters y setters y constructor
   public SistemaDTO(){
   }

    public ArrayList<ChoferDTO> getChoferes() {
		return Choferes;
	}
    public ArrayList<VehiculoDTO> getVehiculos() {
		return Vehiculos;
	}

    public ArrayList<ClienteDTO> getClientes() {
		return Clientes;
	}

    public void setChoferes(ArrayList<ChoferDTO> choferes){
		this.Choferes = choferes;
	}

    public void setVehiculos(ArrayList<VehiculoDTO> vehiculos){
		this.Vehiculos = vehiculos;
    }

    public void setClientes(ArrayList<ClienteDTO> clientes){
		this.Clientes = clientes;
	}

    public HashMap<String,String> getUsuarios(){
      return Usuarios;
    }

    public void setUsuarios(HashMap<String,String>usuarios){
		this.Usuarios=usuarios;
    }

}
