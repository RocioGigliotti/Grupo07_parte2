package persistencia;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class ViajeDTO implements Serializable {
    protected GregorianCalendar fecha;
	protected PedidoDTO pedido;
	protected ChoferDTO chofer;
	protected VehiculoDTO vehiculo;
	protected double distancia;
	protected String estado;
    
    public GregorianCalendar getFecha() {
        return fecha;
    }
    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
    public PedidoDTO getPedido() {
        return pedido;
    }
    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }
    public ChoferDTO getChofer() {
        return chofer;
    }
    public void setChofer(ChoferDTO chofer) {
        this.chofer = chofer;
    }
    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }
    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
