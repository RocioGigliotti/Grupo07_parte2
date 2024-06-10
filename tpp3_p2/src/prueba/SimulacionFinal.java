package prueba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cln.ChoferThread;
import cln.Cliente;
import cln.ClienteThread;
import cln.RecursoCompartido;
import cln.SistemaThread;
import cp.Controlador;
import cp.Vista;
import cln.Vehiculo;
import cln.Sistema;
import cln.Chofer;
import cln.OjoChoferRobot;
import cln.OjoClienteRobot;
import cln.OjoGeneral;
import cln.OjoClienteHumano;
import cp.Login;
import cp.ControladorLogin;
import persistencia.ConfiguracionDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;
import persistencia.UtilSistema;
import persistencia.SistemaDTO;

public class SimulacionFinal {
    public static void main(String[] args){
        IPersistencia persistencia = new PersistenciaXML();
        RecursoCompartido rc = null;
        Sistema sistema = null;
        ConfiguracionDTO configuracion = null;
        try{
            persistencia.abrirInput("SistemaUsuarios.XML");
            System.out.println("Archivo abierto");
            configuracion=(ConfiguracionDTO) persistencia.leer();
            rc= UtilSistema.configuracionInicial(configuracion);
            sistema = rc.getSistema();
            System.out.println("Sistema recuperado");
            persistencia.cerrarInput();
            System.out.println("Archivo cerado");
        }catch (IOException e)
         {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

        
        ArrayList<ClienteThread> clientesRunnable = new ArrayList<ClienteThread>();
        System.out.println("El largo del arraylist de clientes es "+configuracion.getCantClientes());
        for(int i=0;i<configuracion.getCantClientes();i++){
            Cliente cliente=sistema.getClientes().get(i);
            clientesRunnable.add(new ClienteThread(rc,cliente,configuracion.getCantViajesClientes()));
        }

        ArrayList<ChoferThread> choferesRunnable=new ArrayList<ChoferThread>();
        for(int i=0;i<configuracion.getCantChoferes();i++){
            Chofer chofer=sistema.getChoferes().get(i);
            choferesRunnable.add(new ChoferThread(rc,chofer,configuracion.getCantViajesChoferes()));
        }

        SistemaThread sistemaThread = new SistemaThread(rc);
        
        OjoClienteHumano ojoClienteHumano;
        Vista vista = new Vista();
        Login login=new Login();
        Controlador controlador = new Controlador(vista,rc);
        ControladorLogin controladorLogin=new ControladorLogin(rc,login);
        
        OjoGeneral ojo = new OjoGeneral(rc,vista);
        OjoChoferRobot ojoChofer = new OjoChoferRobot(choferesRunnable.get(0),vista);
        OjoClienteRobot ojoCliente = new OjoClienteRobot(clientesRunnable.get(0),vista);
        
        login.setControlador(controladorLogin);
        vista.setControlador(controlador);
        login.setVisible(true);

        while (!Simulacion.vistaVisible){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){}
        }
        vista.setVisible(true);
        for (int i=0; i<clientesRunnable.size(); i++){
            Thread thread= new Thread(clientesRunnable.get(i));                
            thread.start();
        }
        for (int i=0; i<choferesRunnable.size(); i++){
            Thread thread=new Thread(choferesRunnable.get(i));
            thread.start();            
        }
        sistemaThread.start();
    }
}
