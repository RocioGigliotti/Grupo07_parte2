package persistencia;

import cln.Sistema;
import cln.Vehiculo;
import cln.VehiculoFactory;
import cln.Chofer;
import cln.ChoferContratado;
import cln.ChoferPermanente;
import cln.ChoferTemporario;
import cln.Cliente;
import cln.RecursoCompartido;
import persistencia.ConfiguracionDTO;

import java.util.ArrayList;

public class UtilSistema {
    public UtilSistema(){
    }

    public static RecursoCompartido configuracionInicial(ConfiguracionDTO configuracionDTO){
        //configuracionDTO ya cargado entra a configuracion inicial.
        RecursoCompartido rc=null;
        int cantClientes = configuracionDTO.getCantClientes();
        int cantChoferes = (configuracionDTO.getCantChoferes());
        rc=new RecursoCompartido(cantClientes,cantChoferes,sistemaFromSistemaDTO(configuracionDTO.getSistemaDTO()));
        return rc;
    }

    public static ConfiguracionDTO guardaConfiguracionDTO(SistemaDTO sistema, int cantmaxChofer, int cantmaxCliente){
        ConfiguracionDTO configuracion = new ConfiguracionDTO();
        configuracion.setCantChoferes(sistema.getChoferes().size());
        configuracion.setCantClientes(sistema.getClientes().size());
        configuracion.setCantViajesChoferes(cantmaxChofer);
        configuracion.setCantViajesClientes(cantmaxCliente);
        configuracion.setSistemaDTO(sistema);
        return configuracion;
    }

    public static SistemaDTO sistemaDTOFromSistema(Sistema sistema){
        SistemaDTO sistemaDTO = new SistemaDTO();
        ArrayList<ChoferDTO>choferesDTO=new ArrayList<ChoferDTO>();
         for(int i=0;i<sistema.getChoferes().size();i++){
            choferesDTO.add(UtilSistema.choferDTOfromChofer(sistema.getChoferes().get(i)));
        }
        sistemaDTO.setChoferes(choferesDTO);

        ArrayList<VehiculoDTO>vehiculosDTO=new ArrayList<VehiculoDTO>();
        for(int i=0;i<sistema.getVehiculos().size();i++){
            vehiculosDTO.add(UtilSistema.vehiculoDTOfromVehiculo(sistema.getVehiculos().get(i)));
        }
        sistemaDTO.setVehiculos(vehiculosDTO);

        ArrayList<ClienteDTO>clientesDTO=new ArrayList<ClienteDTO>();
        for(int i=0;i<sistema.getClientes().size();i++){
            clientesDTO.add(UtilSistema.clienteDTOfromCliente(sistema.getClientes().get(i)));
        }
        sistemaDTO.setClientes(clientesDTO);

        sistemaDTO.setUsuarios(sistema.getUsuarios()); 
        return sistemaDTO;
    }

	public static Sistema sistemaFromSistemaDTO(SistemaDTO sistemaDTO){
        Sistema sistema=Sistema.getInstance();
        
        ArrayList<Chofer>choferes=new ArrayList<Chofer>();
         for(int i=0;i<sistemaDTO.getChoferes().size();i++){
            choferes.add(UtilSistema.choferfromChoferDTO(sistemaDTO.getChoferes().get(i)));
        }
        sistema.setChoferes(choferes);
        ArrayList<Vehiculo>vehiculos=new ArrayList<Vehiculo>();
        for(int i=0;i<sistemaDTO.getVehiculos().size();i++){
            vehiculos.add(UtilSistema.vehiculofromVehiculoDTO(sistemaDTO.getVehiculos().get(i)));
        }
        sistema.setVehiculos(vehiculos);
        ArrayList<Cliente>clientes=new ArrayList<Cliente>();
        for(int i=0;i<sistemaDTO.getClientes().size();i++){
            clientes.add(UtilSistema.clientefromClienteDTO(sistemaDTO.getClientes().get(i)));
        }
        sistema.setClientes(clientes);
        sistema.setUsuarios(sistemaDTO.getUsuarios());
        return sistema;
    } 

	public static ClienteDTO clienteDTOfromCliente(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setContrasenia(cliente.getContrasenia());
        return clienteDTO; 
    }

    public static Cliente clientefromClienteDTO(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente(clienteDTO.getNombre());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setContrasenia(clienteDTO.getContrasenia());
        return cliente; 
    }
    
    public static ChoferDTO choferDTOfromChofer(Chofer chofer){
        ChoferDTO choferDTO = new ChoferDTO();
        choferDTO.setNombre(chofer.getNombre());
        choferDTO.setDni(chofer.getDNI());
        choferDTO.setPuntaje(chofer.getPuntaje());
        choferDTO.setTipo(chofer.getTipo());
        choferDTO.setCantViajesTomados(chofer.getCantViajes());
        return choferDTO; 
    }

    public static Chofer choferfromChoferDTO(ChoferDTO choferDTO){
        Chofer chofer;
        if(choferDTO.getTipo().equals("CONTRATADO")){
            chofer=new ChoferContratado(choferDTO.getDni(),choferDTO.getNombre());
        }
        else{
            if(choferDTO.getTipo().equals("TEMPORARIO")){
                chofer=new ChoferTemporario(choferDTO.getDni(),choferDTO.getNombre(),0);
            }
            else{
                chofer=new ChoferPermanente(choferDTO.getDni(),choferDTO.getNombre(),0,0,0,0);
            }
        }
        chofer.setPuntaje(choferDTO.getPuntaje());
        chofer.setCantViajes(choferDTO.getCantViajesTomados());
        return chofer; 
    }

    private static VehiculoDTO vehiculoDTOfromVehiculo(Vehiculo vehiculo) {
		VehiculoDTO vehiculoDTO;
        if(vehiculo.getTipo().equals("Moto")){
            vehiculoDTO=new MotoDTO();
        }
        else{
            if(vehiculo.getTipo().equals("Combi")){
                vehiculoDTO=new CombiDTO();
            }
            else{
                vehiculoDTO=new AutomovilDTO();
            }
        }
        return vehiculoDTO;
	}

    private static Vehiculo vehiculofromVehiculoDTO(VehiculoDTO vehiculoDTO) {
        VehiculoFactory factoryVehiculos=new VehiculoFactory();
		Vehiculo vehiculo = factoryVehiculos.getVehiculo(vehiculoDTO.getTipo());
        return vehiculo;
	}
}
