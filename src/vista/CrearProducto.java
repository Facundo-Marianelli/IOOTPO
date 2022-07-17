package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorProductos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearProducto extends JFrame {

	private JPanel contentPane;
	private JTextField codigoBarra;
	private JTextField descripcion;
	private JTextField precio;
	private JTextField stock;
	private JTextField stockMinimo;
	private ControladorProductos sistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProducto frame = new CrearProducto();
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
	public CrearProducto() {
		this.setTitle("Crear Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		codigoBarra = new JTextField();
		codigoBarra.setBounds(246, 11, 86, 20);
		contentPane.add(codigoBarra);
		codigoBarra.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("codigoBarra :");
		lblNewLabel.setBounds(32, 11, 96, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("descripcion: ");
		lblNewLabel_1.setBounds(32, 42, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("precio:");
		lblNewLabel_2.setBounds(32, 82, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		descripcion = new JTextField();
		descripcion.setBounds(246, 42, 86, 20);
		contentPane.add(descripcion);
		descripcion.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(246, 73, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("stock :");
		lblNewLabel_3.setBounds(32, 118, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("stockMinimo:");
		lblNewLabel_4.setBounds(32, 155, 76, 14);
		contentPane.add(lblNewLabel_4);
		
		stock = new JTextField();
		stock.setBounds(246, 104, 86, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		stockMinimo = new JTextField();
		stockMinimo.setBounds(246, 135, 86, 20);
		contentPane.add(stockMinimo);
		stockMinimo.setColumns(10);
		
		JButton btnNewButton = new JButton("crearProducto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					if (!codigoBarra.getText().equalsIgnoreCase(""))
					{
						int codigo= Integer.parseInt(codigoBarra.getText());
						int precioo=Integer.parseInt(precio.getText());
						int stockk=Integer.parseInt(stock.getText());
						int stockMin=Integer.parseInt(stockMinimo.getText());
						
						boolean respuesta=ControladorProductos.getAdmProductos().crearProducto(codigo, descripcion.getText(), precioo,stockk,stockMin);
						if (respuesta)
						{
							JOptionPane.showMessageDialog(null, "El producto se ha creado exitosamente","Producto Creado",JOptionPane.INFORMATION_MESSAGE);
							codigoBarra.setText("");
							descripcion.setText("");
							precio.setText("");
							stock.setText("");
							stockMinimo.setText("");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,  "El producto no se pudo crear","producto Duplicado",JOptionPane.ERROR_MESSAGE);
						}
							
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Ingrese un producto no vacio ","Producto incompleto",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "No ingrese caracteres en los campos que no corresponden","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
			}
	
		});
		btnNewButton.setBounds(109, 200, 123, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(294, 204, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
