package modelo;
import java.time.LocalDate;
import java.util.Vector;

public abstract class Venta {
	protected static int numerador;
	protected int numero;
	protected LocalDate fecha;
	protected static float total;
	protected String tipo;
	private Vector<ItemVenta> items;
	private int getProximoNumero()
	{
		return ++numerador;
	}
	
	private float getTotal()
	{
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Venta()
	{
		numero = getProximoNumero();
		fecha= LocalDate.now();
		items = new Vector<ItemVenta>();
	}
	public Venta(int numero, int total, String tipo)
	{
		super();
		this.numero = numero;
		this.total = total;
		this.tipo = tipo;
	}
	public float calcularTotal()
	{
		for (ItemVenta itemVenta : items) 
		{
			this.total= this.total + itemVenta.calcularSubtotal();
		}
		return this.total;
	
	}
	public float calcularsub() {
        {
            for (ItemVenta itemVenta : this.items) 
            {
                this.total = this.total + itemVenta.calcularSubtotal();
            }
            return this.total;
        }
	}
	public boolean sosLaVenta(int vta) 
	{
		return (vta==numero);
	}
	public int getNumero() {
		return numero;
	}
	public void agregarItem(Producto p, int cantidad)
	{
		ItemVenta newItem = new ItemVenta(p,cantidad);
		items.add(newItem);
	}
	public LocalDate getFecha(){
		return fecha;
	}
	public String getTipo()
	{
		return tipo;
	}
	
	public void actualizarStock() {
		// TODO Auto-generated method stub
		for (ItemVenta itemVenta : items) 
		{
			itemVenta.actualizarStock();
		}
		
	}
	public abstract Vector<String> getDatosCuenta();
	}

