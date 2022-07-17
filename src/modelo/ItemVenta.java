package modelo;

public class ItemVenta {
	private static int cantidad;
	private static Producto producto;
	public ItemVenta(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	private static ItemVenta instancia;

	public static ItemVenta getitemVenta()
	{
		if(instancia==null)
		{
			instancia= new ItemVenta(producto, cantidad);
		}
		return instancia;
	}
	public float calcularSubtotal() {
		// TODO Auto-generated method stub
		return cantidad * producto.getPrecio();
	}
	public void actualizarStock() {
		// TODO Auto-generated method stub
		producto.descontarStock(cantidad);
		
		
	}
}
