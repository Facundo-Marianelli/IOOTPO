package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorVentas;
import modelo.Venta;
import vista.MenuPrincipalVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.ActionEvent;
public class CrearVenta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CrearVenta(int num) {
		this.setTitle("Crear Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("numero");
		lblNewLabel.setBounds(60, 11, 46, 14);
		contentPane.add(lblNewLabel);
		textField = new JTextField(num+"");
		textField.setBounds(217, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("fecha");
		lblNewLabel_1.setBounds(60, 62, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField(LocalDate.now()+"");
		textField_1.setBounds(217, 59, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		btnNewButton_1 = new JButton("volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			
			}
		});
		btnNewButton_1.setBounds(93, 195, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ventaCredito");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (textField_1.getText().equalsIgnoreCase(""))
						{
						JOptionPane.showMessageDialog(null, "complete el campo faltante","Error ",JOptionPane.ERROR_MESSAGE);
						}
					else {
						AgregarProductoCredito ventana = new AgregarProductoCredito(num);
						ventana.setVisible(true);
						dispose();
						}	
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "No ingrese caracteres o numeros en los campos que no corresponden","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(20, 128, 120, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ventaDebito");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (textField_1.getText().equalsIgnoreCase(""))
						{
						JOptionPane.showMessageDialog(null, "complete el campo faltante","Error ",JOptionPane.ERROR_MESSAGE);
						}
					else {
						agregarProductosDebito ventana = new agregarProductosDebito(num);
						ventana.setVisible(true);
						dispose();
					}	
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "No ingrese caracteres o numeros en los campos que no corresponden","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(150, 128, 120, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ventaContado");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(textField_1.getText().equalsIgnoreCase(""))
					{
						JOptionPane.showMessageDialog(null, "complete el campo faltante","Error ",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						AgregarProductosContado ventana = new AgregarProductosContado(num);
						ventana.setVisible(true);
						dispose();
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "No ingrese caracteres o numeros en los campos que no corresponden","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_4.setBounds(280, 128, 144, 23);
		contentPane.add(btnNewButton_4);
		
	}
}
