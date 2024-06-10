package cln;

import java.util.Observable;
import java.util.ArrayList;
import java.util.Random;

public class ClienteThread extends Observable implements Runnable {
    private RecursoCompartido rc;
    private Cliente cliente;
    private int cantPedidos;

	public ClienteThread (RecursoCompartido rc, Cliente cliente,int cantPedidos) {
        this.rc = rc;
        this.cliente = cliente;
        this.cantPedidos = cantPedidos;
    }
      public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getCantPedidos() {
		return cantPedidos;
	}
	public void setCantPedidos(int cantPedidos) {
		this.cantPedidos = cantPedidos;
	}
    @Override
    public void run() {
        Viaje viaje;
        Random random = new Random();
        ArrayList<String>listaZonas=new ArrayList<String>();
        listaZonas.add("ZonaPeligrosa");
        listaZonas.add("ZonaEstandar");
        listaZonas.add("ZonaSinAsfaltar");

        while ((this.cantPedidos > 0) && (rc.getCantChoferesActivos() > 0)){
            //String zona = listaZonas.get(random.nextInt(listaZonas.size()-1));
            //Pedido pedido = new Pedido(2024, 6, 5, zona, random.nextBoolean(), random.nextBoolean(), random.nextInt(10)+1, cliente);
            Pedido pedido = new Pedido(2024, 6, 5, "ZonaPeligrosa", false, false, 3, cliente);
            if (rc.validarPedido(pedido)) {
                setChanged();
                notifyObservers("El pedido del cliente "+this.getCliente().getNombre()+" fue validado.\n");
                viaje = rc.crearViajedePedidoValido(pedido);
                setChanged();
                notifyObservers("El viaje del cliente"+ this.cliente.getNombre()+" ha sido iniciado.\n");
                try{
                    Thread.sleep(3000);
                } catch(InterruptedException ex){ 
                    ex.printStackTrace();
                }           
                rc.pagarViaje(viaje);
                setChanged();
                notifyObservers("El cliente "+this.cliente.getNombre()+" ha pagado el viaje.\n");
            }  
            try{
                Thread.sleep(3000);
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }
            this.cantPedidos--;
        }   
            rc.terminoPedirCliente();
            setChanged();
            notifyObservers("El cliente "+this.cliente.getNombre()+" ya no tiene mas pedidos pendientes.\n");
        }
}