package persistencia;

import java.io.Serializable;

public class ConfiguracionDTO implements Serializable {

    private int cantClientes;
	private int cantViajesClientes;
	private int cantChoferes;
    //private int cantChoferesPermanentes;
    //private int cantChoferesTemporarios;
	private int cantViajesChoferes;
    private SistemaDTO sistemaDTO;

    public SistemaDTO getSistemaDTO(){
        return sistemaDTO;
    }
    public void setSistemaDTO(SistemaDTO sistema){
        this.sistemaDTO=sistema;
    }
	public int getCantClientes(){
		return this.cantClientes;
	}

	public int getCantViajesClientes(){
		return this.cantViajesClientes;
	}

	public int getCantChoferes(){
		return this.cantChoferes;
	}
    /*
    public int getCantChoferesPermanentes(){
		return this.cantChoferesPermanentes;
	}
    public int getCantChoferesTemporarios(){
		return this.cantChoferesTemporarios;
	}
  */
	public int getCantViajesChoferes(){
		return this.cantViajesChoferes;
	}

	public void setCantClientes(int cant){
		this.cantClientes = cant; 
	}

	public void setCantViajesClientes(int cant){
		this.cantViajesClientes = cant; 
	}

	public void setCantChoferes(int cant){
		this.cantChoferes= cant; 
	}
    /*
    public void setCantChoferesPermanentes(int cant){
		this.cantChoferesPermanentes= cant; 
	}
	
    public void setCantChoferesTemporarios(int cant){
		this.cantChoferesTemporarios= cant; 
	}
	*/
	
	public void setCantViajesChoferes(int cant){
		this.cantViajesChoferes = cant; 
	}



    /*
    public class ConfiguracionDTO implements Serializable {
    private int cantClientes;
    private int cantPedidosCliente;
    private int cantChoferesContratados;
    private int cantChoferesPermanentes;
    private int cantChoferesTemporarios;
    private int cantViajesChofer;

    public ConfiguracionDTO(int cantClientes, int cantPedidosCliente, int cantChoferesContratados, int cantChoferesPermanentes, int cantChoferesTemporarios, int cantViajesChofer) {
        this.cantClientes = cantClientes;
        this.cantPedidosCliente = cantPedidosCliente;
        this.cantChoferesContratados = cantChoferesContratados;
        this.cantChoferesPermanentes = cantChoferesPermanentes;
        this.cantChoferesTemporarios = cantChoferesTemporarios;
        this.cantViajesChofer = cantViajesChofer;
    }

    public int getCantClientes() {
        return cantClientes;
    }

    public int getCantPedidosCliente() {
        return cantPedidosCliente;
    }

    public int getCantChoferesContratados() {
        return cantChoferesContratados;
    }

    public int getCantChoferesPermanentes() {
        return cantChoferesPermanentes;
    }

    public int getCantChoferesTemporarios() {
        return cantChoferesTemporarios;
    }

    public int getCantViajesChofer() {
        return cantViajesChofer;
    }
}
    --- ára crear los threads en simulacion
    // Crear threads de clientes
        for (int i = 0; i < rc.getCantClientes(); i++) {
            Cliente cliente = new Cliente("Cliente" + i);
            ClienteThread clienteRunnable = new ClienteThread(rc, cliente);
            Thread clienteThread = new Thread(clienteRunnable);
            //clienteThread.start();
        }

        // Crear threads de choferes contratados
        for (int i = 0; i < rc.getCantChoferesContratados(); i++) {
            Chofer chofer = sistema.agregarChoferContratado("ChoferContratado" + i, "ChoferContratado" + i);
            ChoferThread choferRunnable = new ChoferThread(rc, chofer);
            Thread choferThread = new Thread(choferRunnable);
            //choferThread.start();
        }

        // Crear threads de choferes permanentes
        for (int i = 0; i < rc.getCantChoferesPermanentes(); i++) {
            Chofer chofer = sistema.agregarChoferContratado("ChoferPermanente" + i, "ChoferPermanente" + i);
            ChoferThread choferRunnable = new ChoferThread(rc, chofer);
            Thread choferThread = new Thread(choferRunnable);
            //choferThread.start();
        }

        // Crear threads de choferes temporarios
        for (int i = 0; i < rc.getCantChoferesTemporarios(); i++) {
            Chofer chofer = sistema.agregarChoferContratado("ChoferTemporario" + i, "ChoferTemporario" + i);
            ChoferThread choferRunnable = new ChoferThread(rc, chofer);
            Thread choferThread = new Thread(choferRunnable);
            //choferThread.start();
        }
    
    PARAMETROS INICIALES:



-cantidad de Clientes
-cantidad maxima de solicitudes de viaje por cliente -> POR cliente, debe ser un numero aleatorio entre 1 y  esta cantidad
-cantidad de choferes de cada tipo
-cantidad maxima de viajes por chofer
-flota de vehiculos
-cantidad de unidades de cada tipo de vehiculo
-TODO LO DEL SISTEMA */
}
