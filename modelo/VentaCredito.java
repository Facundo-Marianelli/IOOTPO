package modelo;

import java.util.Vector;

public class VentaCredito extends Venta
{
	private String entidadFinanciera;
	private int numero;
	private int total;
	private int codigoSeguridad;
	private String tipo;
	
	public boolean registrarCodigoSeguridad( int numero, int codigoSeguridad,String entidadFinanciera)
	{
		return false;
		
	}
	public  Vector<String> getDatosCuenta()
	{
		Vector<String>datos = new Vector<String>();
		datos.add(numero+"");
		datos.add("Venta Credito");
		datos.add(total+"");
		return datos;
	}
}