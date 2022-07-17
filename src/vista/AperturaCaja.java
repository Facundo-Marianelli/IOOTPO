package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorCaja;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AperturaCaja extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AperturaCaja frame = new AperturaCaja();
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
	public AperturaCaja() {
		this.setTitle("Apertura Caja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(187, 32, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("saldoInicial");
		lblNewLabel.setBounds(46, 35, 99, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("abrirCaja");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int saldo= Integer.parseInt(textField.getText());
					if(textField.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null,"Por favor Complete el campo faltante ","Error",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						ControladorCaja.getAdmCaja().inicializarCaja(saldo);
						JOptionPane.showMessageDialog(null,"La apetura de la caja se ha realizado exitosamente","Caja Abierta",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}

				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,  "Debe ingresar numeros!","Error DATOS",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(89, 133, 144, 56);
		contentPane.add(btnNewButton);
	}

}
