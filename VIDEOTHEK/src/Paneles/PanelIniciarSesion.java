package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import BD.BaseDeDatos;
import Datos.Cliente;
import Ventanas.VentanaPrincipal;

public class PanelIniciarSesion extends JPanel {

	int anchuraPanel = 500;
	int alturaPanel = 300;
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton BotonAcceder;
	public JButton BotonRegistrarse;
	private JButton BotonContraseñaOlvidada;

	private BaseDeDatos bd = new BaseDeDatos();

	/**
	 * Create the panel.
	 */
	public PanelIniciarSesion(JFrame frame) {

		inicializar();
		componentes();
		añadirComponentes();
		eventos(frame);
	}

	private void inicializar() {
		textField = new JTextField();
		passwordField = new JPasswordField();
		BotonAcceder = new JButton("ACCEDER");
		BotonRegistrarse = new JButton("REGISTRARSE ");
		BotonContraseñaOlvidada = new JButton("CONTRASE\u00D1A OLVIDADA");
	}

	private void componentes() {

		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(71, 29, 361, 60);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(71, 102, 361, 60);
		BotonAcceder.setForeground(SystemColor.textHighlight);
		BotonAcceder.setFont(new Font("Tahoma", Font.BOLD, 20));
		BotonAcceder.setBackground(Color.DARK_GRAY);
		BotonAcceder.setBounds(150, 175, 193, 35);
		BotonRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		BotonRegistrarse.setBackground(Color.DARK_GRAY);
		BotonRegistrarse.setBounds(50, 223, 193, 35);
		BotonContraseñaOlvidada.setFont(new Font("Tahoma", Font.BOLD, 12));
		BotonContraseñaOlvidada.setBackground(Color.DARK_GRAY);
		BotonContraseñaOlvidada.setBounds(255, 223, 196, 35);	
		textField.setBackground(Color.DARK_GRAY);
		textField.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduzca usuario", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.textHighlight));
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduzca contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.textHighlight));
		BotonAcceder.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		BotonRegistrarse.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		BotonContraseñaOlvidada.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		textField.setForeground(SystemColor.textHighlight);
		passwordField.setForeground(SystemColor.textHighlight);

	}

	private void añadirComponentes() {
		setSize(anchuraPanel, alturaPanel);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBorder(null);
		add(textField);
		add(passwordField);
		add(BotonAcceder);
		add(BotonRegistrarse);
		add(BotonContraseñaOlvidada);
	}

	private void eventos(JFrame frame) {
	
	}

}
