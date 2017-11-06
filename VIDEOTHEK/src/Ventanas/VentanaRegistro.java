package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BaseDeDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JPasswordField passwordContrasenya;
	private JTextField txtCorreo;
	public static BaseDeDatos bd;

	

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		bd = new BaseDeDatos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblVentanaRegistro = new JLabel("VENTANA REGISTRO");
		panelNorte.add(lblVentanaRegistro);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nom = txtNombreUsuario.getText();
				String con = passwordContrasenya.getText();
				String cor = txtCorreo.getText();
				
				if(nom.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN NOMBRE DE USUARIO.", "�ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(con.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUNA CONTRASE�A", "�ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (cor.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN CORREO", "�ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					bd.registrarUsuario(nom, con, cor);
					JOptionPane.showMessageDialog(null, "TE ACABAS DE REGISTRAR EN VIDEOTHEK");
					dispose();
				}
			}
		});
		panelSur.add(btnAceptar);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelSur.add(btnVolver);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setBounds(17, 54, 168, 23);
		panelCentro.add(lblNombreDeUsuario);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(237, 51, 166, 29);
		panelCentro.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(17, 111, 168, 23);
		panelCentro.add(lblContrasea);
		
		passwordContrasenya = new JPasswordField();
		passwordContrasenya.setBounds(237, 108, 168, 29);
		panelCentro.add(passwordContrasenya);
		
		JLabel lblCorreo = new JLabel("Correo electr\u00F3nico:");
		lblCorreo.setBounds(17, 171, 168, 23);
		panelCentro.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(237, 168, 166, 29);
		panelCentro.add(txtCorreo);
		txtCorreo.setColumns(10);
	}
}
