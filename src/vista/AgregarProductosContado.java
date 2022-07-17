package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorVentas;
import modelo.ItemVenta;
import modelo.Producto;
import modelo.Venta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AgregarProductosContado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private modelo.Venta venta;
	private JTextField textField_3;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AgregarProductosContado(int num) {
		this.setTitle("Venta Contado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo producto");
		lblNewLabel.setBounds(60, 60, 113, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("cantidad");
		lblNewLabel_1.setBounds(60, 120, 73, 27);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(183, 63, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();

		textField_1.setBounds(183, 123, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_2 = new JTextField(num+"");
		textField_2.setBounds(183, 11, 86, 20);
		contentPane.add(textField_2);
		textField_2.setEnabled(false);
		
		textField_2.setColumns(10);
		
		lblNewLabel_2 = new JLabel("numeroVta");
		lblNewLabel_2.setBounds(60, 14, 73, 14);
		contentPane.add(lblNewLabel_2);
		JButton btnNewButton = new JButton("agregarProductos");

		btnNewButton.setBounds(131, 227, 188, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(183, 168, 86, 20);
		
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("total");
		lblNewLabel_3.setBounds(60, 171, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton_2 = new JButton("cerrarVenta");
		btnNewButton_2.setEnabled(false);

		btnNewButton_2.setBounds(12, 227, 113, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					{
						int vta= Integer.parseInt(textField.getText());
						int cod=Integer.parseInt(textField_1.getText());
						int cant=Integer.parseInt(textField_2.getText());
						ControladorVentas.getAdmVentas().agregarProductoVenta(vta, cod, cant);
						JOptionPane.showMessageDialog(null, "producto agregado exitosamente","Producto agregado",JOptionPane.INFORMATION_MESSAGE);
						btnNewButton_2.setEnabled(true);
						btnNewButton.setEnabled(false);
						textField_3.setText(String.valueOf(ControladorVentas.getAdmVentas().calcularSubTotalVenta(vta)));
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
					int vta= Integer.parseInt(textField_2.getText());
					venta= ControladorVentas.getAdmVentas().buscarVenta(vta);
					if (venta!=null)
					{
						
						JOptionPane.showMessageDialog(null, "la venta se ha cerrado exitosamente, ","venta cerrada",JOptionPane.INFORMATION_MESSAGE);
						venta.getDatosCuenta();
						ControladorVentas.getAdmVentas().getSaldosVentas();
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
