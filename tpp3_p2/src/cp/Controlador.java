package cp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cln.*;

public class Controlador implements ActionListener{
    private Vista vista;
    private RecursoCompartido modelo;
	private Cliente usuario; 
	private OjoClienteHumano ojo;

    public Controlador(Vista vista, RecursoCompartido modelo){
        super();
        this.vista = vista;
        this.modelo = modelo;
        this.usuario = new Cliente("El usuario actual");
		this.ojo = new OjoClienteHumano(vista);
    }

	@Override
    public void actionPerformed(ActionEvent e) {
        Viaje viaje = null;
		if (e.getActionCommand().equals("Pedir")) {
			if (modelo.getCantChoferesActivos()>0){
				vista.getBtnRealizarPedido().setEnabled(false);	
			    int pasajeros = vista.getCantPasajeros();
                if (pasajeros == 0) {
                	//no hago nada
				}
				else 
				   	if (pasajeros < 1)
				    	vista.muestraVentanaEmergente("El numero de cantidad de pasajeros debe ser positivo\n");
			    	else{ //Pedido(int anio, int mes, int dia, String zona, boolean mascota, boolean usaBaul, int cantPasajeros, Cliente cliente)						
						Pedido pedido = new Pedido(2024, 6, 8, vista.getZonaSeleccionada(), vista.tieneMascota(), vista.tieneBaul(), pasajeros, usuario);                   
						if (this.modelo.validarPedido(pedido)){
							viaje = this.modelo.crearViajedePedidoValido(pedido);
							ojo.setObservado(viaje);
                            this.vista.escribeLogUser("Tu pedido esta en proceso\n");	
							vista.getBtnPagar().setEnabled(true);					
						}
						else{
                            this.vista.escribeLogUser("Tu pedido no es valido.. realiza otro pedido\n");
							vista.getBtnRealizarPedido().setEnabled(false);
							vista.getBtnPagar().setEnabled(false);
                        }
					}	
        	}else{
				vista.muestraVentanaEmergente("No hay mas choferes para tomar tu pedido\n");
			}
		}
        else 
			if (e.getActionCommand().equals("Pagar")){
				vista.getBtnPagar().setEnabled(false);
				this.modelo.pagarViaje(ojo.getObservado());
        		this.vista.escribeLogUser("Pagaste el viaje\n");
				vista.getBtnRealizarPedido().setEnabled(true);							
        	} 	
			else 
				if (e.getActionCommand().equals("LogOut")){
					vista.getBtnRealizarPedido().setEnabled(false);
					vista.getBtnPagar().setEnabled(false);
            		this.modelo.terminoPedirCliente();
					this.vista.muestraVentanaEmergente("Muchas gracias por utilizar nuestro servicio!");
					this.vista.escribeLogUser("Terminaste tus pedidos\n");
					this.vista.escribeLogUser("Cantidad de clientes en el sistema: "+this.modelo.getcantClientesActivos()+"\n");
					this.vista.escribeLogUser("Cantidad de choferes en el sistema: "+this.modelo.getCantChoferesActivos()+"\n");
        	}       
	}
}
	
