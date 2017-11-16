package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BaseDeDatos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class VentAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdmin;
	private BaseDeDatos bd;
	private JPasswordField txtPassword;

	

	/**
	 * Create the frame.
	 */
	public VentAdmin() {
		bd = new BaseDeDatos();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(683, 652);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAdmin = new JTextField();
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtAdmin.setBounds(335, 270, 188, 33);
		contentPane.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPassword.setBounds(335, 336, 188, 33);
		contentPane.add(txtPassword);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(Color.GREEN);
		lblUsuario.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 12));
		lblUsuario.setBounds(180, 273, 102, 34);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setForeground(Color.GREEN);
		lblContrasea.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
		lblContrasea.setBounds(180, 345, 150, 20);
		contentPane.add(lblContrasea);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Lucida Handwriting", Font.BOLD, 19));
		btnVolver.setBackground(Color.YELLOW);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal vp = new VentanaPrincipal();
				vp.setVisible(true);
			}
		});
		btnVolver.setBounds(256, 501, 162, 46);
		contentPane.add(btnVolver);
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.setIcon(new ImageIcon("C:\\Users\\Joseba\\git\\VIDEOTHEK\\VIDEOTHEK\\Imagenes\\Acceder.PNG"));
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usu = txtAdmin.getText();
				String contra = txtPassword.getText();
				
				if (usu.equals("")) {
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN ADMIN.", "¡ERROR!",
							JOptionPane.ERROR_MESSAGE);
					vaciarCampos();
				}

				else if (contra.equals("")) {
					JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUNA CONTRASEÑA.", "¡ERROR!",
							JOptionPane.ERROR_MESSAGE);
					vaciarCampos();
				}
				
				else
				{
					int resul = bd.adminRegistrado(usu, contra);
					
					if(resul == 0)
					{
						JOptionPane.showMessageDialog(null, "EL USUARIO ADMINISTRADOR INTRODUCIDO NO EXISTE", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
					}
					else if(resul == 1)
					{
						JOptionPane.showMessageDialog(null, "LA CONTRASEÑA INTRODUCIDA NO ES CORRECTA", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
					}
					
					else
					{
						JOptionPane.showMessageDialog(null, "BIENVENIDO AL MENÚ DE ADMINISTRADOR");
						dispose();
						VentMenuAdmin vma = new VentMenuAdmin();
						vma.setVisible(true);
						
					}
					
				}
			}
		});
		btnAcceder.setBounds(141, 404, 404, 60);
		contentPane.add(btnAcceder);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Joseba\\git\\VIDEOTHEK\\VIDEOTHEK\\Imagenes\\admin_logo.png"));
		lblNewLabel.setBounds(209, 85, 285, 124);
		contentPane.add(lblNewLabel);
	}
	
	public void vaciarCampos()
	{
		txtAdmin.setText("");
		txtPassword.setText("");
	}
}
