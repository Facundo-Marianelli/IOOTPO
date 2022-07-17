package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class ConsultaVentaDiarias extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVentaDiarias frame = new ConsultaVentaDiarias();
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
	public ConsultaVentaDiarias() {
		super("Ejemplo de Tabla con Encabezado");

		//Array bidimensional de objetos con los datos de la tabla
		Object[][] data = {
		{"Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false)},
		{"Lhucas", "Huml", "Patinar", new Integer(3), new Boolean(true)},
		{"Kathya", "Walrath", "Escalar", new Integer(2), new Boolean(false)},
		{"Marcus", "Andrews", "Correr", new Integer(7), new Boolean(true)},
		{"Angela", "Lalth", "Nadar", new Integer(4), new Boolean(false)}
		};
	
		//Array de ‘String’ con los titulos de las columnas
		String[] columnNames = {"Nombre", "Apellido", "Pasatiempo", "Años de Practica", "Soltero(a)"};
	
		//Creacion de la tabla
		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
	
		//Creamos un scrollpanel y se lo agregamos a la tabla
		JScrollPane scrollpane = new JScrollPane(table);
	
		//Agregamos el scrollpanel al contenedor
		getContentPane().add(scrollpane, BorderLayout.CENTER);
	
	}
}
