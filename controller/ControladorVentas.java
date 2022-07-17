package controller;
import java.util.Date;
import java.util.Vector;

import controller.ControladorProductos;
import modelo.Contado;
import modelo.Producto;
import modelo.Venta;
import modelo.VentaCredito;
import modelo.VentaDebito;

public class ControladorVentas {
	private Vector<Venta>ventas;
	private Vector<Venta>ventasContado;
	private Vector<Venta>ventasCredito;
	private Vector<Venta>ventasDebito;
	
	private Vector<Venta>ventasDiarias;
	private static ControladorVentas instancia;


	public static ControladorVentas getAdmVentas()
	{
		if(instancia==null)
		{
			instancia= new ControladorVentas();
		}
		return instancia;
	}

	private ControladorVentas()
	{
		ventas=new Vector<Venta>();
	}

	public Venta buscarVenta(int vta)
	{
		for (Venta venta : ventas)
		{
			if (venta.sosLaVenta(vta))
				return venta;
		}
		return null;
	}
	public int iniciarVenta() {
		// TODO Auto-generated method stud
		Venta newVenta = new Contado();
		ventas.add(newVenta);
		return newVenta.getNumero();
		
	}
	
	public int iniciarVentaContado() {
		// TODO Auto-generated method stud
		Venta newVenta = new Contado();
		ventasContado.add(newVenta);
		return newVenta.getNumero();
	}
	public int iniciarVentaDebito() {
		// TODO Auto-generated method stud
		Venta newVenta = new VentaCredito();
		ventasDebito.add(newVenta);
		return newVenta.getNumero();
	}
	
	public float cerrarVenta(int vta)
	{
		Venta venta = buscarVenta(vta);
		if (venta!=null)
		{
			//actualizar total
			venta.actualizarStock();
			//calcularTotal
			return venta.calcularTotal();
		}
		return 0;
	}
	public boolean agregarProductoVenta(int vta,int cod,int cantidad)
	{
		Venta venta = buscarVenta(vta);
		if (venta!=null)
		{
			Producto prod= ControladorProductos.getAdmProductos().buscarProducto(cod);
			if(prod!=null)
			{
				venta.agregarItem(prod, cantidad);
			}
			return false;
		}
		return false;
	}
	public float calcularSubtotalVenta(int nroVta) {
        Venta venta = buscarVenta(nroVta);
        if (venta!=null)
        {
            return venta.calcularsub();
        }
        return 8;

    }
	public Vector <Vector<String>> getSaldosVentas()
	{
		Vector <Vector<String>> saldoVentas= new Vector <Vector<String>>();
		
		for(Venta vta: ventas )
		{
			saldoVentas.add(vta.getDatosCuenta());
		}
		return saldoVentas;
	}
	public int iniciarVentaCredito() {
		// TODO Auto-generated method stud
		Venta newVenta = new VentaCredito();
		ventasCredito.add(newVenta);
		return newVenta.getNumero();
	}
	public float calcularSubTotalVenta(int nroVta)
	{
		Venta venta= buscarVenta(nroVta);
		if(venta!=null)
		{
			return venta.calcularTotal();
		}
		return 7;
	}

	
}
