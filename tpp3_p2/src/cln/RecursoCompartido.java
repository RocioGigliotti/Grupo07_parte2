package cln;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.HashMap;

public class RecursoCompartido extends Observable {
    int cantClientesActivos;
    int cantChoferesActivos;
    Sistema sistema;

    public int getcantClientesActivos(){
        return this.cantClientesActivos;
    }
    public int getCantChoferesActivos(){
        return this.cantChoferesActivos;
    }
    public void setCantChoferesActivos(int cantChoferesActivos){
        this.cantChoferesActivos=cantChoferesActivos;
    }
     public void setCantClientesActivos(int cantClientesActivos){
        this.cantClientesActivos=cantClientesActivos;
    }
    public Sistema getSistema(){
        return this.sistema;
    }

    private List<Viaje> viajesSolicitados = new ArrayList<Viaje>();
    private List<Viaje> viajesConVehiculo = new ArrayList<Viaje>();
    private List<Viaje> viajesIniciados = new ArrayList<Viaje>();
    private List<Viaje> viajesPagados = new ArrayList<Viaje>();
    private List<Viaje> viajesFinalizados = new ArrayList<Viaje>();
    private List<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>();

    public RecursoCompartido(int cantClientesActivos, int cantChoferesActivos, Sistema sistema){
        this.cantClientesActivos = cantClientesActivos + 1; //este es el cliente humano 
        this.cantChoferesActivos = cantChoferesActivos;
        this.sistema=sistema;
        for (Vehiculo v : this.sistema.getVehiculos()) {
            this.vehiculosDisponibles.add(v);
        }
    }

    public boolean validarPedido(Pedido pedido){
        Vehiculo vehiculo = null;
        if (pedido.esValido() && this.cantChoferesActivos > 0){
            try {
            	vehiculo = sistema.buscaVehiculo(pedido);
            } catch (FaltaVehiculoException e) {
            	return false;
            }
            if (vehiculo == null)
                return false;
            else
                return true;
        }
        else 
            return false;
    }

    // lo usa ClienteThread para inicializar un viaje a partir de un pedido valido
    public synchronized Viaje crearViajedePedidoValido(Pedido pedidoValidado){
        Viaje viaje = null;
        viaje = sistema.crearViaje(pedidoValidado ,100);
        viajesSolicitados.add(viaje);   
        viaje.setEstado("Solicitado");     
        setChanged();
        notifyObservers("El viaje de "+ viaje.getPedido().getCliente().getNombre()+" ha sido solicitado\n");
        notifyAll();
        return viaje;
    }

    public synchronized void asignarVehiculo(){
        Vehiculo vehiculo = null;
        Viaje viaje;
        while (viajesSolicitados.isEmpty() && this.cantChoferesActivos>0 && this.cantClientesActivos>0){//no hay viajes solicitados sin vehiculo, debe esperar.
            try{
                wait();
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }        
        }
        int index = 0;
        while(!viajesSolicitados.isEmpty() && index<viajesSolicitados.size()){
            viaje = viajesSolicitados.get(index);
            try{
                vehiculo = sistema.buscaVehiculo(viaje.getPedido());
            }
            catch(FaltaVehiculoException e){
                //nunca va a entrar
            }   
            if (vehiculosDisponibles.contains(vehiculo)){
                viaje.setVehiculo(vehiculo);
                viajesSolicitados.remove(viaje);
                vehiculosDisponibles.remove(vehiculo);
                viajesConVehiculo.add(viaje);
                viaje.setEstado("Con Vehiculo");
                notifyAll();
                setChanged();
                notifyObservers("El sistema le asigno un vehiculo al viaje de "+viaje.getPedido().getCliente().getNombre()+"\n");
            
            }
            index++;
            }
        }
        

    // lo usa ChoferThread para iniciar un viaje
    public synchronized Viaje tomarViajeConVehiculo(Chofer chofer) {
        Viaje viaje = null;
        while ((viajesConVehiculo.isEmpty()) && (this.cantClientesActivos>0)) {
	        try{
	            wait();
	        } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	        }
        }
        if ((this.cantClientesActivos>0) && (!viajesConVehiculo.isEmpty())){
	        viaje = viajesConVehiculo.get(0);
	        viajesConVehiculo.remove(viaje);
            viaje.setEstado("Iniciado");      
            viaje.setChofer(chofer);   
            setChanged();
            notifyObservers("El chofer "+ viaje.getChofer().getNombre()+ " ha tomado el viaje de "+viaje.getPedido().getCliente().getNombre()+".\n");        
	        viajesIniciados.add(viaje);
	        notifyAll();
        }
        return viaje;
    }

    // lo usa ClienteThread para pagar un viaje
    public synchronized void pagarViaje(Viaje viaje){ 
        while (!viajesIniciados.contains(viaje) && (cantChoferesActivos>0)){
            try{
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();    
            }
        }
        if(cantChoferesActivos>0){
            viajesIniciados.remove(viaje);
            viaje.setEstado("Pagado");
            setChanged();
            notifyObservers("El cliente "+ viaje.getPedido().getCliente().getNombre()+" pago el viaje.\n");
            viajesPagados.add(viaje);
            notifyAll();
        }
    }
    
    // lo usa ChoferThread para finalizar un viaje
    public synchronized void finalizarViaje(Viaje viaje) { 
        while (!viajesPagados.contains(viaje)){
            try{
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }       
        }
        viaje.setEstado("Finalizado");
        setChanged();
        notifyObservers("El chofer "+viaje.getChofer().getNombre()+" ha terminado el viaje de "+viaje.getPedido().getCliente().getNombre()+".\n");    
        vehiculosDisponibles.add(viaje.getVehiculo());
        viajesPagados.remove(viaje);
        viajesFinalizados.add(viaje);
        notifyAll();
    }

    // lo usa el rc para frenar todo si no hay mas choferes trabajando
    public synchronized void terminoTrabajarChofer(){
        this.cantChoferesActivos -= 1;
        notifyAll();
    }

    // lo usa el rc para frenar todo si no hay mas clientes haciendo pedidos
    public synchronized void terminoPedirCliente(){
        this.cantClientesActivos -= 1;
        notifyAll();
    } 
}