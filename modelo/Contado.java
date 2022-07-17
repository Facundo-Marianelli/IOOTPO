package modelo;

import java.util.Vector;

import controller.ControladorVentas;

public class Contado extends Venta 
{
	private float monto;
	private int cantBilletes;
	private float montoPagado;
	private float vuelto;
	private Vector<Contado> ventaContado;
	public float calcularSubtotal()
	{
		return (ItemVenta.getitemVenta().calcularSubtotal());
	}
	public float getTotal() {
		return total;
		
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public  Vector<String> getDatosCuenta()
	{
		Vector<String>datos = new Vector<String>();
		datos.add(numero+"");
		datos.add("Venta Contado");
		datos.add(total+"");
		return datos;
	}

	
	
}

