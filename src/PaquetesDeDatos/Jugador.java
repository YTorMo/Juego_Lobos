package PaquetesDeDatos;

import java.io.Serializable;
import java.net.InetAddress;

public class Jugador implements Serializable {
	
	
	private String nombre, rolN="", rolD, enamorado="", convertido="";
	private InetAddress IP_jugador;
	private int NJugadores;
	private Boolean vivo=true, poderN1, poderN2, poderD, hechizado=false,espiritista=false,seguidor=false,protegido=false,host;
	
	
	
	public InetAddress getIP_jugador() {
		return IP_jugador;
	}
	public void setIP_jugador(InetAddress iP_jugador) {
		IP_jugador = iP_jugador;
	}
	public Boolean getHost() {
		return host;
	}
	public String getConvertido() {
		return convertido;
	}
	public void setConvertido(String convertido) {
		this.convertido = convertido;
	}
	public Boolean getEspiritista() {
		return espiritista;
	}
	public void setEspiritista(Boolean espiritista) {
		this.espiritista = espiritista;
	}
	public Boolean getSeguidor() {
		return seguidor;
	}
	public void setSeguidor(Boolean seguidor) {
		this.seguidor = seguidor;
	}
	public Boolean getProtegido() {
		return protegido;
	}
	public void setProtegido(Boolean protegido) {
		this.protegido = protegido;
	}
	public void setHost(Boolean host) {
		this.host = host;
	}
	public int getNJugadores() {
		return NJugadores;
	}
	public void setNJugadores(int nJugadores) {
		NJugadores = nJugadores;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRolN() {
		return rolN;
	}
	public void setRolN(String rolN) {
		this.rolN = rolN;
	}
	public String getRolD() {
		return rolD;
	}
	public void setRolD(String rolD) {
		this.rolD = rolD;
	}
	public Boolean getVivo() {
		return vivo;
	}
	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}
	public Boolean getPoderN1() {
		return poderN1;
	}
	public void setPoderN1(Boolean poderN1) {
		this.poderN1 = poderN1;
	}
	public Boolean getPoderN2() {
		return poderN2;
	}
	public void setPoderN2(Boolean poderN2) {
		this.poderN2 = poderN2;
	}
	public Boolean getPoderD() {
		return poderD;
	}
	public void setPoderD(Boolean poderD) {
		this.poderD = poderD;
	}
	public String getEnamorado() {
		return enamorado;
	}
	public void setEnamorado(String enamorado) {
		this.enamorado = enamorado;
	}
	public Boolean getHechizado() {
		return hechizado;
	}
	public void setHechizado(Boolean hechizado) {
		this.hechizado = hechizado;
	}
	
}
