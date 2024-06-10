package prueba;

import cln.Combi;
import cln.Automovil;
import cln.Moto;
import cln.ChoferThread;
import cln.Cliente;
import cln.ClienteThread;
import cln.RecursoCompartido;
import cln.SistemaThread;
import cp.Controlador;
import cp.Vista;
import cln.Vehiculo;
import cln.Sistema;
import java.awt.EventQueue;
import cln.Chofer;
import cln.OjoChoferRobot;
import cln.OjoClienteRobot;
import cln.OjoGeneral;
import cln.OjoClienteHumano;
import cp.Login;
import cp.ControladorLogin;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;
import persistencia.PersistenciaBIN;
//import cln.OjoHumano

public class SimulacionInicial{ //clase para ejecutar la simulacion de los threads

    //public static boolean vistaVisible=false;
    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        Vehiculo vehiculo;
        vehiculo = sistema.agregarVehiculo("Automovil");
        vehiculo = sistema.agregarVehiculo("Automovil");
        vehiculo = sistema.agregarVehiculo("Moto");
        vehiculo = sistema.agregarVehiculo("Moto");
        vehiculo = sistema.agregarVehiculo("Combi");
        vehiculo = sistema.agregarVehiculo("Combi");
        
        RecursoCompartido rc = new RecursoCompartido(2, 3, sistema);
        int cantViajesChofer = 2;
        //int randomValor = random.nextInt(2)+1;

        Cliente cliente1 = new Cliente("Guille");
        sistema.agregarCliente(cliente1.getNombre());
        ClienteThread clienteRunnable1=new ClienteThread(rc,cliente1, 2);
        Thread clienteThread1=new Thread(clienteRunnable1);
        
        Cliente cliente2 = new Cliente("Ivonne");
        sistema.agregarCliente(cliente2.getNombre());
        ClienteThread clienteRunnable2 = new ClienteThread(rc,cliente2, 2);
        Thread clienteThread2 = new Thread(clienteRunnable2);

        Chofer chofer1=sistema.agregarChoferContratado("43797177","Chofer 1");
        //System.out.println(chofer1.getNombre());
        Chofer chofer2=sistema.agregarChoferContratado("44690191", "Chofer 2");
        //System.out.println(chofer2.getNombre());
        Chofer chofer3=sistema.agregarChoferContratado("44783681","Chofer 3");
        //System.out.println(chofer3.getNombre());

        ChoferThread choferRunnable1 = new ChoferThread(rc,chofer1, 1);
        Thread choferThread1 = new Thread(choferRunnable1);
        ChoferThread choferRunnable2=new ChoferThread(rc,chofer2, 1);
        Thread choferThread2 = new Thread(choferRunnable2);
        ChoferThread choferRunnable3 = new ChoferThread(rc,chofer3, 1);
        Thread choferThread3 = new Thread(choferRunnable3);

        SistemaThread sistemaThread = new SistemaThread(rc);
        
        OjoClienteHumano ojoClienteHumano;
        Vista vista = new Vista();
        Login login = new Login();
        Controlador controlador = new Controlador(vista,rc);
        ControladorLogin controladorLogin = new ControladorLogin(rc,login);
        
        OjoGeneral ojo = new OjoGeneral(rc,vista);
        OjoChoferRobot ojoChofer = new OjoChoferRobot(choferRunnable2,vista);
        OjoClienteRobot ojoCliente = new OjoClienteRobot(clienteRunnable2,vista);
        
        login.setControlador(controladorLogin);
        vista.setControlador(controlador);
        login.setVisible(true);

        //sistema.imprimeUsuarios();
        while (!Simulacion.vistaVisible){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){

            }
        }
        vista.setVisible(true);
        clienteThread1.start();
        clienteThread2.start();
        choferThread1.start();
        choferThread2.start();
        choferThread3.start();
        sistemaThread.start(); 
    }
}