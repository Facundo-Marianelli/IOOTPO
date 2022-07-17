package modelo;

import java.util.Vector;

public class VentaDebito extends Venta {
	private String banco;
	private int numero;
	private int codigoSeguridad;
	public void calcularSubtotal()
	{
		
	}
	public boolean registrarCodigoSeguridad( int numero, int codigoSeguridad,int cuentaCorriente )
	{
		return false;
		
	}
	public  Vector<String> getDatosCuenta()
	{
		Vector<String>datos = new Vector<String>();
		datos.add(numero+"");
		datos.add("Venta Debito");
		datos.add(total+"a");
		return datos;
	}

}
