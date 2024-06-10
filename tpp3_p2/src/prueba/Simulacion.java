package prueba;
/*
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
//import cln.OjoHumano
*/
public class Simulacion { //clase para ejecutar la simulacion de los threads

    public static boolean vistaVisible=false;
   /* public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        Vehiculo vehiculo;
        sistema.agregarChoferContratado("43797177","Reginald Reshiram");
        sistema.agregarChoferContratado("44690191", "Tomson");
        vehiculo = sistema.agregarVehiculo("Automovil");
        vehiculo = sistema.agregarVehiculo("Automovil");
        vehiculo = sistema.agregarVehiculo("Moto");
        vehiculo = sistema.agregarVehiculo("Moto");
        vehiculo = sistema.agregarVehiculo("Combi");
        vehiculo = sistema.agregarVehiculo("Combi");
        RecursoCompartido rc = new RecursoCompartido(2, 3, sistema);
        
        Cliente cliente = new Cliente("Juan");
        ClienteThread clienteRunnable=new ClienteThread(rc,cliente);
        Thread clienteThread=new Thread(clienteRunnable);
        
        Cliente cliente2 = new Cliente("Lanzillotta");
        ClienteThread clienteRunnable2 = new ClienteThread(rc,cliente2);
        Thread clienteThread2 = new Thread(clienteRunnable2);

        Chofer chofer1=sistema.agregarChoferContratado("43797177","Reginald Reshiram");
        Chofer chofer2=sistema.agregarChoferContratado("44690191", "Tomson");
        Chofer chofer3=sistema.agregarChoferContratado("44783681","Roxypop-2");

        ChoferThread choferRunnable1=new ChoferThread(rc,chofer1);
        Thread choferThread1=new Thread(choferRunnable1);
        ChoferThread choferRunnable2=new ChoferThread(rc,chofer2);
        Thread choferThread2=new Thread(choferRunnable2);
        ChoferThread choferRunnable3 = new ChoferThread(rc, chofer3);
        Thread choferThread3 = new Thread(choferRunnable3);

        SistemaThread sistemaThread = new SistemaThread(rc);
        
        OjoClienteHumano ojoClienteHumano;
        Vista vista = new Vista();
        Login login=new Login();
        Controlador controlador = new Controlador(vista,rc);
        ControladorLogin controladorLogin=new ControladorLogin(rc,login);
        
        OjoGeneral ojo = new OjoGeneral(rc,vista);
        OjoChoferRobot ojoChofer=new OjoChoferRobot(choferRunnable2,vista);
        OjoClienteRobot ojoCliente=new OjoClienteRobot(clienteRunnable2,vista);
        
        login.setControlador(controladorLogin);
        vista.setControlador(controlador);
        login.setVisible(true);

        sistema.imprimeUsuarios();

        while (!Simulacion.vistaVisible){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){}
            }
            vista.setVisible(true);
            clienteThread.start();
            clienteThread2.start();
            choferThread1.start();
            choferThread2.start();
            choferThread3.start();
            sistemaThread.start(); 
    }*/
}
