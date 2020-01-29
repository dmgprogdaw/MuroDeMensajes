package com.david.muroMensajes.datos.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.david.muroMensajes.datos.usuarios.Usuario;

@Entity
@IdClass(RolesId.class)
public class Roles {

	@Id
	@Column
	private String nombre;
	
	@Id
	@ManyToOne
	@JoinColumn(name="FK_ususario")
	private Usuario usuario;
	
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;

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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
