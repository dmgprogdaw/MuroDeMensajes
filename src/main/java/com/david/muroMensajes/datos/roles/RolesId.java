package com.david.muroMensajes.datos.roles;


import java.io.Serializable;

import com.david.muroMensajes.datos.usuarios.Usuario;

public class RolesId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Usuario usuario;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
