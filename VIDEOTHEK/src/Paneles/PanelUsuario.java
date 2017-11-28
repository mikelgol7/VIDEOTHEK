package Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import BD.BaseDeDatos;
import Datos.Alquiler;
import Datos.Categoria;
import Datos.Cliente;
import Datos.Inventario;
import Datos.Pelicula;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class PanelUsuario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int anchuraPanel = 1080;
	private int alturaPanel = 720;
	private JPanel panel;
	private JScrollPane scrollPane;
	private GridLayout gl_panel;

	private JToggleButton[] arrayBotones;

	private JLabel NombreUsuario;
	private JTextField textFieldBuscarPelicula;
	private JLabel lblImagenPelicula;
	private JLabel labelTitulo;
	private JLabel labelDuracion;
	private JLabel labelA�o;
	private JLabel labelCategoria;
	private JTextPane textPaneDescripcion;
	private JLabel labelDisponibles;
	private JLabel labelPrecio;
	private JButton btnalquilarYaMismo;
	private JLabel lblNewLabel;
	private JLabel labelDinero;
	private JComboBox<Integer> comboBoxA�o;
	private JComboBox<String> comboBoxGenero;

	private Cliente cliente;

	/**
	 * Create the panel.
	 */
	public PanelUsuario(Cliente cliente) {
		this.cliente = cliente;
		inicializar();
		componentes();
		a�adirComponentes();
		eventos();
		
		valoresComboBoxCategorias();
		valoresComboBoxA�os();
	}

	private void inicializar() {
		// Numero de filas, Numero de columnas, Separaciones h y v:
		gl_panel = new GridLayout(2, 2, 5, 5);
		scrollPane = new JScrollPane();
		panel = new JPanel();
		NombreUsuario = new JLabel(
				" " + cliente.getNombre() + " - " + cliente.getApellidos() + "   [" + cliente.getPais() + "]");
		textFieldBuscarPelicula = new JTextField();
		comboBoxGenero = new JComboBox<String>();
		lblImagenPelicula = new JLabel();
		labelTitulo = new JLabel();
		labelDuracion = new JLabel();
		labelA�o = new JLabel();
		labelCategoria = new JLabel();
		labelDisponibles = new JLabel();
		labelPrecio = new JLabel();
		btnalquilarYaMismo = new JButton("\u00A1ALQUILAR YA MISMO!");
		lblNewLabel = new JLabel("SALDO ");
		labelDinero = new JLabel("0 \u20AC");
		comboBoxA�o = new JComboBox<Integer>();
		scrollPane_1 = new JScrollPane();
		textPaneDescripcion = new JTextPane();
	}

	private void componentes() {
		btnalquilarYaMismo.setBorder(new LineBorder(Color.GREEN));
		scrollPane.setBounds(12, 64, 1056, 350);
		NombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		NombreUsuario.setForeground(Color.ORANGE);
		NombreUsuario.setBorder(new TitledBorder(null, "Bienvenido de nuevo:", TitledBorder.LEADING, TitledBorder.TOP,
				null, SystemColor.textHighlight));
		NombreUsuario.setBounds(12, 0, 241, 65);
		textFieldBuscarPelicula.setBackground(Color.DARK_GRAY);
		textFieldBuscarPelicula.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar pel\u00EDcula por nombre",
						TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		textFieldBuscarPelicula.setBounds(783, 0, 285, 65);
		textFieldBuscarPelicula.setColumns(10);
		comboBoxGenero.setBackground(Color.BLACK);
		comboBoxGenero.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar pel\u00EDcula por g\u00E9nero",
						TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		comboBoxGenero.setBounds(524, 6, 247, 55);
		lblImagenPelicula.setBorder(new LineBorder(SystemColor.textHighlight));
		lblImagenPelicula.setBounds(12, 427, 100, 140);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setBorder(new LineBorder(SystemColor.textHighlight));
		labelTitulo.setBounds(124, 427, 195, 29);
		labelDuracion.setForeground(Color.WHITE);
		labelDuracion.setBorder(new LineBorder(SystemColor.textHighlight));
		labelDuracion.setBounds(124, 469, 195, 29);
		labelA�o.setForeground(Color.WHITE);
		labelA�o.setBorder(new LineBorder(SystemColor.textHighlight));
		labelA�o.setBounds(331, 427, 195, 29);
		labelCategoria.setForeground(Color.WHITE);
		labelCategoria.setBorder(new LineBorder(SystemColor.textHighlight));
		labelCategoria.setBounds(331, 469, 195, 29);
		textPaneDescripcion.setForeground(Color.WHITE);
		textPaneDescripcion.setBorder(new LineBorder(SystemColor.textHighlight));
		textPaneDescripcion.setBackground(Color.DARK_GRAY);
		labelDisponibles.setForeground(Color.RED);
		labelDisponibles.setBorder(new LineBorder(SystemColor.textHighlight));
		labelDisponibles.setBounds(12, 580, 100, 29);
		labelPrecio.setForeground(Color.GREEN);
		labelPrecio.setBorder(new LineBorder(SystemColor.textHighlight));
		labelPrecio.setBounds(12, 622, 100, 29);
		btnalquilarYaMismo.setForeground(Color.GREEN);
		btnalquilarYaMismo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnalquilarYaMismo.setBounds(124, 661, 402, 46);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 661, 73, 46);
		labelDinero.setForeground(Color.GREEN);
		labelDinero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDinero.setBounds(81, 663, 157, 43);
		comboBoxA�o.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar pel\u00EDcula por a\u00F1o",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxA�o.setBackground(Color.BLACK);
		comboBoxA�o.setBounds(265, 6, 247, 55);
		btnalquilarYaMismo.setContentAreaFilled(false);
		panel.setBackground(Color.DARK_GRAY);
		scrollPane_1.setBounds(124, 511, 402, 140);
		scrollPane_1.setBorder(new LineBorder(SystemColor.textHighlight));

	}

	private void a�adirComponentes() {
		setSize(anchuraPanel, alturaPanel);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBorder(null);

		add(scrollPane);
		add(NombreUsuario);
		add(textFieldBuscarPelicula);
		add(comboBoxGenero);
		add(lblImagenPelicula);
		add(labelTitulo);
		add(labelDuracion);
		add(labelA�o);
		add(labelCategoria);
		add(scrollPane_1);

		add(labelDisponibles);
		add(labelPrecio);
		add(btnalquilarYaMismo);
		add(lblNewLabel);
		add(labelDinero);
		add(comboBoxA�o);

		scrollPane_1.setViewportView(textPaneDescripcion);
		scrollPane.setViewportView(panel);
		panel.setLayout(gl_panel);
	}

	private boolean comboBoxA�oPresionado = false;
	private boolean comboBoxGeneroPresionado = false;
	private List<String> arrayNombresPeliculasEncontradas = new ArrayList<String>();
	private JScrollPane scrollPane_1;

	private void eventos() {
		
	}
	
	/**
	 * M�todo para alquilar una pel�cula:
	 * 
	 * @param id_pelicula
	 * @throws ParseException
	 */
	private void alquilarPelicula(int id_pelicula) throws ParseException {
		if (comprobarPeliculaAlquilada(id_pelicula, cliente.getId_cliente()) == true) {
			JOptionPane.showMessageDialog(null, "�ESA PEL�CULA YA LA TIENES ALQUILADA!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// Creamos nuevo alquiler y lo subimos a la base de datos:
			Alquiler alquiler = new Alquiler(0, new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-28"),
					new SimpleDateFormat("yyyy-MM-dd").parse("2017-12-5"),
					cliente.getId_cliente(), id_inventario_alquiler);
			// Ahora ya podemos insertar el alquiler en la base de datos:
			BaseDeDatos bd = new BaseDeDatos();
			if (bd.insertarAlquiler(alquiler) == true) {
				JOptionPane.showMessageDialog(null, "Acabas de alquiler la pel�cula correctamente. Gracias.");
			}
		}
	}
	
	private int id_inventario_alquiler = 0;

	/**
	 * M�todo para comprobar si la ple�cula ya est� alguilada:
	 * 
	 * @param id_pelicula
	 * @param id_cliente
	 * @return
	 * @throws ParseException
	 */
	private boolean comprobarPeliculaAlquilada(int id_pelicula, int id_cliente) throws ParseException {
		// Devolver alquiler true/false:
		boolean dev = false;
		// Accedemos a la base de datos:
		BaseDeDatos bd = new BaseDeDatos();
		// Obtenemos los inventarios para buscar elinventario:
		List<Inventario> listaInventarios = bd.obtenerInventarios();
		// Obtenemos los clientes de la base de datos:
		List<Alquiler> listaAlquileres = bd.obtenerAlquileres();

		int id_inventario = 0;
		// Buscamos inventario:
		for (int i = 0; i < listaInventarios.size(); i++) {
			if (id_pelicula == listaInventarios.get(i).getPelicula()) {
				id_inventario = listaInventarios.get(i).getId_inventario();
				id_inventario_alquiler = id_inventario;
				break;
			}
		}

		// Buscamos la pel�cula del cliente si la ha alquilado:
		for (int i = 0; i < listaAlquileres.size(); i++) {
			if (listaAlquileres.get(i).getCliente() == id_cliente
					&& listaAlquileres.get(i).getInventario() == id_inventario) {
				// Entonces es que el cliente ya habia alquilado dicha pel�cula:
				dev = true;
				break;
			}
		}

		return dev;
	}
	private void valoresComboBoxCategorias() {
		BaseDeDatos bd = new BaseDeDatos();
		// Obtenemos primero las categorias de la base de datos:
		List<Categoria> arrayCategorias = bd.obtenerCategorias();
		// Introducimos las categorias en el combiBox:
		for (Categoria c : arrayCategorias) {
			comboBoxGenero.addItem(c.getNombre());
		}
	}

	private void valoresComboBoxA�os() {
		// Introducimos a�os desde 2017-1900:
		for (int i = 2017; i > 1900; i--) {
			comboBoxA�o.addItem(i);
		}
	}
}
