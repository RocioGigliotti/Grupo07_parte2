package cp;
import cln.RecursoCompartido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import prueba.Simulacion;
//textUsuario
//textPass
//btnLogIn
//btnRegistrarse

public class ControladorLogin implements ActionListener {
    private RecursoCompartido modelo;
    private Login vistaLogin;

    public ControladorLogin(RecursoCompartido rc, Login vistaLogin){
        this.modelo = rc;
        this.vistaLogin = vistaLogin;
        this.modelo.getSistema().agregaUsuario("hola","hola");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario;
        String contrasenia;
        if (e.getActionCommand().equals("LogIn")){
            if (vistaLogin.ingresoUsuario() && vistaLogin.ingresoContrasenia()){
                usuario = vistaLogin.getUsuario();
                contrasenia = vistaLogin.getContrasenia();   
                if (this.modelo.getSistema().getUsuarios().get(usuario).equals(contrasenia)){
                    vistaLogin.setVisible(false);
                    Simulacion.vistaVisible=true;                
                } else {
                    vistaLogin.muestraVentanaEmergente("La contrasenia ingresada es incorrecta");
                }
            } 
            else {
                this.vistaLogin.muestraVentanaEmergente("Ambos campos son obligatorios");
            }
        }
        else
            if(e.getActionCommand().equals("Registrarse")){
                if (vistaLogin.ingresoUsuario() && vistaLogin.ingresoContrasenia()){
                    usuario = vistaLogin.getUsuario();
                    contrasenia = vistaLogin.getContrasenia();
                    if (!this.modelo.getSistema().getUsuarios().containsKey(usuario)){
                        this.modelo.getSistema().agregaUsuario(usuario, contrasenia); 
                        vistaLogin.setVisible(false);
                        Simulacion.vistaVisible=true;
                    } 
                    else {
                        vistaLogin.muestraVentanaEmergente("El usuario ya existe.");
                    }
                }
                else {
                    this.vistaLogin.muestraVentanaEmergente("Ambos campos son obligatorios");       
                }
	        }
        }
}