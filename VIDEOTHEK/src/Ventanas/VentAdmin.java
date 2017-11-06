package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;

public class VentAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	

	/**
	 * Create the frame.
	 */
	public VentAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(202, 87, 92, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 162, 92, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 12));
		lblUsuario.setBounds(40, 90, 85, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Modern No. 20", Font.BOLD, 13));
		lblContrasea.setBounds(43, 165, 97, 14);
		contentPane.add(lblContrasea);
		
		Button button = new Button("INICIAR");
		button.setBounds(323, 124, 70, 22);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(147, 26, 131, 14);
		contentPane.add(lblNewLabel);
	}
}
