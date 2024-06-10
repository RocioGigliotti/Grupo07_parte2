package cln;

import java.io.IOException;
import persistencia.IPersistencia;
import persistencia.SistemaDTO;
import persistencia.UtilSistema;
import persistencia.PersistenciaXML;
import persistencia.PersistenciaBIN;
import persistencia.ConfiguracionDTO;

public class SistemaThread extends Thread{
    private RecursoCompartido rc;

    public SistemaThread(RecursoCompartido rc) {
        this.rc = rc;
    }

    @Override
    public void run() {
        while ((rc.getCantChoferesActivos() > 0) && (rc.getcantClientesActivos() > 0)) {
            rc.asignarVehiculo();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    IPersistencia persistencia = new PersistenciaXML(); 
    //IPersistencia persistencia = new PersistenciaBIN();
    try{
        persistencia.abrirOutput("SistemaUsuarios.XML");
        SistemaDTO sistemaDTO = UtilSistema.sistemaDTOFromSistema(rc.getSistema());
        ConfiguracionDTO configuracionDTO = UtilSistema.guardaConfiguracionDTO(sistemaDTO, 2, 2);
        persistencia.escribir(configuracionDTO);
        persistencia.cerrarOutput();
    } catch (IOException e){
        //System.out.println("Hubo un error de IOException\n");
    }
    }
}