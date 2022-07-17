package controller;
import java.util.Vector;

import modelo.Producto;


public class ControladorProductos {
	private Vector<Producto>productos;
	private static ControladorProductos instancia;
	private ControladorProductos()
	{
		productos = new Vector<Producto>();
	}
	public static ControladorProductos getAdmProductos()
	{
		if(instancia==null)
		{
			instancia= new ControladorProductos();
		}
		return instancia;
	}
	public boolean crearProducto(int codigoBarra, String descripcion, int precio, int stock, int stockMinimo)
	{
		Producto newProd= buscarProducto(codigoBarra);
		if(newProd==null)
		{
			newProd = new Producto(codigoBarra,descripcion,precio,stock,stockMinimo);
			productos.add(newProd);
			return true;
		}
		return false;
	}
	public Producto buscarProducto(int codigoBarra)
	{
		for (Producto productoB : productos)
		{
			if (productoB.sosElProducto(codigoBarra))
				return productoB;
		}
		return null;
	}
	public boolean modificarProducto( int codigoBarra, String descripcion, float precio, int stock, int stockMinimo)
	{
		Producto modifProd = buscarProducto(codigoBarra);
		if (modifProd!=null)
		{
			//para modificar un valor es asi, no como hice yo de poner: string="hola",int precio=20;
			modifProd.setCodigoBarra(codigoBarra);
			modifProd.setDescripcion(descripcion);
			modifProd.setPrecio(precio);
			modifProd.setStock(stock);
			modifProd.setStockMinimo(stockMinimo);
			return true;
		}
		return false;
		
	}

	public boolean eliminarProducto(int codigoBarra)
	{
		Producto elimProd= buscarProducto(codigoBarra);
		if (elimProd!=null)
		{
			productos.remove(elimProd);
			return true;
		}
		return false;
	}
	public Producto emitirListadoStockMinimo( int cantidad, Producto producto,  int stockMinimo)
	{
		for(Producto productoStockMin: productos)
		{
			return producto;
		}
		return null;
		
	}

}
