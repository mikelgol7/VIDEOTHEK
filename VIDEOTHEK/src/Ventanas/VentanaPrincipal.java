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
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {
 
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private BaseDeDatos bd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		bd = new BaseDeDatos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(710, 715);
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

		JLabel lblVentanaPrincipal = new JLabel("VENTANA PRINCIPAL");
		lblVentanaPrincipal.setFont(new Font("Lucida Handwriting", Font.PLAIN, 19));
		lblVentanaPrincipal.setForeground(Color.GREEN);
		panelNorte.add(lblVentanaPrincipal);

		JPanel Centro = new JPanel();
		Centro.setBackground(Color.BLACK);
		contentPane.add(Centro, BorderLayout.CENTER);
		Centro.setLayout(null);

		JLabel lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 19));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(179, 213, 124, 39);
		Centro.add(lblNewLabel);

		JLabel lblContrasenya = new JLabel("CONTRASE\u00D1A:");
		lblContrasenya.setFont(new Font("Lucida Handwriting", Font.PLAIN, 19));
		lblContrasenya.setForeground(Color.GREEN);
		lblContrasenya.setBounds(179, 287, 158, 39);
		Centro.add(lblContrasenya);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsuario.setBounds(406, 213, 168, 38);
		Centro.add(txtUsuario);
		txtUsuario.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(406, 287, 168, 38);
		Centro.add(passwordField);

		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.setIcon(new ImageIcon("C:\\Users\\Joseba\\git\\VIDEOTHEK\\VIDEOTHEK\\Imagenes\\Acceder.PNG"));
		btnAcceder.setFont(new Font("Lucida Handwriting", Font.PLAIN, 19));
		btnAcceder.setForeground(Color.BLACK);
		btnAcceder.setBackground(Color.WHITE);
		btnAcceder.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String contrasenya = passwordField.getText();

				if (usuario.equals("")) {
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN USUARIO.", "¡ERROR!",
							JOptionPane.ERROR_MESSAGE);
					vaciarCampos();
				}

				else if (contrasenya.equals("")) {
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUNA CONTRASEÑA.", "¡ERROR!",
							JOptionPane.ERROR_MESSAGE);
					vaciarCampos();
				}

				else {
					int resul = bd.UsuarioRegistrado(usuario, contrasenya);

					if (resul == 0) {
						JOptionPane.showMessageDialog(null,
								"EL USUARIO INTRODUCIDO NO ESTA REGISTRADO, DEBE DE ESTAR PREVIAMENTE REGISTRADO PARA ACCEDER A VIDEOTHEK");
						vaciarCampos();
					}

					else if (resul == 1) {
						JOptionPane.showMessageDialog(null, "LA CONTRASEÑA INTRODUCIDA NO ES CORRECTA", "¡ERROR!",
								JOptionPane.ERROR_MESSAGE);
						vaciarCampos();
					}

					else {
						JOptionPane.showMessageDialog(null, "¡BIENVENIDO A VIDEOTHEK!");
						dispose();
						VentanaMenuUsuario vu = new VentanaMenuUsuario();
						vu.setVisible(true);
					}

				}
			}
		});
		btnAcceder.setBounds(139, 363, 403, 60);
		Centro.add(btnAcceder);
		
		JButton btnRegistrarseAhora = new JButton("REGISTRARSE ");
		btnRegistrarseAhora.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnRegistrarseAhora.setBackground(Color.YELLOW);
		btnRegistrarseAhora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistroUser vr = new VentanaRegistroUser();
				vr.setVisible(true);
			}
		});
		btnRegistrarseAhora.setBounds(55, 460, 248, 50);
		Centro.add(btnRegistrarseAhora);
		
		JButton btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.setForeground(Color.BLACK);
		btnAdministrador.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnAdministrador.setBackground(Color.YELLOW);
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentAdmin va = new VentAdmin();
				va.setVisible(true);
				dispose();
			}
		});
		btnAdministrador.setBounds(406, 460, 248, 50);
		Centro.add(btnAdministrador);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnSalir.setBackground(Color.YELLOW);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR EL PROGRAMA");
				dispose();
			}
		});
		btnSalir.setBounds(406, 553, 124, 50);
		Centro.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Joseba\\git\\VIDEOTHEK\\VIDEOTHEK\\Imagenes\\videothek_original.png"));
		lblNewLabel_1.setBounds(164, 34, 378, 147);
		Centro.add(lblNewLabel_1);
		
		JButton btnContraseaOlvidada = new JButton("CONTRASE\u00D1A OLVIDADA");
		btnContraseaOlvidada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resul;
				
				String correo = JOptionPane.showInputDialog(null, "INTRODUCE TU CORREO ELECTRÓNICO");
				resul = bd.devuelveContrasenya(correo);
				//System.out.println("La contrasenya es: "+resul);
				JOptionPane.showMessageDialog(null, resul);
				
			}
		});
		btnContraseaOlvidada.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnContraseaOlvidada.setBackground(Color.YELLOW);
		btnContraseaOlvidada.setBounds(55, 553, 334, 50);
		Centro.add(btnContraseaOlvidada);
	}

	// metodo que sirve para vaciar los campos
	public void vaciarCampos() {
		txtUsuario.setText("");
		passwordField.setText("");
	}
}
