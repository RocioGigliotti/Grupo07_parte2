package cp;

import cln.RecursoCompartido;
import cp.Controlador;
import cln.Sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel espacio_arriba;
	private JPanel panel_general;
	private JPanel pedidos_log;
	private JTabbedPane vistas_robots;
	private JPanel General;
	private JPanel ChoferRobot;
	private JPanel cliente_robot;
	private JLabel lblNewLabel;
	private JPanel hacer_pedido;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox selectorZona;
	private JLabel lblNewLabel_4;
	private JRadioButton RB_MascotaSi;
	private JLabel L_UsaBaul;
	private JRadioButton RB_BaulSi;
	private JLabel lblNewLabel_6;
	private JTextField textCantPasajeros;
	private JButton btnLogOut;
	private JButton btnRealizarPedido;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_8;
	private JRadioButton RB_MascotaNo;
	private JPanel panel_9;
	private JPanel panel_10;
	private JRadioButton RB_BaulNo;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblNewLabel_5;
	private JPanel panel_13;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_7;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextArea logUser;
	private JTextArea logGeneral;
	private JTextArea logChofer;
	private JTextArea logCliente;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JButton btnPagar;
	private JPanel panel_7;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					RecursoCompartido modelo = new RecursoCompartido(10,10,Sistema.getInstance());
					Controlador controlador=new Controlador(frame,modelo);
					frame.setControlador(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.espacio_arriba = new JPanel();
		this.contentPane.add(this.espacio_arriba, BorderLayout.NORTH);
		
		this.lblNewLabel = new JLabel("Servicio de radiotaxi");
		this.espacio_arriba.add(this.lblNewLabel);
		
		this.panel_general = new JPanel();
		this.contentPane.add(this.panel_general, BorderLayout.CENTER);
		this.panel_general.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panel_13 = new JPanel();
		this.panel_13.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Realizar un pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panel_general.add(this.panel_13);
		this.panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.hacer_pedido = new JPanel();
		this.panel_13.add(this.hacer_pedido);
		this.hacer_pedido.setBackground(new Color(240, 240, 240));
		this.hacer_pedido.setLayout(new GridLayout(9, 2, 0, 0));
		
		this.lblNewLabel_1 = new JLabel("");
		this.hacer_pedido.add(this.lblNewLabel_1);
		
		this.lblNewLabel_7 = new JLabel("");
		this.hacer_pedido.add(this.lblNewLabel_7);
		
		this.panel_6 = new JPanel();
		this.hacer_pedido.add(this.panel_6);
		
		this.lblNewLabel_2 = new JLabel("Fecha:");
		this.panel_6.add(this.lblNewLabel_2);
		
		this.panel_11 = new JPanel();
		this.hacer_pedido.add(this.panel_11);
		
		this.lblNewLabel_5 = new JLabel("07/06/2024");
		this.panel_11.add(this.lblNewLabel_5);
		
		this.panel_5 = new JPanel();
		this.hacer_pedido.add(this.panel_5);
		
		this.lblNewLabel_3 = new JLabel("Zona:");
		this.panel_5.add(this.lblNewLabel_3);
		
		this.panel_9 = new JPanel();
		this.hacer_pedido.add(this.panel_9);
		
		this.selectorZona = new JComboBox();
		this.panel_9.add(this.selectorZona);
		this.selectorZona.setModel(new DefaultComboBoxModel(new String[] {"ZonaEstandar", "ZonaSinAsfaltar", "ZonaPeligrosa"}));
		this.selectorZona.setMaximumRowCount(3);
		
		this.panel_4 = new JPanel();
		this.hacer_pedido.add(this.panel_4);
		
		this.lblNewLabel_4 = new JLabel("Mascota:");
		this.panel_4.add(this.lblNewLabel_4);
		
		this.panel_8 = new JPanel();
		this.hacer_pedido.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.RB_MascotaSi = new JRadioButton("Si");
		this.RB_MascotaSi.setSelected(true);
		buttonGroup_1.add(this.RB_MascotaSi);
		this.panel_8.add(this.RB_MascotaSi);
		
		this.RB_MascotaNo = new JRadioButton("No");
		buttonGroup_1.add(this.RB_MascotaNo);
		this.panel_8.add(this.RB_MascotaNo);
		
		this.panel_3 = new JPanel();
		this.hacer_pedido.add(this.panel_3);
		
		this.L_UsaBaul = new JLabel("Usa baul?:");
		this.panel_3.add(this.L_UsaBaul);
		
		this.panel_10 = new JPanel();
		this.hacer_pedido.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(1, 1, 0, 0));
		
		this.RB_BaulSi = new JRadioButton("Si");
		this.RB_BaulSi.setSelected(true);
		buttonGroup.add(this.RB_BaulSi);
		this.panel_10.add(this.RB_BaulSi);
		
		this.RB_BaulNo = new JRadioButton("No");
		buttonGroup.add(this.RB_BaulNo);
		this.panel_10.add(this.RB_BaulNo);
		
		this.panel_2 = new JPanel();
		this.hacer_pedido.add(this.panel_2);
		
		this.lblNewLabel_6 = new JLabel("Cantidad de pasajeros:");
		this.panel_2.add(this.lblNewLabel_6);
		
		this.panel_12 = new JPanel();
		this.hacer_pedido.add(this.panel_12);
		
		this.textCantPasajeros = new JTextField();
		this.panel_12.add(this.textCantPasajeros);
		this.textCantPasajeros.setColumns(10);
		
		this.panel = new JPanel();
		this.hacer_pedido.add(this.panel);
		
		this.btnPagar = new JButton("Pagar");
		this.panel.add(this.btnPagar);
		this.btnPagar.setEnabled(false);
		
		this.panel_1 = new JPanel();
		this.hacer_pedido.add(this.panel_1);
		
		this.btnRealizarPedido = new JButton("Pedir");
		this.panel_1.add(this.btnRealizarPedido);
		
		this.lblNewLabel_8 = new JLabel("");
		this.hacer_pedido.add(this.lblNewLabel_8);
		
		this.lblNewLabel_9 = new JLabel("");
		this.hacer_pedido.add(this.lblNewLabel_9);
		
		this.panel_7 = new JPanel();
		this.hacer_pedido.add(this.panel_7);
		
		this.btnLogOut = new JButton("Log Out");
		this.btnLogOut.setActionCommand("LogOut");
		this.panel_7.add(this.btnLogOut);
		
		this.pedidos_log = new JPanel();
		this.pedidos_log.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Estado de mis pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panel_general.add(this.pedidos_log);
		this.pedidos_log.setLayout(new BorderLayout(0, 0));
		
		this.logUser = new JTextArea();
		this.pedidos_log.add(this.logUser, BorderLayout.CENTER);
		
		this.vistas_robots = new JTabbedPane(JTabbedPane.TOP);
		this.vistas_robots.setToolTipText("General");
		this.panel_general.add(this.vistas_robots);
		
		this.General = new JPanel();
		this.General.setToolTipText("");
		this.vistas_robots.addTab("General", null, this.General, null);
		this.General.setLayout(new BorderLayout(0, 0));
		
		this.logGeneral = new JTextArea();
		this.General.add(this.logGeneral, BorderLayout.CENTER);
		
		this.ChoferRobot = new JPanel();
		this.vistas_robots.addTab("Chofer", null, this.ChoferRobot, null);
		this.ChoferRobot.setLayout(new BorderLayout(0, 0));
		
		this.logChofer = new JTextArea();
		this.ChoferRobot.add(this.logChofer);
		
		this.cliente_robot = new JPanel();
		this.vistas_robots.addTab("Cliente", null, this.cliente_robot, null);
		this.cliente_robot.setLayout(new BorderLayout(0, 0));
		
		this.logCliente = new JTextArea();
		this.cliente_robot.add(this.logCliente);
	}

	public void escribeLogUser(String s){
		this.logUser.append(s);
	}

	public void escribeLogChofer(String s){
		this.logChofer.append(s);
	}

	public void escribeLogCliente(String s){
		this.logCliente.append(s);
	}

	public void escribeLogGeneral(String s){
		this.logGeneral.append(s);
	}
	
	public void muestraVentanaEmergente(String s){
		JOptionPane.showMessageDialog(this, s);
	}
	
	public boolean tieneMascota(){
		if (RB_MascotaSi.isSelected())
			return true;
		else
			return false;
	}

	public boolean tieneBaul(){
		if (RB_BaulSi.isSelected())
			return true;
		else
			return false;
	}

	public String getZonaSeleccionada(){
		return this.selectorZona.getSelectedItem().toString();
	}

	public int getCantPasajeros(){
		try{
			int pasajeros = Integer.parseInt(textCantPasajeros.getText());		
			return pasajeros;
		} catch (NumberFormatException ex) { 
			JOptionPane.showMessageDialog(this, "Se debe ingresar un valor numerico");
			return 0;
		}		
	}

	public void setControlador(Controlador c){
		this.btnPagar.addActionListener(c);
		this.btnLogOut.addActionListener(c);
		this.btnRealizarPedido.addActionListener(c);
	}
	public JButton getBtnPagar(){
		return this.btnPagar;
	}
	public JButton getBtnRealizarPedido(){
		return this.btnRealizarPedido;
	}
	public void enableBotonPagar(boolean condicion){
		this.btnPagar.setEnabled(condicion);
	}
	
	public void enableBotonPedir(boolean condicion){
		this.btnRealizarPedido.setEnabled(condicion);
	}
}