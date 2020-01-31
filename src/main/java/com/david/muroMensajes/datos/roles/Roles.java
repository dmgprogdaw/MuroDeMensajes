package com.david.muroMensajes.datos.roles;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.david.muroMensajes.datos.usuarios.Usuario;

@Entity
public class Roles {

	@Id
	@Column
	private int codigo;
	
	@Column
	private String nombreRol;
	
	@ManyToMany
	private List<Usuario> users = new ArrayList<Usuario>();
	
	public void addUsers(Usuario usuario) {
		
		if(!users.contains(usuario)) {
			
			users.add(usuario);
			usuario.addRol(this);
		}
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
