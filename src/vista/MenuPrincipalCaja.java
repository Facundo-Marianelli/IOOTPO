package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorCaja;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalCaja extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalCaja frame = new MenuPrincipalCaja();
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
	public MenuPrincipalCaja() {
		this.setTitle("Menu Principal Caja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton_1 = new JButton("aperturaCaja");
		btnNewButton_1.setEnabled(false);
		
		JButton btnNewButton = new JButton("iniciarCaja");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorCaja.getAdmCaja().inicarCaja();
				JOptionPane.showMessageDialog(null,"La caja se ha iniciado exitosamente, ahora podra realizar la Apertura","Caja Inicializada",JOptionPane.INFORMATION_MESSAGE);
				btnNewButton_1.setEnabled(true);
			}
		});
		btnNewButton.setBounds(41, 11, 175, 40);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AperturaCaja ventana = new AperturaCaja();
				ventana.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(41, 78, 175, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("registrarVenta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrarVenta ventana = new RegistrarVenta();
				ventana.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(41, 155, 175, 47);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("volver");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(280, 108, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}
