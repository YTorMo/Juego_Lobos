package PaquetesDeDatos;


import java.io.Serializable;
import java.util.*;

public class Datos_lobo implements Serializable{

	private String nick, rol;
	private String mensaje;
	private Boolean online;
	private int tipoChat;
	
	
	
	public int getTipoChat() {
		return tipoChat;
	}
	public void setTipoChat(int tipoChat) {
		this.tipoChat = tipoChat;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
	
	
}
