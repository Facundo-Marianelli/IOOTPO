package modelo;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

public class Caja { 
	private float saldoInicial;
	private LocalDate fecha;
	private Vector<Venta>ventasDiarias;
	private float saldoTotal;
	public Caja(float saldoInicial) {
		fecha=LocalDate.now();
		ventasDiarias=new Vector<Venta>();
		this.saldoInicial=saldoInicial;
	}

	public float getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	

}
