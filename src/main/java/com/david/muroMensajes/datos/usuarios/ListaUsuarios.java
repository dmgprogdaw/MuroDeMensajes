package com.david.muroMensajes.datos.usuarios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ListaUsuarios {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	private ArrayList<Usuario> lista = null;
	private static ListaUsuarios listaUsuarios = null;
	

	private ListaUsuarios(){
		
		lista = new ArrayList<Usuario>();
		

	}
	
	public List<Usuario> getDatos(){
		
		return lista;
	}
	
	public Usuario getUsuario(String nombreUsuario) {
		
		if(usuarioDAO.existsById(nombreUsuario)) {
			return lista.get(0);
		}
		else return null;
		
	}

	public void updateAutor (Usuario usuario) {
		
		int posicion = buscarDondeEsta(usuario.getNombreUsuario());
		lista.set(posicion, usuario);
	}
	

	private int buscarDondeEsta(String nombreUsuario) {
		
		// iniciamos con una bandera indicando que no esta encontrado
		boolean encontrado = false;
		int indice = 0;
		
		// mientras que no se encuentra y no llego al final
		while((!encontrado)&&(indice < lista.size())) {
			
			// lo voy buscando
			if(lista.get(indice).getNombreUsuario()==nombreUsuario) {
				
				encontrado = true;
			}
			
			// y si no aparece avanzo
			else indice ++;
		}
		if(encontrado) return indice; else return -1;
	}
	
	public static ListaUsuarios getLista(){
		
		if(listaUsuarios == null) {
			
			listaUsuarios = new ListaUsuarios();
		}
		return listaUsuarios;
	}
}
