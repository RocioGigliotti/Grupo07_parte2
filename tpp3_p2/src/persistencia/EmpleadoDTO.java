package persistencia;

public class EmpleadoDTO extends ChoferDTO {
    protected double aportes;

    public double getAportes() {
        return aportes;
    }

    public void setAportes(double aportes) {
        this.aportes = aportes;
    }
}
