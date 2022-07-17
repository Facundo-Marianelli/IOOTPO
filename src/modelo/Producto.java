package modelo;

public class Producto {
	private int codigoBarra;
	private String descripcion;
	private float precio;
	private int stock;
	private int stockMinimo;
	private String estado;
	public Producto (int codigoBarra, String descripcion, float precio, int stock, int stockMinimo)
	{
		this.codigoBarra=codigoBarra;
		this.descripcion=descripcion;
		this.precio=precio;
		this.stock=stock;
		this.stockMinimo=stockMinimo;
		estado="Activo";
	}
	public boolean sosElProducto(int codigo)
	{
		return (codigo==codigoBarra);
		//es lo mismo que
		/*
		if (codigo==codigoBarra)
			return true;
		else
			return false;
			
		*/
	}
	public int getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(int codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public void descontarStock(int cant) {
		// TODO Auto-generated method stub
		stock = stock - cant;
		
	}
	

}
