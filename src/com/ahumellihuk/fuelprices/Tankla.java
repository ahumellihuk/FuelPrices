package com.ahumellihuk.fuelprices;

public class Tankla {
	
	String name;
	String address;
	int logo;
	boolean bens95, bens98, diisel, pood, kindlustus, gaas, kuumjook, kiirtoit, vesiohk;
	
	public Tankla(String name, String address, int logo) {
		
		this.name = name;
		this.address = address;
		this.logo = logo;
		pood = false;
		kindlustus = false;
		gaas = false;
		kuumjook = false;
		kiirtoit = false; 
		vesiohk = false;
		bens95 = false;
		bens98 = false;
		diisel = false;
	}
	
	public void setServices(boolean pood, boolean kindlustus, boolean gaas, boolean kuumjook, boolean kiirtoit, boolean vesiohk) {
		this.pood = pood;
		this.kindlustus = kindlustus;
		this.gaas = gaas;
		this.kiirtoit = kiirtoit;
		this.kuumjook = kuumjook;
		this.vesiohk = vesiohk;

	}
	
	public void setFuelTypes(boolean bens95, boolean bens98, boolean diisel) {
		this.bens95 = bens95;
		this.bens98 = bens98;
		this.diisel = diisel;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
	
}
