package cp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblNewLabel_4;
	private JPanel panel_9;
	private JLabel lblNewLabel_5;
	private JPanel panel_10;
	private JLabel lblNewLabel_6;
	private JTextField textUser;
	private JPanel panel_11;
	private JLabel lblNewLabel_3;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_12;
	private JButton btnLogIn;
	private JPanel panel_16;
	private JButton btnRegistrarse;
	private JPanel panel_17;
	private JPasswordField textPass;
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 350);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 1));
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.NORTH);
		
		this.lblNewLabel = new JLabel("Servicio de radiotaxi");
		this.panel.add(this.lblNewLabel);
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1, BorderLayout.CENTER);
		this.panel_1.setLayout(new GridLayout(0, 3, 1, 0));
		
		this.lblNewLabel_1 = new JLabel("");
		this.panel_1.add(this.lblNewLabel_1);
		
		this.panel_2 = new JPanel();
		this.panel_1.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(4, 1, 0, 0));
		
		this.panel_3 = new JPanel();
		this.panel_2.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_7 = new JPanel();
		this.panel_3.add(this.panel_7);
		
		this.panel_11 = new JPanel();
		this.panel_3.add(this.panel_11);
		
		this.lblNewLabel_3 = new JLabel("Login / Registrarse");
		this.panel_11.add(this.lblNewLabel_3);
		
		this.panel_4 = new JPanel();
		this.panel_2.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_8 = new JPanel();
		this.panel_4.add(this.panel_8);
		
		this.lblNewLabel_4 = new JLabel("");
		this.panel_8.add(this.lblNewLabel_4);
		
		this.panel_10 = new JPanel();
		this.panel_4.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_14 = new JPanel();
		this.panel_10.add(this.panel_14);
		
		this.lblNewLabel_6 = new JLabel("Usuario:      ");
		this.panel_14.add(this.lblNewLabel_6);
		
		this.panel_13 = new JPanel();
		this.panel_10.add(this.panel_13);
		
		this.textUser = new JTextField();
		this.panel_13.add(this.textUser);
		this.textUser.setColumns(10);
		
		this.panel_5 = new JPanel();
		this.panel_2.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_9 = new JPanel();
		this.panel_5.add(this.panel_9);
		this.panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_15 = new JPanel();
		this.panel_9.add(this.panel_15);
		
		this.lblNewLabel_5 = new JLabel("Contraseña:");
		this.panel_15.add(this.lblNewLabel_5);
		
		this.panel_17 = new JPanel();
		this.panel_9.add(this.panel_17);
		
		this.textPass = new JPasswordField();
		this.textPass.setColumns(10);
		this.panel_17.add(this.textPass);
		
		this.panel_12 = new JPanel();
		this.panel_5.add(this.panel_12);
		
		this.btnLogIn = new JButton("Log In");
		//this.btnLogIn.addActionListener(this);
		//this.btnLogIn.addActionListener(this);
		this.btnLogIn.setActionCommand("LogIn");
		this.panel_12.add(this.btnLogIn);
		
		this.panel_6 = new JPanel();
		this.panel_2.add(this.panel_6);
		this.panel_6.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_16 = new JPanel();
		this.panel_6.add(this.panel_16);
		
		this.btnRegistrarse = new JButton("Registrarse");

		this.panel_16.add(this.btnRegistrarse);
		
		this.lblNewLabel_2 = new JLabel("");
		this.panel_1.add(this.lblNewLabel_2);
	}
	public void setControlador(ControladorLogin c){
		this.btnLogIn.addActionListener(c);
		this.btnRegistrarse.addActionListener(c);
	}

	public void muestraVentanaEmergente(String s){
		JOptionPane.showMessageDialog(this, s);
	}

	public boolean ingresoUsuario(){
		String user = textUser.getText().trim();     
        if(user.isEmpty())
			return false;
		else
			return true;
	}
	
	public boolean ingresoContrasenia(){
        String pw = new String(textPass.getPassword());
		pw.trim();
		if (pw.isEmpty())
			return false;
		else
		    return true;
	}

	public String getUsuario(){
		return textUser.getText();
	}

	public String getContrasenia(){
		String pwd = new String(textPass.getPassword());
		return pwd;
	}
}
