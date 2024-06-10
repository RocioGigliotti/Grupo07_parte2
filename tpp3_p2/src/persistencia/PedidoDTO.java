package persistencia;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class PedidoDTO implements Serializable {
    GregorianCalendar fecha;
	protected String zona;
	protected boolean mascota;
	protected boolean usaBaul;
	protected int cantPasajeros;
	protected GregorianCalendar fechaViaje;
	protected ClienteDTO cliente;
    
}
