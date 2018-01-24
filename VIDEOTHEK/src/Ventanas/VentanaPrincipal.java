package Ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;

import BD.BaseDeDatos;
import Datos.Cliente;
import Paneles.PanelAdministrador;
import Paneles.PanelIniciarSesion;
import Paneles.PanelRegistro;
import Paneles.PanelUsuario;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JScrollPane contenedorDePaneles;
	private int anchura;
	private int altura;
	private PanelIniciarSesion panelIniciarSesion = new PanelIniciarSesion(this);
	private PanelUsuario panelUsuario;
	private PanelAdministrador panelAdministrador;
	private PanelRegistro panelRegistro = new PanelRegistro();
	private BaseDeDatos bd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel((LookAndFeel) new SubstanceRavenLookAndFeel());
					VentanaPrincipal frame = new VentanaPrincipal(500,300);
					frame.setVisible(true);
					frame.cargarPanelIniciarSesion();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(int anchura, int altura) {
		
		//Antes de llamar a los m�todos debemos asignar la anchura y altura al JFrame:
		this.anchura = anchura;
		this.altura = altura;
		bd = new BaseDeDatos();
		
		inicializar();
		componentes();
		a�adirComponentes();
		eventos();				
	}
	
	private void inicializar()
	{
		contentPane = new JPanel();
		contenedorDePaneles = new JScrollPane();
	}
	
	private void componentes()
	{
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(Color.ORANGE, 2));
		
		//El contenedor se ajustar� autom�ticamente a la anchura y altura pasadas por par�metro:
		contenedorDePaneles.setBounds(0, 0, anchura - 6, altura - 35);
	}
	
	private void a�adirComponentes()
	{
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(anchura, altura);
		setLocationRelativeTo(null);
		setContentPane(contentPane);	
		
		contentPane.setLayout(null);
		contentPane.add(contenedorDePaneles);

	}
	
	private void eventos()
	{
		//Accedemos al evento del bot�n de volver del panel registro desde el JFrame VentanaPrincipal:
		panelRegistro.btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPanelIniciarSesion();
			}
		});
		//Accedemos al evento del bot�n de registrarse del panel iniciar sesi�n desde el JFrame VentanaPrincipal:
		panelIniciarSesion.BotonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPanelRegistro();
			}
		});
	}
	
	//M�todo para cargar el panel de iniciar sesi�n en el scrollPane del JFrame VentanaPrincipal:
	public void cargarPanelIniciarSesion()
	{
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelIniciarSesion);
	}
	
	//M�todo para cargar el panel del usuario:
	public void cargarPanelUsuario(Cliente cliente)
	{
		//Inicializamos el panel:
		panelUsuario = new PanelUsuario(cliente);
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelUsuario);
	}
	
	//M�todo para cargar el panel del administrador:
	public void cargarPanelAdministrador()
	{
		//Inicializamos el panel:
		panelAdministrador = new PanelAdministrador();
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelAdministrador);
	}
	
	//M�todo para cargar el panel registro:
	public void cargarPanelRegistro()
	{
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelRegistro);
	}
}
