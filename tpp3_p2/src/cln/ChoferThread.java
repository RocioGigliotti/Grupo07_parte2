package cln; 

import java.util.Observable;

public class ChoferThread extends Observable implements Runnable{
//textAreaChoferLog es donde tiene que escribir los strings
   private RecursoCompartido rc;
   private int cantViajesATomar;
   private Chofer chofer;

   public ChoferThread(RecursoCompartido rc,Chofer chofer, int cantViajesATomar) {
       this.rc = rc;
       this.chofer=chofer;
       this.cantViajesATomar = cantViajesATomar;
       
   } 
   
   public Chofer getChofer(){
    return this.chofer;
   }
   public void setChofer(Chofer chofer){
    this.chofer=chofer;
   }
   public int getCantViajesATomar(){
    return this.cantViajesATomar;
   }
   public void setCantViajesATomar(int cantViajesATomar){
    this.cantViajesATomar=cantViajesATomar;
   }

    @Override
    public void run() {
        while ((this.cantViajesATomar > 0) && (rc.cantClientesActivos > 0)) {
            Viaje viaje = rc.tomarViajeConVehiculo(this.chofer);
            if(viaje!=null){
                viaje.setEstado("Iniciado");
                setChanged();
                notifyObservers("El viaje del chofer "+this.getChofer().getNombre()+" observado ha iniciado.\n");
                try { 
                    Thread.sleep(3000); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                rc.finalizarViaje(viaje);
                viaje.setEstado("Finalizado");
                this.cantViajesATomar--;
                setChanged();
                notifyObservers("El viaje del chofer "+this.getChofer().getNombre()/*observado.getChofer().getNombre()*/+" ha finalizado.\n");
            }
        }
        rc.terminoTrabajarChofer();
        setChanged();
        notifyObservers("El chofer"+this.getChofer().getNombre()/*observado.getChofer().getNombre()*/+" dejo de trabajar.\n");
    }    
}