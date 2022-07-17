package vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorVentas;
import modelo.Venta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalVenta extends JFrame {

	private JPanel contentPane;
	public int num;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalVenta frame = new MenuPrincipalVenta();
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
	public MenuPrincipalVenta() {
		this.setTitle("Menu Principal Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("iniciarVenta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num=ControladorVentas.getAdmVentas().iniciarVenta();
				JOptionPane.showMessageDialog(null, "la venta "+num+ "se ha iniciado exitosamente","venta creada",JOptionPane.INFORMATION_MESSAGE);
				CrearVenta ventana = new CrearVenta(num);
				ventana.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 11, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("buscarVenta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarVenta ventana = new BuscarVenta();
				ventana.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 51, 133, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("actualizarStock");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarProducto ventana = new ModificarProducto();
				ventana.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10, 100, 133, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("informarListadoVentasDiarios");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaVentas ventana = new ConsultaVentas();
				ventana.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(170, 11, 254, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("reportesVentasMensuales");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reporteVentasMensuales ventana = new reporteVentasMensuales();
				ventana.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(170, 51, 254, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("reportesVentasMensualesPorMedioDePago");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportesVentasMensualesPorMedioDePago ventana = new reportesVentasMensualesPorMedioDePago();
				ventana.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(170, 100, 254, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_8 = new JButton("calcularTotal");

		btnNewButton_8.setBounds(65, 151, 254, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("volver");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_7.setBounds(126, 211, 89, 23);
		contentPane.add(btnNewButton_7);
	}
}
