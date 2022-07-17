package controller;

import modelo.Caja;

public class ControladorCaja {
	private static ControladorCaja instancia;
	int saldoInicial;
	public static ControladorCaja getAdmCaja()
	{
		if(instancia==null)
		{
			instancia= new ControladorCaja();
		}
		return instancia;
	}	
	public void inicarCaja()
	{
		Caja newcaja = new Caja(saldoInicial);
	}
	public int inicializarCaja(int saldoInicial)
	{
		return saldoInicial;
	}
}
