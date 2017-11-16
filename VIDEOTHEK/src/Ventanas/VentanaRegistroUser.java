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
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class VentanaRegistroUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JPasswordField passwordContrasenya;
	private JTextField txtCorreo;
	public static BaseDeDatos bd;

	

	/**
	 * Create the frame.
	 */
	public VentanaRegistroUser() {
		bd = new BaseDeDatos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(710, 652);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.BLACK);
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblVentanaRegistro = new JLabel("VENTANA REGISTRO");
		lblVentanaRegistro.setFont(new Font("Lucida Handwriting", Font.PLAIN, 19));
		lblVentanaRegistro.setForeground(Color.GREEN);
		panelNorte.add(lblVentanaRegistro);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.BLACK);
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setForeground(Color.GREEN);
		lblNombreDeUsuario.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		lblNombreDeUsuario.setBackground(Color.BLACK);
		lblNombreDeUsuario.setBounds(71, 230, 240, 23);
		panelCentro.add(lblNombreDeUsuario);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNombreUsuario.setBounds(350, 218, 272, 42);
		panelCentro.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Color.GREEN);
		lblContrasea.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		lblContrasea.setBackground(Color.BLACK);
		lblContrasea.setBounds(71, 305, 168, 23);
		panelCentro.add(lblContrasea);
		
		passwordContrasenya = new JPasswordField();
		passwordContrasenya.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordContrasenya.setBounds(350, 293, 272, 42);
		panelCentro.add(passwordContrasenya);
		
		JLabel lblCorreo = new JLabel("Correo electr\u00F3nico:");
		lblCorreo.setForeground(Color.GREEN);
		lblCorreo.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		lblCorreo.setBackground(Color.BLACK);
		lblCorreo.setBounds(71, 380, 240, 23);
		panelCentro.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCorreo.setBounds(350, 368, 274, 42);
		panelCentro.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnNewButton = new JButton("ACEPTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombreUser = txtNombreUsuario.getText();
				String contra = passwordContrasenya.getText();
				String correo = txtCorreo.getText();
				
				
				if (nombreUser.equals("") && contra.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN NOMBRE DE USUARIO NI NINGUNA CONTRASEÑA.");
				}
				
				else if(nombreUser.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN NOMBRE DE USUARIO");
				}
				
				else if(nombreUser.equals("") && correo.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN NOMBRE DE USUARIO NI CORREO");
					
				}
				
				else if(contra.equals("") && correo.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUNA CONTRASEÑA NI CORREO");
					
				}
				
				else if(contra.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUNA CONTRASEÑA");
					
				}
				
				else if(correo.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN CORREO");
					
				}
				
				else if(nombreUser.equals("") && correo.equals("") && contra.equals(""))
				{
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN NOMBRE DE USUARIO NI CORREO NI CONTRASEÑA");
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "NUEVO USUARIO REGISTRADO EN LA PLATAFORMA VIDEOTHEK");
					bd.registrarUsuario(nombreUser, contra, correo);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(108, 459, 182, 42);
		panelCentro.add(btnNewButton);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnVolver.setBackground(Color.YELLOW);
		btnVolver.setBounds(456, 459, 166, 42);
		panelCentro.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Joseba\\git\\VIDEOTHEK\\VIDEOTHEK\\Imagenes\\videothek_original.png"));
		lblNewLabel.setBounds(171, 46, 373, 127);
		panelCentro.add(lblNewLabel);
	}
}
