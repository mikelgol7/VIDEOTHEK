package Paneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import BD.BaseDeDatos;
import Datos.Pelicula;

public class PanelAdministrador extends JPanel {

	private int anchuraPanel = 1080;
	private int alturaPanel = 720;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnMostrarInventarioDe;
	private JButton btnMostrarAlquileresDe;
	private JButton btnMostrarClientes;
	private JButton btnInsertarNuevaPelcula;
	private JButton btnEliminarPelcula;
	private JLabel label;
	private JTextField textFieldNombrePelicula;
	private JComboBox<Integer> comboBoxAnyo;
	private JComboBox<Integer> comboBoxDuracion;
	private JComboBox<String> comboBoxCategoria;
	private JTextPane textPaneDescripcion;
	private JScrollPane scrollPane_2;
	private JButton btnInsertarNuevoInventario;
	private JTextPane textPaneMostrarDescripcion;
	private JScrollPane scrollPane_3;
	private JComboBox<Float> comboBoxPrecio;

	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table_1;
	private JScrollPane scrollPane_1;

	/**
	 * Create the panel.
	 */
	public PanelAdministrador() {
		inicializar();
		componentes();
		añadirComponentes();
		eventos();

	}

	private void inicializar() {
		btnMostrarInventarioDe = new JButton("Mostrar inventario de pel\u00EDculas");
		btnMostrarAlquileresDe = new JButton("Mostrar alquileres de pel\u00EDculas");
		btnMostrarClientes = new JButton("Mostrar clientes");
		btnInsertarNuevaPelcula = new JButton("Insertar nueva pel\u00EDcula");
		btnEliminarPelcula = new JButton("Eliminar pel\u00EDcula");
		scrollPane = new JScrollPane();
		table = new JTable();
		label = new JLabel();
		scrollPane_1 = new JScrollPane();
		table_1 = new JTable();
		textFieldNombrePelicula = new JTextField();
		comboBoxAnyo = new JComboBox<Integer>();
		comboBoxDuracion = new JComboBox<Integer>();
		comboBoxCategoria = new JComboBox<String>();
		scrollPane_2 = new JScrollPane();
		textPaneDescripcion = new JTextPane();
		btnInsertarNuevoInventario = new JButton("Insertar nuevo inventario");
		scrollPane_3 = new JScrollPane();
		textPaneMostrarDescripcion = new JTextPane();
		comboBoxPrecio = new JComboBox<Float>();
	}

	private void componentes() {
		btnMostrarInventarioDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMostrarInventarioDe.setBounds(12, 13, 232, 41);
		btnMostrarAlquileresDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMostrarAlquileresDe.setBounds(255, 13, 225, 41);
		btnMostrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMostrarClientes.setBounds(492, 13, 135, 41);
		btnInsertarNuevaPelcula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsertarNuevaPelcula.setBounds(12, 535, 185, 41);
		btnEliminarPelcula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminarPelcula.setBounds(418, 535, 232, 41);
		scrollPane.setBounds(12, 67, 1056, 286);
		label.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Insertar pel\u00EDcula",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 120, 215)));
		label.setBounds(12, 582, 1056, 125);
		table.setCellSelectionEnabled(true);
		table.setRowHeight(20);
		table.setGridColor(new Color(0, 51, 102));
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setSelectionBackground(new Color(0, 0, 153));
		table.setSelectionForeground(new Color(0, 204, 102));
		scrollPane_1.setBounds(12, 356, 1056, 85);
		table_1.setSelectionForeground(new Color(0, 204, 102));
		table_1.setSelectionBackground(new Color(0, 0, 153));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(0, 51, 102));
		table_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		table_1.setCellSelectionEnabled(true);
		textFieldNombrePelicula.setBackground(Color.DARK_GRAY);
		textFieldNombrePelicula.setBorder(new TitledBorder(null, "NOMBRE DE LA PELICULA", TitledBorder.CENTER,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		textFieldNombrePelicula.setBounds(22, 598, 205, 94);
		textFieldNombrePelicula.setColumns(10);
		comboBoxAnyo.setBackground(Color.DARK_GRAY);
		comboBoxAnyo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00D1O",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxAnyo.setBounds(359, 601, 93, 91);
		comboBoxDuracion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "DURACION",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxDuracion.setBackground(Color.DARK_GRAY);
		comboBoxDuracion.setBounds(464, 601, 127, 91);
		comboBoxCategoria.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CATEGORIA",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxCategoria.setBackground(Color.DARK_GRAY);
		comboBoxCategoria.setBounds(603, 601, 135, 91);
		scrollPane_2.setBounds(744, 600, 312, 92);
		scrollPane_2.setViewportView(textPaneDescripcion);
		textPaneDescripcion.setBackground(Color.DARK_GRAY);
		textPaneDescripcion.setBorder(new TitledBorder(null, "DESCRIPCION", TitledBorder.CENTER, TitledBorder.TOP, null,
				SystemColor.textHighlight));
		btnInsertarNuevoInventario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsertarNuevoInventario.setBounds(209, 535, 197, 41);
		scrollPane_1.setBorder(new TitledBorder(null,
				"Pel\u00EDculas alquiladas por los clientes - Nombre y descripci\u00F3n del cliente en particular",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		textPaneMostrarDescripcion.setForeground(Color.WHITE);
		textPaneMostrarDescripcion.setBackground(Color.DARK_GRAY);
		textPaneMostrarDescripcion.setBorder(new TitledBorder(null,
				"Descripci\u00F3n total de la pel\u00EDcula (primero click en descripci\u00F3n de pel\u00EDcula)",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		scrollPane_3.setBounds(12, 454, 1056, 70);
		comboBoxPrecio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "PRECIO",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxPrecio.setBackground(Color.DARK_GRAY);
		comboBoxPrecio.setBounds(233, 601, 114, 91);
	}

	private void añadirComponentes() {
		setSize(anchuraPanel, alturaPanel);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBorder(null);

		add(btnMostrarInventarioDe);
		add(btnMostrarAlquileresDe);
		add(btnMostrarClientes);
		add(btnInsertarNuevaPelcula);
		add(btnEliminarPelcula);
		add(textFieldNombrePelicula);
		add(comboBoxAnyo);
		add(comboBoxDuracion);
		add(comboBoxCategoria);
		add(comboBoxPrecio);
		add(scrollPane_2);
		add(scrollPane);
		add(label);
		add(scrollPane_1);
		add(btnInsertarNuevoInventario);
		add(scrollPane_3);

		scrollPane_3.setViewportView(textPaneMostrarDescripcion);
		scrollPane.setViewportView(table);
		scrollPane_1.setViewportView(table_1);

	}

	private void eventos() {
		
		btnMostrarInventarioDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPeliculas();
			}
		});
		
	}
	private void columnasTabla(int i) {
		// Creacion de las columnas de la tabla:
		if (i == 0) {
			tableModel.addColumn("ID");
			tableModel.addColumn("NOMBRE");
			tableModel.addColumn("DURACION");
			tableModel.addColumn("DESCRIPCION");
			tableModel.addColumn("AÑO");
			tableModel.addColumn("CATEGORIA");
			tableModel.addColumn("DISPONIBLES");
			tableModel.addColumn("PRECIO");
		} else if (i == 1) {
			tableModel.addColumn("ID");
			tableModel.addColumn("NOMBRE");
			tableModel.addColumn("APELLIDOS");
			tableModel.addColumn("FECHA NACIMIENTO");
			tableModel.addColumn("CALLE");
			tableModel.addColumn("CIUDAD");
			tableModel.addColumn("PAIS");
		} else if (i == 2) {
			tableModel.addColumn("ID");
			tableModel.addColumn("FECHA DE ALQUILER");
			tableModel.addColumn("FECHA DE DEVOLUCION");
			tableModel.addColumn("Nº CLIENTE");
			tableModel.addColumn("Nº INVENTARIO");
		}
	}
	
	private void resaltarColumnas(JTable tabla, int numeroColumnas, int[] columnasAResaltar, boolean coumnaModificable,
			int[] columnaAModificar) {
		for (int i = 0; i < numeroColumnas; i++) {
			// Indicamos como sera el resaltado de la tabla
			for (int j = 0; j < columnasAResaltar.length; j++) {
				if (i == columnasAResaltar[j]) {
					tabla.getColumnModel().getColumn(i)
							.setCellRenderer(new Resaltador(true, coumnaModificable, columnaAModificar));
					break;
				} else {
					tabla.getColumnModel().getColumn(i)
							.setCellRenderer(new Resaltador(false, coumnaModificable, columnaAModificar));
				}
			}
		}
	}
	
	
	
	private boolean peliculasEnTabla = false;
	
	private void mostrarPeliculas() {
		BaseDeDatos bd = new BaseDeDatos();
		tableModel = new DefaultTableModel();
		columnasTabla(0);
		List<Pelicula> arrayPeliculas = bd.obtenerPeliculas();
		for (int i = 0; i < arrayPeliculas.size(); i++) {
			tableModel.addRow(new Object[] { arrayPeliculas.get(i).getId_pelicula(), arrayPeliculas.get(i).getNombre(),
					arrayPeliculas.get(i).getDuracion(), arrayPeliculas.get(i).getDescripcion(),
					arrayPeliculas.get(i).getAnyo(), arrayPeliculas.get(i).getCategoria(),
					arrayPeliculas.get(i).getDisponibles(), arrayPeliculas.get(i).getPrecio() });
		}

		// Introducimos el modelo en la tabla:
		table.setModel(tableModel);
		resaltarColumnas(table, 8, new int[] { 0, 3, 6, 7 }, true, new int[] { 6, 7 });
		peliculasEnTabla = true;
	}
	public class Resaltador implements TableCellRenderer {
		private boolean resaltado;
		private boolean columnaModificable;
		private int[] columna;
		public final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

		/**
		 * Creamos el resaltador indicando que columna se coloreara por defecto
		 * 
		 * @param columna
		 */
		public Resaltador(boolean resaltado, boolean columnaModificable, int[] columna) {
			this.resaltado = resaltado;
			this.columnaModificable = columnaModificable;
			this.columna = columna;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// Obtenemos la celda que se esta renderizando
			Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			DEFAULT_RENDERER.setHorizontalAlignment(SwingConstants.CENTER);

			// Solo marcaremos las columnas que quieran ser reslatadas:
			if (resaltado == true) {
				if (isSelected == true) {
					c.setBackground(Color.GREEN);
					c.setForeground(Color.BLACK);
				} else {
					c.setBackground(Color.BLUE);
					c.setForeground(Color.BLACK);
				}

				for (int i = 0; i < columna.length; i++) {
					if (columnaModificable == true && columna[i] == column) {
						c.setBackground(Color.GREEN);
						c.setForeground(Color.RED);
					}
				}

			}
			return c;
		}
	}
}

