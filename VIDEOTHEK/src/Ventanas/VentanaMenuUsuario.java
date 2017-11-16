package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenuUsuario extends JFrame {

	private JPanel contentPane;

	
	public VentanaMenuUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(683, 652);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel norte = new JPanel();
		norte.setBackground(Color.BLACK);
		contentPane.add(norte, BorderLayout.NORTH);
		
		JLabel lblMenUsuario = new JLabel("MEN\u00DA USUARIO");
		lblMenUsuario.setForeground(Color.GREEN);
		lblMenUsuario.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		norte.add(lblMenUsuario);
		
		JPanel centro = new JPanel();
		centro.setBackground(Color.BLACK);
		contentPane.add(centro, BorderLayout.CENTER);
		centro.setLayout(null);
		
		JButton btnBuscarPelculas = new JButton("BUSCAR PEL\u00CDCULAS");
		btnBuscarPelculas.setBackground(Color.YELLOW);
		btnBuscarPelculas.setForeground(Color.BLACK);
		btnBuscarPelculas.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnBuscarPelculas.setBounds(182, 86, 256, 43);
		centro.add(btnBuscarPelculas);
		
		JButton btnPelculasFavoritas = new JButton("PEL\u00CDCULAS FAVORITAS");
		btnPelculasFavoritas.setBackground(Color.YELLOW);
		btnPelculasFavoritas.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnPelculasFavoritas.setBounds(182, 166, 289, 43);
		centro.add(btnPelculasFavoritas);
		
		JButton btnMostrarPelculas = new JButton("MOSTRAR PEL\u00CDCULAS");
		btnMostrarPelculas.setBackground(Color.YELLOW);
		btnMostrarPelculas.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnMostrarPelculas.setBounds(182, 243, 289, 43);
		centro.add(btnMostrarPelculas);
		
		JButton btnMostrarPelculasCompradas = new JButton("MOSTRAR PEL\u00CDCULAS COMPRADAS");
		btnMostrarPelculasCompradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMostrarPelculasCompradas.setBackground(Color.YELLOW);
		btnMostrarPelculasCompradas.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnMostrarPelculasCompradas.setBounds(182, 321, 417, 43);
		centro.add(btnMostrarPelculasCompradas);
		
		JButton btnComprarPelculas = new JButton("COMPRAR PEL\u00CDCULAS");
		btnComprarPelculas.setBackground(Color.YELLOW);
		btnComprarPelculas.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnComprarPelculas.setBounds(182, 396, 289, 43);
		centro.add(btnComprarPelculas);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnSalir.setBackground(Color.YELLOW);
		btnSalir.setBounds(182, 468, 165, 43);
		centro.add(btnSalir);
	}
}
