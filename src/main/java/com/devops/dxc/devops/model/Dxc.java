package com.devops.dxc.devops.model;

import java.io.Serializable;

public class Dxc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2988002029080131424L;
	
	private int dxc;
	private int saldo;
	private int impuesto;
	private int sueldo;
	private int ahorro;

	public Dxc(int ahorro, int sueldo){
		this.ahorro = ahorro;
		this.sueldo = sueldo;
	}

	public Dxc(int retiro, int sueldo, boolean fromRetiro){
		this.dxc = retiro;
		this.sueldo = sueldo;
	}

	public Dxc(int retiro, int ahorro, boolean fromRetiro, boolean fromAhorro){
		this.dxc = retiro;
		this.ahorro = ahorro;
	}

	public Dxc() {
	}

	public int getDxc() {
		return Util.getDxc(ahorro,sueldo);
	}

	public void setDxc(int dxc) {
		this.dxc = dxc;
	}

	public int getSaldo() throws Exception {
		return Util.getSaldo(dxc, ahorro);
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getImpuesto() {
		return Util.getImpuesto(dxc, sueldo);
	}
	public void setImpuesto(int impuesto) {
		this.impuesto = impuesto;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getAhorro() {
		return ahorro;
	}

	public void setAhorro(int ahorro) {
		this.ahorro = ahorro;
	}
}
