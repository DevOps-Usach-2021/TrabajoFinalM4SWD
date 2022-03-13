package com.devops.dxc.devops.model;

import java.io.Serializable;

public class Resultado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988002029080131424L;
	
	private int valor;
	private boolean valido;
	private String mensaje;

	public Resultado(int valor,boolean valido,String mensaje){
		this.valor = valor;
		this.valido = valido;
		this.mensaje = mensaje;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public boolean getValido() {
		return this.valido;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
