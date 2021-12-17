package PaquetesDeDatos;

import java.io.Serializable;

public class tipoArrayString implements Serializable{
	
	private final String tipo = "ArrayString";
	
	private String[] almacen;
	
	
	public String getTipo() {
		return tipo;
	}
	public String[] getAlmacen() {
		return almacen;
	}
	public void setAlmacen(String[] almacen) {
		this.almacen = almacen;
	}

}
