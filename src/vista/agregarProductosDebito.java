package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControladorVentas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class agregarProductosDebito extends JFrame {

	private JPanel contentPane;

	private modelo.Venta venta;
	public agregarProductosDebito(int num) {
		this.setTitle("Venta Debito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("numeroVta");
		lblNewLabel.setBounds(52, 25, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo producto");
		lblNewLabel_1.setBounds(52, 50, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("cantidad");
		lblNewLabel_2.setBounds(52, 75, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("codigoSeguridad");
		lblNewLabel_3.setBounds(52, 140, 119, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextField textField = new JTextField(num+"");
		textField.setBounds(194, 22, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(194, 47, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(194, 72, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(194, 137, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("numeroTarjeta");
		lblNewLabel_4.setBounds(52, 115, 92, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(194, 112, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("total");
		lblNewLabel_5.setBounds(52, 181, 77, 14);
		contentPane.add(lblNewLabel_5);
		
		JTextField textField_5 = new JTextField();
		textField_5.setBounds(194, 178, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Banco");
		lblNewLabel_6.setBounds(52, 206, 92, 14);
		contentPane.add(lblNewLabel_6);
		
		JTextField textField_6 = new JTextField();
		textField_6.setBounds(194, 209, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("agregarProductos");

		btnNewButton.setBounds(131, 240, 184, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(335, 240, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("cerrarVenta");
		btnNewButton_2.setEnabled(false);

		btnNewButton_2.setBounds(10, 240, 119, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_1.getText().equalsIgnoreCase("")||textField_2.getText().equalsIgnoreCase("")||textField_3.getText().equalsIgnoreCase("")||textField_4.getText().equalsIgnoreCase("")||textField_5.getText().equalsIgnoreCase("")||textField_6.getText().equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(null, "complete el campo faltante","Error ",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						int vta= Integer.parseInt(textField.getText());
						int cod=Integer.parseInt(textField_1.getText());
						int cant=Integer.parseInt(textField_2.getText());
						ControladorVentas.getAdmVentas().agregarProductoVenta(vta, cod, cant);
						JOptionPane.showMessageDialog(null, "producto agregado exitosamente","Producto agregado",JOptionPane.INFORMATION_MESSAGE);
						btnNewButton_2.setEnabled(true);
						btnNewButton.setEnabled(false);
					}

					}
					catch(NumberFormatException ex)
					{
						JOptionPane.showMessageDialog(null,  "No ingrese caracteres o numeros en los campos que no corresponden","Error DATOS",JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int vta= Integer.parseInt(textField.getText());
					venta= ControladorVentas.getAdmVentas().buscarVenta(vta);
					if (venta!=null)
					{
						JOptionPane.showMessageDialog(null, "la venta se ha cerrado exitosamente, ","venta cerrada",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "la venta no se ha  encuentra en el sistema ","venta no cerrada",JOptionPane.INFORMATION_MESSAGE);
					}
					}
					catch(NumberFormatException ex)
					{
						JOptionPane.showMessageDialog(null,  "Debe ingresar un Numero","Error DATOS",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
	}

}
