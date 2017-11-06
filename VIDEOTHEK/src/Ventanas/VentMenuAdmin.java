package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import java.awt.Label;
import java.awt.Button;

public class VentMenuAdmin extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public VentMenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenDelAdministrador = new JLabel("Men\u00FA del administrador");
		lblMenDelAdministrador.setFont(new Font("Calibri Light", Font.BOLD, 15));
		lblMenDelAdministrador.setBounds(126, 35, 184, 14);
		contentPane.add(lblMenDelAdministrador);
		
		Button button = new Button("A\u00F1adir pel\u00EDcula");
		button.setBounds(40, 84, 85, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Eliminar pel\u00EDcula");
		button_1.setBounds(40, 139, 85, 22);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Editar pel\u00EDcula");
		button_2.setBounds(40, 205, 85, 22);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Eliminar Usuario");
		button_3.setBounds(264, 84, 97, 22);
		contentPane.add(button_3);
		
		Button button_4 = new Button("Mostrar usuario");
		button_4.setBounds(264, 139, 97, 22);
		contentPane.add(button_4);
		
		Button button_5 = new Button("Visualizar Ventas y Alquileres");
		button_5.setBounds(226, 205, 170, 31);
		contentPane.add(button_5);
	}
}
