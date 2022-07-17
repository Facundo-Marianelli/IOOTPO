package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorVentas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarVenta<vta> extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private modelo.Venta venta;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVenta frame = new BuscarVenta();
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
	public BuscarVenta() {
		this.setTitle("Buscar Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("numeroVenta");
		lblNewLabel.setBounds(22, 58, 103, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(203, 55, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("buscarVenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
				
				int vta= Integer.parseInt(textField.getText());
				venta= ControladorVentas.getAdmVentas().buscarVenta(vta);
				if(venta!=null)
				{
					JOptionPane.showMessageDialog(null, "la venta se encuentra en el sistema","venta encontrada",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "la venta no se encuentra en el sistema","venta no existente",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "Debe ingresar un numero","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(104, 149, 120, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(121, 199, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
