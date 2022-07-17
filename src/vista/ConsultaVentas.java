package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.ControladorVentas;
import modelo.Venta;

public class ConsultaVentas extends JFrame {

	private JPanel contentPane;

	public ConsultaVentas() {
		super("Consulta de Ventas");
		setBounds(100, 100, 778, 413);
		
		//Array bidimensional de objetos con los datos de la tabla
		
		Vector<Vector<String>>data = ControladorVentas.getAdmVentas().getSaldosVentas();
	
		
		//Array titulos de tabla		
		Vector<String>columnNames = new Vector<String>();
		columnNames.add("Nro venta");
		columnNames.add("Tipo venta");
		columnNames.add("total");
		
		//Creacion de la tabla
		final JTable table = new JTable(data, columnNames);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 80));
	
		//Creamos un scrollpanel y se lo agregamos a la tabla
		JScrollPane scrollpane = new JScrollPane(table);
	
		//Agregamos el scrollpanel al contenedor
		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}

}
