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

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private  BaseDeDatos bd;

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
		setBounds(100, 100, 565, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		JLabel lblVentanaPrincipal = new JLabel("VENTANA PRINCIPAL");
		panelNorte.add(lblVentanaPrincipal);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		JButton btnRegistrarseAhora = new JButton("REGISTRARSE AHORA");
		btnRegistrarseAhora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vr = new VentanaRegistro();
				vr.setVisible(true);
			}
		});
		panelSur.add(btnRegistrarseAhora);

		JButton btnAdministrador = new JButton("ADMINISTRADOR");
		panelSur.add(btnAdministrador);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR ESTE PROGRAMA.");
				dispose();
			}
		});
		panelSur.add(btnSalir);

		JPanel Centro = new JPanel();
		contentPane.add(Centro, BorderLayout.CENTER);
		Centro.setLayout(null);

		JLabel lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setBounds(63, 49, 94, 23);
		Centro.add(lblNewLabel);

		JLabel lblContrasenya = new JLabel("CONTRASE\u00D1A:");
		lblContrasenya.setBounds(63, 107, 124, 23);
		Centro.add(lblContrasenya);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(208, 46, 168, 23);
		Centro.add(txtUsuario);
		txtUsuario.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(208, 104, 168, 23);
		Centro.add(passwordField);

		JButton btnAcceder = new JButton("ACCEDER");
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
					}

				}
			}
		});
		btnAcceder.setBounds(177, 165, 131, 31);
		Centro.add(btnAcceder);
	}

	// metodo que sirve para vaciar los campos
	public void vaciarCampos() {
		txtUsuario.setText("");
		passwordField.setText("");
	}
}
