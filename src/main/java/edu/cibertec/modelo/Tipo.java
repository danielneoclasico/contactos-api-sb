package edu.cibertec.modelo;

public class Tipo {

	private int id;
	private String descrip;
	
	public Tipo(int id, String descrip) {
		super();
		this.id = id;
		this.descrip = descrip;
	}
	public Tipo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

}
