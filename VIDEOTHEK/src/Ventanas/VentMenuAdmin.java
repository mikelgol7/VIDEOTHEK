package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentMenuAdmin extends JFrame {

	private JPanel contentPane;


	public VentMenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(683, 690);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel norte = new JPanel();
		norte.setBackground(Color.BLACK);
		contentPane.add(norte, BorderLayout.NORTH);
		
		JLabel lblMenAdministrador = new JLabel("MEN\u00DA ADMINISTRADOR");
		lblMenAdministrador.setForeground(Color.GREEN);
		lblMenAdministrador.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		norte.add(lblMenAdministrador);
		
		JPanel centro = new JPanel();
		centro.setBackground(Color.BLACK);
		contentPane.add(centro, BorderLayout.CENTER);
		centro.setLayout(null);
		
		JButton btnAadirPelcula = new JButton("A\u00D1ADIR PEL\u00CDCULA");
		btnAadirPelcula.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnAadirPelcula.setBackground(Color.YELLOW);
		btnAadirPelcula.setBounds(189, 77, 279, 44);
		centro.add(btnAadirPelcula);
		
		JButton btnEliminarPelcula = new JButton("ELIMINAR PEL\u00CDCULA");
		btnEliminarPelcula.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnEliminarPelcula.setBackground(Color.YELLOW);
		btnEliminarPelcula.setBounds(189, 150, 279, 44);
		centro.add(btnEliminarPelcula);
		
		JButton btnEliminarUsuario = new JButton("ELIMINAR USUARIO");
		btnEliminarUsuario.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnEliminarUsuario.setBackground(Color.YELLOW);
		btnEliminarUsuario.setBounds(189, 227, 279, 44);
		centro.add(btnEliminarUsuario);
		
		JButton btnMostrarUsuarios = new JButton("MOSTRAR USUARIOS");
		btnMostrarUsuarios.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnMostrarUsuarios.setBackground(Color.YELLOW);
		btnMostrarUsuarios.setBounds(189, 300, 279, 44);
		centro.add(btnMostrarUsuarios);
		
		JButton btnEditarPelcula = new JButton("EDITAR PEL\u00CDCULA");
		btnEditarPelcula.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnEditarPelcula.setBackground(Color.YELLOW);
		btnEditarPelcula.setBounds(189, 371, 279, 44);
		centro.add(btnEditarPelcula);
		
		JButton btnVisualizarVentasY = new JButton("VISUALIZAR VENTAS Y ALQUILERES");
		btnVisualizarVentasY.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnVisualizarVentasY.setBackground(Color.YELLOW);
		btnVisualizarVentasY.setBounds(189, 446, 443, 44);
		centro.add(btnVisualizarVentasY);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnSalir.setBackground(Color.YELLOW);
		btnSalir.setBounds(189, 516, 173, 44);
		centro.add(btnSalir);
	}

}
