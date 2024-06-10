package persistencia;

public class ChoferContratadoDTO extends ChoferDTO {
    //private static final double ganancia_viaje= 0.75;
	private double acumGanancias;

    public double getAcumGanancias() {
        return acumGanancias;
    }

    public void setAcumGanancias(double acumGanancias) {
        this.acumGanancias = acumGanancias;
    }
}
