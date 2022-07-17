package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.ControladorProductos;
import modelo.Producto;

public class ModificarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigoBarra;
	private JTextField descripcion;
	private JTextField precio;
	private JTextField stock;
	private JTextField stockMinimo;
	private ControladorProductos sistema;
	private Producto producto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProducto frame = new ModificarProducto();
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
	public ModificarProducto() {
		super();
		this.setTitle("Modificar/Eliminar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("modificarProducto");
		btnNewButton.setBounds(211, 193, 124, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		codigoBarra = new JTextField();
		codigoBarra.setBounds(229, 18, 86, 20);
		contentPane.add(codigoBarra);
		codigoBarra.setColumns(10);
		
		descripcion = new JTextField();
		descripcion.setBounds(229, 49, 86, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		descripcion.setVisible(false);
		
		precio = new JTextField();
		precio.setBounds(229, 83, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		precio.setVisible(false);
		
		stock = new JTextField();
		stock.setBounds(229, 115, 86, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		stock.setVisible(false);
		
		stockMinimo = new JTextField();
		stockMinimo.setBounds(229, 150, 86, 20);
		contentPane.add(stockMinimo);
		stockMinimo.setColumns(10);
		
		JLabel codigoBarraLab = new JLabel("codigoBarra");
		codigoBarraLab.setBounds(59, 21, 79, 14);
		contentPane.add(codigoBarraLab);
		
		JLabel precioLab = new JLabel("precio");
		precioLab.setBounds(59, 83, 46, 14);
		contentPane.add(precioLab);
		precioLab.setVisible(false);
		
		JLabel stockLab = new JLabel("stock");
		stockLab.setBounds(59, 118, 46, 14);
		contentPane.add(stockLab);
		stockLab.setVisible(false);
		
		JLabel stockMinLab = new JLabel("stockMinimo");
		stockMinLab.setBounds(59, 153, 79, 14);
		contentPane.add(stockMinLab);
		stockMinLab.setVisible(false);
		
		JLabel descipcionLab = new JLabel("descripcion");
		descipcionLab.setBounds(59, 50, 79, 14);
		contentPane.add(descipcionLab);
		descipcionLab.setVisible(false);
		
		
		
		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.setBounds(109, 193, 89, 23);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_5 = new JButton("INGRESAR OTRO CODIGO");
		JButton btnNewButton_3 = new JButton("ELIMINAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				int codigo= Integer.parseInt(codigoBarra.getText());
				int precioo=Integer.parseInt(precio.getText());
				int stockk=Integer.parseInt(stock.getText());
				int stockMin=Integer.parseInt(stockMinimo.getText());
				ControladorProductos.getAdmProductos().modificarProducto(codigo, descripcion.getText(), precioo, stockk, stockMin);
				JOptionPane.showMessageDialog(null, "El producto se ha modificado exitosamente","Producto Modificado",JOptionPane.INFORMATION_MESSAGE);
				codigoBarra.setText("");
				descripcion.setText("");
				precio.setText("");
				stock.setText("");
				stockMinimo.setText("");
				descripcion.setVisible(false);
				precio.setVisible(false);
				stock.setVisible(false);
				stockMinimo.setVisible(false);
				btnNewButton_1.setVisible(true);
				descipcionLab.setVisible(false);
				precioLab.setVisible(false);
				stockLab.setVisible(false);
				stockMinLab.setVisible(false);
				codigoBarra.setEnabled(true);
				btnNewButton_3.setVisible(false);
				btnNewButton.setVisible(false);
				btnNewButton_5.setVisible(false);
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "No ingrese caracteres en los campos que no corresponden","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(345, 193, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prod= Integer.parseInt(codigoBarra.getText());
				ControladorProductos.getAdmProductos().eliminarProducto(prod);
				JOptionPane.showMessageDialog(null, "El producto se ha eliminado exitosamente","Producto Eliminado",JOptionPane.INFORMATION_MESSAGE);
				codigoBarra.setText("");
				codigoBarra.setEnabled(true);
				btnNewButton_1.setVisible(true);
				btnNewButton_5.setVisible(false);
				btnNewButton_3.setVisible(false);
				btnNewButton.setVisible(false);
				descripcion.setVisible(false);
				precio.setVisible(false);
				stock.setVisible(false);
				stockMinimo.setVisible(false);
				btnNewButton_1.setVisible(true);
				descipcionLab.setVisible(false);
				precioLab.setVisible(false);
				stockLab.setVisible(false);
				stockMinLab.setVisible(false);
				codigoBarra.setEnabled(true);
				btnNewButton_3.setVisible(false);
				btnNewButton.setVisible(false);
				btnNewButton_5.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(10, 193, 89, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigoBarra.setEnabled(true);
				codigoBarra.setText("");
				precioLab.setVisible(false);
				stockLab.setVisible(false);
				stockMinLab.setVisible(false);
				descipcionLab.setVisible(false);
				precio.setVisible(false);
				stock.setVisible(false);
				stockMinimo.setVisible(false);
				descripcion.setVisible(false);
				btnNewButton_1.setVisible(true);
				btnNewButton.setVisible(false);
				btnNewButton_3.setVisible(false);
				btnNewButton_5.setVisible(false);
				
			}
		});
		btnNewButton_5.setBounds(119, 227, 179, 23);
		contentPane.add(btnNewButton_5);
		btnNewButton_3.setVisible(false);
		stockMinimo.setVisible(false);
		btnNewButton_5.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int prod= Integer.parseInt(codigoBarra.getText());
					producto = ControladorProductos.getAdmProductos().buscarProducto(prod);
					if (producto != null)
					{
						btnNewButton_5.setVisible(true);
						btnNewButton.setVisible(true);
						btnNewButton_3.setVisible(true);
						precioLab.setVisible(true);
						stockLab.setVisible(true);
						stockMinLab.setVisible(true);
						descipcionLab.setVisible(true);
						precio.setVisible(true);
						stock.setVisible(true);
						stockMinimo.setVisible(true);
						descripcion.setVisible(true);
						btnNewButton_1.setVisible(false);
						btnNewButton.setVisible(true);
						codigoBarra.setEnabled(false);
						precio.setText(precio.getText());
						stock.setText(stock.getText());
						stockMinimo.setText(stockMinimo.getText());
						descripcion.setText(descripcion.getText());
		
					}
					else 
					{
						JOptionPane.showMessageDialog(null,  "No existe el producto, por favor ingrese uno existente","Error Producto Inexistente",JOptionPane.ERROR_MESSAGE);
						codigoBarra.setText("");
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "No ingrese caracteres en los campos que no corresponden","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		}}